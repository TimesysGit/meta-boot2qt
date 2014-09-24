#!/bin/sh
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
## http://qt.digia.com/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

usage() {
  echo "source setup-environment <build-dir>"
}

clean() {
  unset BUILDDIR
  unset NEWBUILD
  unset TEMPLATECONF
}

CWD=`pwd`

while test -n "$1"; do
  case "$1" in
    "--help" | "-h")
      usage
      return 0
      ;;
    *)
      BUILDDIR=$1
    ;;
  esac
  shift
done

if [ -z "${BUILDDIR}" ]; then
  usage
  return 1
fi

if [ -z "$MACHINE" ]; then
  echo "MACHINE environment variable not defined"
  clean
  return 1
fi

if [ ! -d ${CWD}/${BUILDDIR} ]; then
  NEWBUILD=1
fi

export TEMPLATECONF=${CWD}/sources/meta-b2qt/conf
cd sources/poky
. ./oe-init-build-env ${CWD}/${BUILDDIR}

if [ -n "${NEWBUILD}" ]; then
  case ${MACHINE} in
    apalis-imx6)
      LAYERS="meta-raspberrypi meta-beagleboard meta-ti"
    ;;
    imx53qsb|imx6qsabresd|nitrogen6x)
      LAYERS="meta-raspberrypi meta-beagleboard meta-toradex meta-ti"
    ;;
    beagleboard|am335x-evm)
      LAYERS="meta-raspberrypi meta-beagleboard meta-toradex meta-fsl"
    ;;
    beaglebone)
      LAYERS="meta-raspberrypi meta-toradex meta-fsl"
    ;;
    raspberrypi)
      LAYERS="meta-beagleboard meta-toradex meta-ti meta-fsl"
    ;;
    emulator)
      LAYERS="meta-raspberrypi meta-beagleboard meta-toradex meta-ti meta-fsl"
    ;;
    *)
      echo "Unknown MACHINE, bblayer.conf might need manual editing"
    ;;
  esac

  for layer in ${LAYERS}; do
    sed -i -e "/${layer}/d" conf/bblayers.conf
  done
fi

clean
