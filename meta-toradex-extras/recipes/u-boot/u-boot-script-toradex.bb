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

LICENSE = "CLOSED"
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
COMPATIBLE_MACHINE = "(apalis-imx6|colibri-vf|colibri-imx6)"
