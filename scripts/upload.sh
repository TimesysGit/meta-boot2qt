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

set -x
set -e

RELEASE=4.x
UPLOADPATH=QT@ci-files02-hki.ci.local:/srv/jenkins_data/enterprise/b2qt/yocto-${RELEASE}/latest

if [ ${MACHINE} = "nitrogen6x" ]; then
  scp tmp/deploy/images/nitrogen6x/b2qt-embedded-image-boot-nitrogen6x.tar.gz ${UPLOADPATH}/b2qt-embedded-image-boot-iMX6.tar.gz
  scp tmp/deploy/images/nitrogen6x/b2qt-embedded-image-nitrogen6x.tar.gz ${UPLOADPATH}/b2qt-embedded-image-iMX6.tar.gz
  scp tmp/deploy/sdk/b2qt-eglibc-x86_64-meta-toolchain-b2qt-embedded-sdk-*.sh ${UPLOADPATH}/b2qt-eglibc-x86_64-arm-toolchain-iMX6.sh
elif [ ${MACHINE} = "emulator" ]; then
  cp tmp/deploy/images/emulator/b2qt-embedded-image-emulator.hdd .
  gzip b2qt-embedded-image-emulator.hdd -f
  scp b2qt-embedded-image-emulator.hdd.gz ${UPLOADPATH}/
  scp tmp/deploy/sdk/b2qt-eglibc-x86_64-meta-toolchain-b2qt-embedded-sdk-*.sh ${UPLOADPATH}/b2qt-eglibc-x86_64-i586-toolchain-${MACHINE}.sh
elif [ ${MACHINE} = "imx6qsabresd" ]; then
  cp tmp/deploy/images/imx6qsabresd/b2qt-embedded-image-boot-imx6qsabresd.tar.gz .
  cp tmp/deploy/images/imx6dlsabresd/u-boot.imx u-boot-imx6dlsabresd.imx
  gunzip b2qt-embedded-image-boot-imx6qsabresd.tar.gz
  tar -u --owner root --group root -f b2qt-embedded-image-boot-imx6qsabresd.tar ./u-boot-imx6dlsabresd.imx
  rm -f u-boot-imx6dlsabresd.imx
  gzip b2qt-embedded-image-boot-imx6qsabresd.tar
  scp b2qt-embedded-image-boot-${MACHINE}.tar.gz ${UPLOADPATH}/
  scp tmp/deploy/images/${MACHINE}/b2qt-embedded-image-${MACHINE}.tar.gz ${UPLOADPATH}/
  scp tmp/deploy/sdk/b2qt-eglibc-x86_64-meta-toolchain-b2qt-embedded-sdk-*.sh ${UPLOADPATH}/b2qt-eglibc-x86_64-arm-toolchain-${MACHINE}.sh
else
  scp tmp/deploy/images/${MACHINE}/b2qt-embedded-image-*${MACHINE}.tar.gz ${UPLOADPATH}/
  scp tmp/deploy/sdk/b2qt-eglibc-x86_64-meta-toolchain-b2qt-embedded-sdk-*.sh ${UPLOADPATH}/b2qt-eglibc-x86_64-arm-toolchain-${MACHINE}.sh
fi
