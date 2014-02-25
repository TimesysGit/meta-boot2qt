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

DESCRIPTION = "VirtualBox Guest Additions for Linux: mount"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/VirtualBox-${PV}/COPYING;md5=e197d5641bb35b29d46ca8c4bf7f2660"

SRC_URI = "http://download.virtualbox.org/virtualbox/${PV}/VirtualBox-${PV}.tar.bz2 \
          file://mount-vboxsf.sh \
          "

SRC_URI[md5sum] = "be834de415adaf2f696f7a499f88b4e6"
SRC_URI[sha256sum] = "f8f6dc19612f3c84a5c857b8e5c452b8db2cf3c8c52a678b6a00e5dd5831130d"

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
