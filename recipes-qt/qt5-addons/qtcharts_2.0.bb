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

DESCRIPTION = "Qt Charts"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/charts/qchart.cpp;md5=735b3be820c0a733e328a4d2e1e430de;beginline=1;endline=17"

inherit qt5-module qtquickcompiler

SRC_URI = " \
    git://qt-gerrit.it.local/QtRD-15810/charts.git;branch=${QT_BRANCH};protocol=ssh \
    "

SRCREV = "f818972d3617493c74d694184aa877f606e1a5a0"
QT_BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative qtmultimedia"

PACKAGES =+ "${PN}-designer"
DEBIAN_NOAUTONAME_${PN}-designer = "1"

FILES_${PN}-designer = " \
    ${OE_QMAKE_PATH_QML}/QtCharts/designer \
    "

RRECOMMENDS_${PN}-dev += "${PN}-designer"
