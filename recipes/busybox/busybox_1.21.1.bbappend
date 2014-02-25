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
SRC_URI += "\
    file://network.cfg \
    file://busybox-ifplugd.sh \
    file://ifplugd.action \
    "

PACKAGES =+ "${PN}-ifplugd"
FILES_${PN}-ifplugd = "\
    ${sysconfdir}/init.d/busybox-ifplugd.sh \
    ${sysconfdir}/etc/ifplugd/ifplugd.action \
    "

INITSCRIPT_PACKAGES += "${PN}-ifplugd"
INITSCRIPT_NAME_${PN}-ifplugd = "busybox-ifplugd.sh"

RRECOMMENDS_${PN} += "${PN}-ifplugd"

do_install_append () {
	install -m 0755 ${WORKDIR}/busybox-ifplugd.sh ${D}${sysconfdir}/init.d/

	install -d ${D}${sysconfdir}/ifplugd
	install -m 0755 ${WORKDIR}/ifplugd.action ${D}${sysconfdir}/ifplugd/
}
