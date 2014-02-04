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

DESCRIPTION = "Hunspell"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/hunspell-${PV}/COPYING;md5=ed3a37b3ba6d6be3e08ab45987cf1b88"

SRC_URI = "http://downloads.sourceforge.net/hunspell/hunspell-${PV}.tar.gz \
           http://ftp.halifax.rwth-aachen.de/gentoo/distfiles/myspell-en_GB-20081002.zip \
           http://downloads.sourceforge.net/project/ayaspell/hunspell-ar/20080110/hunspell-ar_20080110.tar.gz \
          "

SRC_URI[md5sum] = "69990932920960eb765fd35883640124"
SRC_URI[sha256sum] = "88d9eebbe05de29d17f4420ebaec9249441ce01d61b5d6c7ecba040e250e2d91"

PR = "r0"

inherit autotools gettext

PACKAGES += "${PN}-dicts"
RRECOMMENDS_${PN} += "${PN}-dicts"
FILES_${PN}-dicts = "${datadir}/hunspell"

do_install_append() {
	install -m 0755 -d ${D}${datadir}/hunspell

	install -m 0755 ${WORKDIR}/hunspell-ar_20080110/ar.dic ${D}${datadir}/hunspell/ar_EG.dic
	install -m 0755 ${WORKDIR}/hunspell-ar_20080110/ar.aff ${D}${datadir}/hunspell/ar_EG.aff

	install -m 0755 ${WORKDIR}/en_GB.dic ${D}${datadir}/hunspell
	install -m 0755 ${WORKDIR}/en_GB.aff ${D}${datadir}/hunspell
}
