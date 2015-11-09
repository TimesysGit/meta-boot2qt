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
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

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
