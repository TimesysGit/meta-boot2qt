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
LIC_FILES_CHKSUM = "file://src/virtualkeyboard/plugin.cpp;md5=8913d0b71519756d2e83db02b9629bbd;beginline=1;endline=17"

inherit qt5-module qtquickcompiler sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-qtvirtualkeyboard;branch=${BRANCH};protocol=ssh;sdk-uri=EnterpriseAddOns/QtVirtualKeyboard/2.0/Src \
    "

SRCREV = "296f52c04968a06200f256dfaf58c563bf193f10"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative qtsvg hunspell"

EXTRA_QMAKEVARS_PRE += "CONFIG+=disable-desktop CONFIG+=pinyin CONFIG+=hangul CONFIG+=openwnn CONFIG+=tcime"

PACKAGES += "${PN}-dictionaries"
RRECOMMENDS_${PN} += "${PN}-dictionaries"
FILES_${PN}-dictionaries = "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/*/*.dat"
