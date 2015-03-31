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
LIC_FILES_CHKSUM = "file://src/plugins/scenegraph/softwarecontext/softwarelayer.cpp;md5=d90663d6d3096fe0989549d52fec6554;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/scenegraph-raster.git;branch=${QT_BRANCH};protocol=ssh \
    "

SRCREV = "97c310f3a18a5aaebf8c102ceaba1f6a093faf6b"
QT_BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"
