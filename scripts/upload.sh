#!/bin/sh
##############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: http://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:COMM$
##
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see http://www.qt.io/terms-conditions. For further
## information use the contact form at http://www.qt.io/contact-us.
##
## $QT_END_LICENSE$
##
##############################################################################

set -x
set -e

RELEASE=5.7
UPLOADPATH=QT@ci-files02-hki.ci.local:/srv/jenkins_data/enterprise/b2qt/yocto/${RELEASE}/

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
if [ -e tmp/deploy/sdk/b2qt-i686-mingw32-meta-toolchain-b2qt-${PROJECT}-qt5-sdk-${MACHINE}.7z ]; then
  rsync tmp/deploy/sdk/b2qt-i686-mingw32-meta-toolchain-b2qt-${PROJECT}-qt5-sdk-${MACHINE}.7z ${UPLOADPATH}/
fi
