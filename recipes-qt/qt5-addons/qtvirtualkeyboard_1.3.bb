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

DESCRIPTION = "Qt Virtual Keyboard"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/virtualkeyboard/plugin.cpp;md5=e0b36905c697f1be9c35712f4aced6e0;beginline=1;endline=17"

inherit qt5-module qtquickcompiler sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-qtvirtualkeyboard;branch=${BRANCH};protocol=ssh;sdk-uri=EnterpriseAddOns/QtVirtualKeyboard/1.3/Src \
    "

# v1.3.1
SRCREV = "c2c362d9f313441351e5e7167e22b4fd1b7012a8"
BRANCH = "1.3"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative hunspell"

EXTRA_QMAKEVARS_PRE += "CONFIG+=disable-desktop"
