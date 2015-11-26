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

DESCRIPTION = "Qt Quick 2D Rendender"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/plugins/scenegraph/softwarecontext/softwarelayer.cpp;md5=1f253bc897054feebffbaf70ecd49af4;beginline=1;endline=17"

inherit qt5-module sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-scenegraph-raster;branch=${BRANCH};protocol=ssh;sdk-uri=EnterpriseAddOns/QtQuick2DRenderer/1.1/Src \
    "

SRCREV = "849ee6c976ba3574b1856eb9d16c2bd740a6d2e3"
BRANCH = "5.6"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"
