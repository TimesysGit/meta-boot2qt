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

# Workaround for QTBUG-55471
export QV4_NO_SSA = "1"

SRCREV = "68c30e00b0d9850643611d5ba9c29a247ccd44ec"

DEPENDS = "qtbase qtdeclarative qtsvg hunspell"

PACKAGECONFIG ?= "lipi-toolkit lang-all"
PACKAGECONFIG[t9write] = "CONFIG+=t9write"
PACKAGECONFIG[lipi-toolkit] = "CONFIG+=lipi-toolkit"
PACKAGECONFIG[lang-all] = "CONFIG+=lang-all"
PACKAGECONFIG[lang-ar_AR] = "CONFIG+=lang-ar_AR"
PACKAGECONFIG[lang-da_DK] = "CONFIG+=lang-da_DK"
PACKAGECONFIG[lang-de_DE] = "CONFIG+=lang-de_DE"
PACKAGECONFIG[lang-en_GB] = "CONFIG+=lang-en_GB"
PACKAGECONFIG[lang-es_ES] = "CONFIG+=lang-es_ES"
PACKAGECONFIG[lang-fa_FA] = "CONFIG+=lang-fa_FA"
PACKAGECONFIG[lang-fi_FI] = "CONFIG+=lang-fi_FI"
PACKAGECONFIG[lang-fr_FR] = "CONFIG+=lang-fr_FR"
PACKAGECONFIG[lang-hi_IN] = "CONFIG+=lang-hi_IN"
PACKAGECONFIG[lang-it_IT] = "CONFIG+=lang-it_IT"
PACKAGECONFIG[lang-ja_JP] = "CONFIG+=lang-ja_JP"
PACKAGECONFIG[lang-ko_KR] = "CONFIG+=lang-ko_KR"
PACKAGECONFIG[lang-nb_NO] = "CONFIG+=lang-nb_NO"
PACKAGECONFIG[lang-pl_PL] = "CONFIG+=lang-pl_PL"
PACKAGECONFIG[lang-pt_PT] = "CONFIG+=lang-pt_PT"
PACKAGECONFIG[lang-ru_RU] = "CONFIG+=lang-ru_RU"
PACKAGECONFIG[lang-sv_SE] = "CONFIG+=lang-sv_SE"
PACKAGECONFIG[lang-zh_CN] = "CONFIG+=lang-zh_CN"
PACKAGECONFIG[lang-zh_TW] = "CONFIG+=lang-zh_TW"

EXTRA_QMAKEVARS_PRE += "${EXTRA_OECONF}"
EXTRA_QMAKEVARS_PRE += "${@base_contains('DISTRO_FEATURES', 'x11', '', 'CONFIG+=disable-desktop', d)}"

PACKAGES += "${PN}-dictionaries"
RRECOMMENDS_${PN} += "${PN}-dictionaries"
FILES_${PN}-dictionaries = "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/*/*.dat"

FILES_${PN} += "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/lipi_toolkit"
FILES_${PN}-dbg += "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/lipi_toolkit/lib/.debug"
INSANE_SKIP_${PN} += "libdir"
INSANE_SKIP_${PN}-dbg += "libdir"
