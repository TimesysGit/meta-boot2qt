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
LIC_FILES_CHKSUM = "file://src/charts/qchart.cpp;md5=6e3e95df24951a6ec145dc5614d29cac;beginline=1;endline=17"

inherit qt5-module qtquickcompiler sdk-sources

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/charts.git;branch=${BRANCH};protocol=ssh;sdk-uri=EnterpriseAddOns/Charts/2.0/Src \
    "

# v2.0.1
SRCREV = "c6eddd6a7ac5a67f77f52eae3a074c85fbf525a9"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative qtmultimedia"

PACKAGES =+ "${PN}-designer"
DEBIAN_NOAUTONAME_${PN}-designer = "1"

FILES_${PN}-designer = " \
    ${OE_QMAKE_PATH_QML}/QtCharts/designer \
    "

RRECOMMENDS_${PN}-dev += "${PN}-designer"
