##############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: http://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:COMM$
##
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see http://www.qt.io/terms-conditions. For further
## information use the contact form at http://www.qt.io/contact-us.
##
## $QT_END_LICENSE$
##
##############################################################################

DESCRIPTION = "Qt Virtual Keyboard"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/virtualkeyboard/plugin.cpp;md5=8913d0b71519756d2e83db02b9629bbd;beginline=1;endline=17"

inherit qt5-module qtquickcompiler
require recipes-qt/qt5/qt5-git.inc

QT_MODULE_BRANCH = "5.6"
SRCREV = "214dc00d3e40fddba8acb2ea602aba705b1e3c81"

DEPENDS = "qtbase qtdeclarative qtsvg hunspell"

PACKAGECONFIG ?= "lipi-toolkit lang-all"
PACKAGECONFIG[lipi-toolkit] = "CONFIG+=lipi-toolkit"
PACKAGECONFIG[lang-all] = "CONFIG+=lang-all"

EXTRA_QMAKEVARS_PRE += "${EXTRA_OECONF}"
EXTRA_QMAKEVARS_PRE += "${@base_contains('DISTRO_FEATURES', 'x11', '', 'CONFIG+=disable-desktop', d)}"

PACKAGES += "${PN}-dictionaries"
RRECOMMENDS_${PN} += "${PN}-dictionaries"
FILES_${PN}-dictionaries = "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/*/*.dat"

FILES_${PN} += "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/lipi_toolkit"
FILES_${PN}-dbg += "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/lipi_toolkit/lib/.debug"
INSANE_SKIP_${PN} += "libdir"
INSANE_SKIP_${PN}-dbg += "libdir"
