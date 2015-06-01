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

DESCRIPTION = "QtSimulator"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/simulator/version.h;md5=ba04e32af7257890758a149b0c14d11a;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/b2qt-qtsimulator.git;branch=${BRANCH};protocol=ssh \
    "

# v1.0.8
SRCREV = "faf8ea5cee8a4105b97c3f2ba4a4c828f03a70ab"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase"
