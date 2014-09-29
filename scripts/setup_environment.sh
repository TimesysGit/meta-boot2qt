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
  unset TEMPLATECONF
  unset LAYERSCONF
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

if [ ! -f ${CWD}/${BUILDDIR}/conf/bblayers.conf ]; then
  case ${MACHINE} in
    apalis-imx6)
      LAYERSCONF="bblayers.conf.toradex.sample"
    ;;
    imx53qsb|imx6qsabresd|nitrogen6x)
      LAYERSCONF="bblayers.conf.fsl.sample"
    ;;
    beagleboard|am335x-evm)
      LAYERSCONF="bblayers.conf.ti.sample"
    ;;
    beaglebone)
      LAYERSCONF="bblayers.conf.bbb.sample"
    ;;
    raspberrypi)
      LAYERSCONF="bblayers.conf.rpi.sample"
    ;;
    emulator)
      LAYERSCONF="bblayers.conf.emulator.sample"
    ;;
    *)
      LAYERSCONF="bblayers.conf.sample"
      echo "Unknown MACHINE, bblayers.conf might need manual editing"
    ;;
  esac

  mkdir -p ${CWD}/${BUILDDIR}/conf
  cp ${CWD}/sources/meta-b2qt/conf/${LAYERSCONF} ${CWD}/${BUILDDIR}/conf/bblayers.conf
fi

export TEMPLATECONF=${CWD}/sources/meta-b2qt/conf
cd sources/poky
. ./oe-init-build-env ${CWD}/${BUILDDIR}
clean
