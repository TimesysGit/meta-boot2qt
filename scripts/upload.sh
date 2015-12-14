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

RELEASE=5.6
UPLOADPATH=QT@ci-files02-hki.ci.local:/srv/jenkins_data/enterprise/b2qt/yocto/${RELEASE}/

if [ ${AUTOMOTIVE} = "true" ]; then
  PROJECT=automotive
else
  PROJECT=embedded
fi

if [ -e tmp/deploy/images/${MACHINE}/b2qt-${PROJECT}-qt5-image-${MACHINE}.hdd ]; then
  7z a -l b2qt-${PROJECT}-qt5-image-${MACHINE}.7z \
    $PWD/tmp/deploy/images/${MACHINE}/b2qt-${PROJECT}-qt5-image-${MACHINE}.hdd
elif [ -e tmp/deploy/images/${MACHINE}/b2qt-${PROJECT}-qt5-image-${MACHINE}.img ]; then
  7z a -l b2qt-${PROJECT}-qt5-image-${MACHINE}.7z \
    $PWD/tmp/deploy/images/${MACHINE}/b2qt-${PROJECT}-qt5-image-${MACHINE}.img \
    $PWD/tmp/deploy/images/${MACHINE}/b2qt-${PROJECT}-qt5-image-${MACHINE}.conf
elif [ ${MACHINE} == "nvidia-logan" ] && [ -e tmp/deploy/images/${MACHINE}/b2qt-${PROJECT}-qt5-image-${MACHINE}.tar.gz ]; then
  7z a -l b2qt-${PROJECT}-qt5-image-${MACHINE}.7z \
    $PWD/tmp/deploy/images/${MACHINE}/b2qt-${PROJECT}-qt5-image-${MACHINE}.tar.gz \
    $PWD/tmp/deploy/images/${MACHINE}/zImage
fi

if [ -e b2qt-${PROJECT}-qt5-image-${MACHINE}.7z ]; then
  rsync b2qt-${PROJECT}-qt5-image-${MACHINE}.7z ${UPLOADPATH}/
fi

if [ -e tmp/deploy/sdk/b2qt-x86_64-meta-toolchain-b2qt-${PROJECT}-qt5-sdk-${MACHINE}.sh ]; then
  rsync tmp/deploy/sdk/b2qt-x86_64-meta-toolchain-b2qt-${PROJECT}-qt5-sdk-${MACHINE}.sh ${UPLOADPATH}/
fi
