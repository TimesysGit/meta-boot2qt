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

SUMMARY = "Noto Sans CJK"
SECTION = "fonts"
HOMEPAGE = "http://www.google.com/get/noto"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE_OFL.txt;md5=55719faa0112708e946b820b24b14097"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

PV = "1.004"
SRC_URI = "https://noto-website-2.storage.googleapis.com/pkgs/NotoSansCJKsc-hinted.zip"

SRC_URI[md5sum] = "3a2e70a4cd1f4ca4b546146b8556dffb"
SRC_URI[sha256sum] = "89646c86a48c1d5d25d435c31d673695bbd5751534004e9746f7d4aa71402a8f"

S = "${WORKDIR}"

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${WORKDIR}/*.otf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/otf/noto"
