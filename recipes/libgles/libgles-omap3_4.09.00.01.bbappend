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

BINLOCATION_omap3  = "${S}/gfx_rel_es5.x"

LIBGLESWINDOWSYSTEM = "libpvrPVR2D_FLIPWSEGL.so.1"

do_install_append() {
	echo "ParamBufferSize=33554432" >> ${D}${sysconfdir}/powervr.ini
}

# Inhibit warnings about files being stripped.
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

pkg_postinst_${PN}_append() {
ESREV=$(echo ${BINLOCATION} | grep -Po '(\d+)(?!.*\d)' )
echo ${ESREV} > $D${sysconfdir}/powervr-esrev
}

RRECOMMENDS_${PN} = "omap3-sgx-modules"
RRECOMMENDS_${PN}-blitwsegl = ""
RRECOMMENDS_${PN}-flipwsegl = ""
RRECOMMENDS_${PN}-frontwsegl = ""
RRECOMMENDS_${PN}-linuxfbwsegl = ""
