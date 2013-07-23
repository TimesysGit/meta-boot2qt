BINLOCATION_omap3  = "${S}/gfx_rel_es5.x"

PROVIDES += "virtual/libgl"

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
