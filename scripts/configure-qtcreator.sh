#!/bin/bash
#############################################################################
##
## Copyright (C) 2014 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

set -e

MKSPEC="devices/linux-oe-generic-g++"
ABI="arm-linux-generic-elf-32bit"
### TBD: detect ABI

printUsage ()
{
    echo "Usage: $0 <toolchain-environment-setup-file> [--remove]"
}

while test -n "$1"; do
  case "$1" in
    "--help" | "-h")
      printUsage
      exit 0
      shift
      ;;
    "--remove")
      REMOVEONLY=1
      shift
      ;;
    *)
      CONFIG=$1
      shift
      ;;
  esac
done

if [ ! -f "$CONFIG" ]; then
   printUsage
   exit 1
fi

if [ -z "${SDKTOOL}" ]; then
    SDKTOOL="${HOME}/Qt/Tools/QtCreator/bin/sdktool"
fi
if [ ! -x ${SDKTOOL} ]; then
    echo "Cannot find 'sdktool'"
    exit 1
fi

source $CONFIG

if [ ! -d "${OECORE_NATIVE_SYSROOT}/mkspecs/${MKSPEC}" ]; then
    echo Error: $CONFIG is invalid.
    exit 1
fi

MACHINE=$(grep '^MACHINE' ${OECORE_NATIVE_SYSROOT}/mkspecs/qdevice.pri | cut -d'=' -f2 | tr -d ' ')

RELEASE=$(qmake -query QT_VERSION)

BASEID="byos.${RELEASE}.${MACHINE}"

BASENAME="Custom Qt Embedded"
TOOLCHAINNAME="GCC (${BASENAME} ${RELEASE} ${MACHINE})"
QTNAME="${BASENAME} ${RELEASE} ${MACHINE}"
KITNAME="${BASENAME} ${RELEASE} ${MACHINE} Kit"

${SDKTOOL} rmKit --id ${BASEID}.kit 2>/dev/null || true
${SDKTOOL} rmQt --id ${BASEID}.qt || true
${SDKTOOL} rmTC --id ProjectExplorer.ToolChain.Gcc:${BASEID}.tc || true

if [ -n "${REMOVEONLY}" ]; then
    echo "Kit removed: ${KITNAME}"
    exit 0
fi

${SDKTOOL} addTC \
    --id "ProjectExplorer.ToolChain.Gcc:${BASEID}.tc" \
    --name "${TOOLCHAINNAME}" \
    --path "$(type -p ${OE_QMAKE_CXX})" \
    --abi "${ABI}"

${SDKTOOL} addQt \
    --id "${BASEID}.qt" \
    --name "${QTNAME}" \
    --type "Boot2Qt.QtVersionType" \
    --qmake "$(type -p qmake)"

${SDKTOOL} addKit \
    --id "${BASEID}.kit" \
    --name "${KITNAME}" \
    --qt "${BASEID}.qt" \
    --debuggerengine "1" \
    --debugger "$(type -p ${GDB})" \
    --sysroot "${SDKTARGETSYSROOT}" \
    --devicetype "Boot2Qt.HwDevice" \
    --toolchain "ProjectExplorer.ToolChain.Gcc:${BASEID}.tc" \
    --icon ":/boot2qt/images/B2Qt_QtC_icon.png" \
    --mkspec "${MKSPEC}"

echo "Configured Qt Creator with new kit:"
echo "    ${KITNAME}"
