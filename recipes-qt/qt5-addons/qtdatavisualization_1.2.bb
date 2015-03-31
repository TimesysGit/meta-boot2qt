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

DESCRIPTION = "Qt Data Visualization"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/datavisualization/global/datavisualizationglobal_p.h;md5=b6f0a53c44e6ba165a7d2dbd58832be5;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://qt-gerrit.it.local/QtRD-15810/qtdatavis3d.git;branch=${QT_BRANCH};protocol=ssh \
    "

# v1.2.0
SRCREV = "62f90e25eec23cfac83985993f355feeac5b9f2c"
QT_BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative qtmultimedia"

FILES_${PN}-qmlplugins += " \
	${OE_QMAKE_PATH_QML}/QtDataVisualization/designer/* \
    "
