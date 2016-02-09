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

DESCRIPTION = "Virtual input plugin for QtSimulator"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://qvinput.h;md5=ba04e32af7257890758a149b0c14d11a;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/emulator;branch=${BRANCH};protocol=ssh \
    "

SRCREV = "89ca944fae7106a55803ddce6fd84447685b61e5"
BRANCH = "master"

EXTRA_QMAKEVARS_PRE += "CONFIG+=force_independent"

S = "${WORKDIR}/git/src/helperlibs/vinput"

DEPENDS = "qtbase qtsimulator"
