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
LIC_FILES_CHKSUM = "file://src/virtualkeyboard/plugin.cpp;md5=9e7c3707428a49f2fd857aa1538823b6;beginline=1;endline=17"

inherit qt5-module qtquickcompiler

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/qtvirtualkeyboard.git;branch=${QT_BRANCH};protocol=ssh \
    "

SRCREV = "ad517b66fc4aadb2807951f182552a1b161d9c95"
QT_BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative hunspell"

EXTRA_QMAKEVARS_PRE += "CONFIG+=disable-desktop"

FILES_${PN}-qmlplugins-dbg = " \
    ${OE_QMAKE_PATH_QML}/QtQuick/Enterprise/VirtualKeyboard/Styles/.debug/* \
    "
