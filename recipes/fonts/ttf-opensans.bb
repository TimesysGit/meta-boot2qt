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

SUMMARY = "Open Sans Fonts"
SECTION = "fonts"
HOMEPAGE = "https://www.google.com/fonts"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "https://www.google.com/fonts/download?kit=3hvsV99qyKCBS55e5pvb3ltkqrIMaAZWyLYEoB48lSQ;downloadfilename=Open_Sans.zip"
# Google packs fonts package on demand which results in unpredictable md5sum, so disable checksum check
BB_STRICT_CHECKSUM = ""

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/truetype/opensans
    install -m 0644 ${WORKDIR}/*.ttf ${D}${datadir}/fonts/truetype/opensans
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/truetype/opensans"
