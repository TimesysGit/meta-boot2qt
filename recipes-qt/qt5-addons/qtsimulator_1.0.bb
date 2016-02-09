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

DESCRIPTION = "QtSimulator"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/simulator/version.h;md5=ba04e32af7257890758a149b0c14d11a;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/qtsimulator;branch=${BRANCH};protocol=ssh \
    "

# v1.0.8
SRCREV = "faf8ea5cee8a4105b97c3f2ba4a4c828f03a70ab"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase"
