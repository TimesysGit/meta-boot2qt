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

DESCRIPTION = "VirtualBox Guest Additions for Linux: mount"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/VirtualBox-${PV}/COPYING;md5=e197d5641bb35b29d46ca8c4bf7f2660"

SRC_URI = "http://download.virtualbox.org/virtualbox/${PV}/VirtualBox-${PV}.tar.bz2 \
          file://mount-vboxsf.sh \
          "

SRC_URI[md5sum] = "cc053340f88922a11ad9d4fab56557bd"
SRC_URI[sha256sum] = "ea9569ec16cd6202ee61bcadb2506d31ac12fd343adb91565773a05eaaea9a36"

S = "${WORKDIR}/VirtualBox-${PV}/src/VBox/Additions/linux/sharedfolders"

do_compile() {
    ${CC} mount.vboxsf.c vbsfmount.c -o mount.vboxsf
}

do_install() {
    install -m 0755 -d ${D}${bindir}/
    install -m 0755 mount.vboxsf ${D}${bindir}/

    install -m 0755 -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/mount-vboxsf.sh ${D}${sysconfdir}/init.d/
}

INITSCRIPT_NAME = "mount-vboxsf.sh"
INITSCRIPT_PARAMS = "defaults 33"

inherit update-rc.d
