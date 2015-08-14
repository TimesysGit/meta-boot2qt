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
    git://qt-gerrit.ci.local/QtRD-15810/qmlcompiler.git;branch=${BRANCH};protocol=ssh;name=compiler;destsuffix=git \
    git://qt-gerrit.ci.local/QtRD-15810/qtsdk-enterprise.git;branch=${BRANCH};protocol=ssh;name=sdk;destsuffix=git/compiler/license-checker \
    "

SRCREV_compiler = "cc3b348065e84242d772d53b5f9dcad88b0da33e"
BRANCH_compiler = "3.0"

SRCREV_sdk = "60cb1a7763b670108b17c7e1345394e424153bea"
BRANCH_sdk = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"

BBCLASSEXTEND = "native nativesdk"
