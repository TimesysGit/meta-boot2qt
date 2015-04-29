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
    git://qt-gerrit.ci.local/QtRD-15810/qmlcompiler.git;branch=${QT_BRANCH};protocol=ssh;name=compiler;destsuffix=git \
    git://qt-gerrit.ci.local/QtRD-15810/qtsdk-enterprise.git;branch=${QT_BRANCH};protocol=ssh;name=sdk;destsuffix=git/compiler/license-checker \
    "

SRCREV_compiler = "60c13275dec85d8224ea5826ae5533d87c65e76e"
QT_BRANCH_compiler = "2.0"

SRCREV_sdk = "60cb1a7763b670108b17c7e1345394e424153bea"
QT_BRANCH_sdk = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"

BBCLASSEXTEND = "native nativesdk"
