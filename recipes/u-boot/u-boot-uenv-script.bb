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

DESCRIPTION = "U-Boot script to start up BeagleBone Black"
LICENSE = "CLOSED"
PR = "r0"

COMPATIBLE_MACHINE = "(beaglebone)"
PV = "20140225"

SRC_URI = "file://uEnv.txt"

inherit deploy

do_deploy () {
    install -d ${DEPLOYDIR}
    install ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/uEnv-${MACHINE}-${PV}-${PR}.txt

    cd ${DEPLOYDIR}
    rm -f uEnv-${MACHINE}.txt
    ln -sf uEnv-${MACHINE}-${PV}-${PR}.txt uEnv-${MACHINE}.txt
}

addtask deploy after do_install before do_build

do_compile[noexec] = "1"
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
