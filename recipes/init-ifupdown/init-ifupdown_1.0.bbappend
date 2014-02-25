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

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_beagleboard = " file://fixed_mac_address"

do_install_append_beagleboard() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/fixed_mac_address ${D}${sysconfdir}/network/if-pre-up.d/
}
