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

DESCRIPTION = "Qt IVI"
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://header.LGPL3-PELAGICORE;md5=0f5beb4df202cb6ef5cbc5296f3a3fa4"

inherit qt5-module sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-qtivi;branch=${BRANCH};protocol=ssh;sdk-uri=5.6/Src/qtivi \
    "

SRCREV = "2d378320dc07b8b3ac9a9ce89b7f7a99caa72f8a"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"
