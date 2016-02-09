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

DESCRIPTION = "Hunspell"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/hunspell-${PV}/COPYING;md5=ed3a37b3ba6d6be3e08ab45987cf1b88"

SRC_URI = "http://downloads.sourceforge.net/hunspell/hunspell-${PV}.tar.gz;name=hunspell \
           git://github.com/libreoffice/dictionaries.git;branch=libreoffice-4-3-2;name=dictionaries \
          "

SRC_URI[hunspell.md5sum] = "3121aaf3e13e5d88dfff13fb4a5f1ab8"
SRC_URI[hunspell.sha256sum] = "b4edd4a4ee944cb9f485b35473e46b729ed768e9d24da8e78e4c4c6ca56addbd"
# using branch libreoffice-4.3.2 for dictionaries
SRCREV_dictionaries = "aa497b3c345133a1dc180dfb95dd1b3677b92afa"

PR = "r0"

inherit autotools gettext

PACKAGES += "${PN}-dicts"
RRECOMMENDS_${PN} += "${PN}-dicts"
FILES_${PN}-dicts = "${datadir}/hunspell"

do_install_append() {
    install -m 0755 -d ${D}${datadir}/hunspell

    install -m 0755 ${WORKDIR}/git/ar/ar.dic ${D}${datadir}/hunspell/ar_EG.dic
    install -m 0755 ${WORKDIR}/git/ar/ar.aff ${D}${datadir}/hunspell/ar_EG.aff

    install -m 0755 ${WORKDIR}/git/en/en_GB.dic ${D}${datadir}/hunspell
    install -m 0755 ${WORKDIR}/git/en/en_GB.aff ${D}${datadir}/hunspell
}
