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

LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://${QT_LICENSE};md5=80e06902b5f0e94ad0a78ee4f7fcb74b"
DEPENDS = "u-boot-mkimage-native"

PV = "v2.6"

SRC_URI = " \
    file://fwd_mmc.scr \
    file://fwd_blk.scr \
    file://fwd_eth.scr \
    file://flash_blk.scr \
    file://flash_eth.scr \
    file://0001-Update-only-u-boot.patch \
    "

S = "${WORKDIR}"

inherit deploy

do_mkimage () {
    for scr in ${WORKDIR}/*.scr; do
        uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "update script" -d ${scr} \
                  $(basename ${scr} .scr).img
    done
}

addtask mkimage after do_compile before do_install

do_deploy () {
    install -d ${DEPLOYDIR}/${MACHINE}
    install -m 0644 -t ${DEPLOYDIR} ${S}/*.img
    ln -s ../flash_blk.img ${DEPLOYDIR}/${MACHINE}/
    ln -s ../flash_eth.img ${DEPLOYDIR}/${MACHINE}/
}

addtask deploy after do_install before do_build

do_compile[noexec] = "1"
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(apalis-imx6|colibri-vf|colibri-imx6|colibri-imx7)"
