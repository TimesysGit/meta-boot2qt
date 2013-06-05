BINLOCATION_omap3  = "${S}/gfx_rel_es5.x"

PROVIDES += "virtual/libgl"

LIBGLESWINDOWSYSTEM = "libpvrPVR2D_FLIPWSEGL.so.1"

do_install_append() {
	echo "ParamBufferSize=33554432" >> ${D}${sysconfdir}/powervr.ini
}

pkg_postinst_${PN}_append() {
ESREV=$(echo ${BINLOCATION} | grep -Po '(\d+)(?!.*\d)' )
echo ${ESREV} > $D${sysconfdir}/powervr-esrev
}
