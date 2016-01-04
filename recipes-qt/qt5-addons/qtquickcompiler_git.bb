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

DESCRIPTION = "Qt Quick Compiler"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://compiler/qtquickcompiler.h;md5=02f6307ab0d6c4bd38a1540f16ea705d;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-qmlcompiler;branch=${BRANCH};protocol=ssh \
    "

# v5.6.0
SRCREV = "cd525cef2026cddb8d8c2a3b9532967dbb676460"
BRANCH = "5.6"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"

BBCLASSEXTEND = "native nativesdk"
