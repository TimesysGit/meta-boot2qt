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

ABI="arm-linux-generic-elf-32bit"
CONFIG=""

printUsage ()
{
    echo "Usage: $0 --config <environment-setup-file> [--remove] [--qtcreator <path>] [--name <basename>]"
}

while test -n "$1"; do
  case "$1" in
    "--remove")
      REMOVEONLY=1
      ;;
    "--qtcreator")
      shift
      QTCREATOR=$1
      ;;
    "--config")
      shift
      CONFIG=$1
      ;;
    "--name")
      shift
      NAME=$1
      ;;
    *)
      printUsage
      exit 0
      ;;
  esac
  shift
done

if [ ! -f "$CONFIG" ]; then
   printUsage
   exit 1
fi

if [ -z "${QTCREATOR}" ]; then
    SDKTOOL="${HOME}/Qt/Tools/QtCreator/libexec/qtcreator/sdktool"
else
    SDKTOOL="${QTCREATOR}/libexec/qtcreator/sdktool"
fi
if [ ! -x ${SDKTOOL} ]; then
    echo "Cannot find 'sdktool' from QtCreator"
    printUsage
    exit 1
fi

source $CONFIG

MKSPEC="devices/linux-oe-generic-g++"
MKSPECPATH=$(find ${OECORE_TARGET_SYSROOT} -name $(basename ${MKSPEC}))
if [ ! -d "${MKSPECPATH}" ]; then
    echo "Error: could not find mkspec ${MKSPEC} from the toolchain"
    exit 1
fi

MACHINE=$(grep '^MACHINE' ${MKSPECPATH}/../../qdevice.pri | cut -d'=' -f2 | tr -d ' ')

RELEASE=$(qmake -query QT_VERSION)

NAME=${NAME:-"Custom Qt ${RELEASE} ${MACHINE}"}
BASEID="byos.${RELEASE}.${MACHINE}"

${SDKTOOL} rmKit --id ${BASEID}.kit 2>/dev/null || true
${SDKTOOL} rmQt --id ${BASEID}.qt || true
${SDKTOOL} rmTC --id ProjectExplorer.ToolChain.Gcc:${BASEID}.tc || true

if [ -n "${REMOVEONLY}" ]; then
    echo "Kit removed: ${NAME}"
    exit 0
fi

${SDKTOOL} addTC \
    --id "ProjectExplorer.ToolChain.Gcc:${BASEID}.tc" \
    --name "GCC (${NAME})" \
    --path "$(type -p ${OE_QMAKE_CXX})" \
    --abi "${ABI}"

${SDKTOOL} addQt \
    --id "${BASEID}.qt" \
    --name "${NAME}" \
    --type "Boot2Qt.QtVersionType" \
    --qmake "$(type -p qmake)"

${SDKTOOL} addKit \
    --id "${BASEID}.kit" \
    --name "${NAME}" \
    --qt "${BASEID}.qt" \
    --debuggerengine "1" \
    --debugger "$(type -p ${GDB})" \
    --sysroot "${SDKTARGETSYSROOT}" \
    --devicetype "Boot2Qt.HwDevice" \
    --toolchain "ProjectExplorer.ToolChain.Gcc:${BASEID}.tc" \
    --icon ":/boot2qt/images/B2Qt_QtC_icon.png" \
    --mkspec "${MKSPEC}"

echo "Configured Qt Creator with new kit: ${NAME}"
