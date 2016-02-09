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
