#############################################################################
##
## Copyright (C) 2015 Digia Plc and/or its subsidiary(-ies).
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

DESCRIPTION = "SD-Card mount daemon for Emulator"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://sdcardmountd.h;md5=ba04e32af7257890758a149b0c14d11a;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/emulator;branch=${BRANCH};protocol=ssh \
    file://sdcardmountd.sh \
    file://sdcardmount.service \
    "

SRCREV = "89ca944fae7106a55803ddce6fd84447685b61e5"
BRANCH = "master"

S = "${WORKDIR}/git/src/helperlibs/sdcarddaemon"

DEPENDS = "qtbase qtsimulator"

do_install_append() {
    install -m 0755 -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/sdcardmountd.sh ${D}${sysconfdir}/init.d/

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/sdcardmount.service ${D}${systemd_unitdir}/system/
}

INITSCRIPT_NAME = "sdcardmountd.sh"
INITSCRIPT_PARAMS = "defaults 97 10"

SYSTEMD_SERVICE_${PN} = "sdcardmount.service"

inherit update-rc.d systemd
