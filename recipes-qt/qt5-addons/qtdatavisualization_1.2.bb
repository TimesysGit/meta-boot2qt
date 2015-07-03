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
LIC_FILES_CHKSUM = "file://src/datavisualization/global/datavisualizationglobal_p.h;md5=5c8619ca9925b150dec6288f86c56471;beginline=1;endline=17"

inherit qt5-module sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-qtdatavis3d;branch=${BRANCH};protocol=ssh;sdk-uri=EnterpriseAddOns/QtDataVisualization/1.2/Src \
    "

# v1.2.1
SRCREV = "5ba7f70d0d94de720d49b37b2d257b51b9afd026"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative qtmultimedia"

FILES_${PN}-qmlplugins += " \
	${OE_QMAKE_PATH_QML}/QtDataVisualization/designer/* \
    "
