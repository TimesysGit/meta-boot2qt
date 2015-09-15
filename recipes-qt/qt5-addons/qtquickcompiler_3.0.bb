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
LIC_FILES_CHKSUM = "file://compiler/qtquickcompiler.h;md5=553f8ee8d120874969caca3193ae686c;beginline=1;endline=6"

inherit qt5-module

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/qmlcompiler.git;branch=${BRANCH};protocol=ssh;destsuffix=git \
    "

# v3.0.0
SRCREV = "7e29e55c8315cc5e944505f13c24893d0f54efeb"
BRANCH = "3.0"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"

BBCLASSEXTEND = "native nativesdk"
