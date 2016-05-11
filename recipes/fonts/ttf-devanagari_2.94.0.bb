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

SUMMARY = "Lohit Devanagari Fonts"
SECTION = "fonts"
HOMEPAGE = "https://fedorahosted.org/lohit/"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${WORKDIR}/lohit-devanagari-ttf-${PV}/OFL.txt;md5=7dfa0a236dc535ad2d2548e6170c4402"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "https://fedorahosted.org/releases/l/o/lohit/lohit-devanagari-ttf-${PV}.tar.gz"

SRC_URI[md5sum] = "57527ee536a18b443cf786d4b8fd5ec8"
SRC_URI[sha256sum] = "a6618aeb1d25df46d3c22e528c38ea1d1147654e19904497a1e97f4684c55353"

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/truetype/lohit
    install -m 0755 -d ${D}${sysconfdir}/fonts/conf.d/
    install -m 0644 ${WORKDIR}/lohit-devanagari-ttf-${PV}/66-lohit-devanagari.conf ${D}${sysconfdir}/fonts/conf.d/
    install -m 0644 ${WORKDIR}/lohit-devanagari-ttf-${PV}/Lohit-Devanagari.ttf ${D}${datadir}/fonts/truetype/lohit
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/truetype/lohit"
