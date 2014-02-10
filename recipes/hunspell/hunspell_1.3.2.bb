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

SRC_URI = "http://downloads.sourceforge.net/hunspell/hunspell-${PV}.tar.gz;name=hunspell \
           http://ftp.halifax.rwth-aachen.de/gentoo/distfiles/myspell-en_GB-20081002.zip;name=dict-en \
           http://downloads.sourceforge.net/project/ayaspell/hunspell-ar/20080110/hunspell-ar_20080110.tar.gz;name=dict-ar \
          "

SRC_URI[hunspell.md5sum] = "3121aaf3e13e5d88dfff13fb4a5f1ab8"
SRC_URI[hunspell.sha256sum] = "b4edd4a4ee944cb9f485b35473e46b729ed768e9d24da8e78e4c4c6ca56addbd"
SRC_URI[dict-en.md5sum] = "6fb885d57899c3e6aa2b27f3510deb37"
SRC_URI[dict-en.sha256sum] = "f4b43083923e2998298fd270a8a9f9ed570f4fbebeaa46ce5f1788b76920308b"
SRC_URI[dict-ar.md5sum] = "69990932920960eb765fd35883640124"
SRC_URI[dict-ar.sha256sum] = "88d9eebbe05de29d17f4420ebaec9249441ce01d61b5d6c7ecba040e250e2d91"

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
