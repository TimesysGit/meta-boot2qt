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

while test -n "$1"; do
  case "$1" in
    "--help" | "-h")
      echo "Usage: . $0 [build directory]"
      return 0
      ;;
    *)
      BUILDDIR=$1
    ;;
  esac
  shift
done

THIS_SCRIPT="setup-environment.sh"
if [ "$(basename $0)" = "${THIS_SCRIPT}" ]; then
    echo "Error: This script needs to be sourced. Please run as '. $0'"
    exit 1
fi

BUILDDIR=${BUILDDIR:-build-${MACHINE}}

if [ -z "$MACHINE" ]; then
  echo "Error: MACHINE environment variable not defined"
  return 1
fi

if [ ! -f ${PWD}/${BUILDDIR}/conf/bblayers.conf ]; then
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

  mkdir -p ${PWD}/${BUILDDIR}/conf
  cp ${PWD}/sources/meta-b2qt/conf/${LAYERSCONF} ${PWD}/${BUILDDIR}/conf/bblayers.conf
fi

export TEMPLATECONF="${PWD}/sources/meta-b2qt/conf"
. sources/poky/oe-init-build-env ${BUILDDIR}

unset BUILDDIR
unset TEMPLATECONF
unset LAYERSCONF
