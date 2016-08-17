############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

inherit qtquickcompiler

SRCREV = "5e45faaf050752b18037ea518cd0b6909a9cc3ed"

# To enabled Nuance T9 Write support, you need to provide the licensed components
# and enable "t9write" in PACKAGECONFIG. This can be done in a separate .bbappend file.
# for example:
#T9WRITEPACKAGE = "${HOME}/Downloads/zzEval_QT_T9Write_Alpha_v750_20150916.zip"
#SRC_URI += "file://${T9WRITEPACKAGE};subdir=git/src/virtualkeyboard/3rdparty/t9write"
#PACKAGECONFIG = "t9write lang-all"

PACKAGECONFIG ?= "lipi-toolkit lang-all hunspell"
PACKAGECONFIG[hunspell] = ",CONFIG+=disable-hunspell,hunspell"
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

EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}"
EXTRA_QMAKEVARS_PRE += "${@base_contains('DISTRO_FEATURES', 'x11', '', 'CONFIG+=disable-desktop', d)}"

PACKAGES += "${PN}-dictionaries"
RRECOMMENDS_${PN} += "${PN}-dictionaries"
FILES_${PN}-dictionaries = "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/*/*.dat"

FILES_${PN} += "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/lipi_toolkit"
FILES_${PN}-dbg += "${OE_QMAKE_PATH_DATA}/qtvirtualkeyboard/lipi_toolkit/lib/.debug"
INSANE_SKIP_${PN} += "libdir"
INSANE_SKIP_${PN}-dbg += "libdir"
