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

DESCRIPTION = "Android Debug Bridge Daemon"
HOMEPAGE = "http://developer.android.com/tools/help/adb.html"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://adb/NOTICE;md5=2ddb23e63b1f9c3c46aaa4195f819a6d"

PV = "android-5.0.1_r1"
PR = "r0"
SRCREV = "${PV}"

RRECOMMENDS_${PN} += "kernel-module-g-ffs"
DEPENDS = "openssl libcap"

SRC_URI = "git://android.googlesource.com/platform/system/core;protocol=https;branch=lollipop-release;name=core \
           file://adbd.patch \
           file://Makefile.adbd \
           file://adb-init \
           file://defaults \
           file://adbd.service \
          "

S = "${WORKDIR}/git"

FILES_${PN} += "${bindir}/adbd"

do_configure() {
    if [ -n "${ADB_PRODUCTID}" ]; then
        sed -i -e 's/PRODUCT=.*/PRODUCT=${ADB_PRODUCTID}/' ${WORKDIR}/defaults
    fi
}

do_compile() {
    make -f ${WORKDIR}/Makefile.adbd -C adb
}

do_install() {
    install -m 0755 -d ${D}${bindir}/
    install -m 0755 ${WORKDIR}/git/adb/adbd ${D}${bindir}/
    install -m 0755 ${WORKDIR}/adb-init ${D}${bindir}/

    install -m 0755 -d ${D}${sysconfdir}/init.d
    ln -s ${bindir}/adb-init ${D}${sysconfdir}/init.d/

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/adbd.service ${D}${systemd_unitdir}/system/

    install -m 0755 -d ${D}${sysconfdir}/default
    install -m 0644 ${WORKDIR}/defaults ${D}${sysconfdir}/default/adbd
}

INITSCRIPT_NAME = "adb-init"
INITSCRIPT_PARAMS = "defaults 96"

SYSTEMD_SERVICE_${PN} = "adbd.service"

inherit update-rc.d systemd
