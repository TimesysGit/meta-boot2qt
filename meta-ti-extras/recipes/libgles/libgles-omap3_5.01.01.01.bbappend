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

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

BINLOCATION_omap3  = "${S}/gfx_rel_es5.x"
BINLOCATION_beaglebone  = "${S}/gfx_rel_es8.x"

LIBGLESWINDOWSYSTEM = "libpvrPVR2D_FLIPWSEGL.so.1"

# Inhibit warnings about files being stripped.
INHIBIT_PACKAGE_STRIP = "1"

pkg_postinst_${PN}_append() {
ESREV=$(echo ${BINLOCATION} | grep -Po '(\d+)(?!.*\d)' )
echo ${ESREV} > $D${sysconfdir}/powervr-esrev
}

RRECOMMENDS_${PN} = "omap3-sgx-modules"
RRECOMMENDS_${PN}-blitwsegl = ""
RRECOMMENDS_${PN}-flipwsegl = ""
RRECOMMENDS_${PN}-frontwsegl = ""
RRECOMMENDS_${PN}-linuxfbwsegl = ""
