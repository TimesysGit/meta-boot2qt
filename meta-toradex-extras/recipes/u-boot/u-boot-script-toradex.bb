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
## http://qt.digia.com/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

LICENSE = "CLOSED"
DEPENDS = "u-boot-mkimage-native"

PV = "v2.3"

SRC_URI = "file://flash_mmc.scr"

inherit deploy

UPDATESCRIPT = "${WORKDIR}/flash_mmc.scr"

do_mkimage () {
    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "update script" -d ${UPDATESCRIPT} \
                  flash_mmc.img
}

addtask mkimage after do_compile before do_install

do_deploy () {
    install -d ${DEPLOYDIR}
    install ${S}/flash_mmc.img ${DEPLOYDIR}/flash_mmc-${MACHINE}-${PV}-${PR}.img

    cd ${DEPLOYDIR}
    rm -f flash_mmc-${MACHINE}.img
    ln -sf flash_mmc-${MACHINE}-${PV}-${PR}.img flash_mmc-${MACHINE}.img
}

addtask deploy after do_install before do_build

do_compile[noexec] = "1"
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(apalis-imx6)"
