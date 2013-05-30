BINLOCATION_omap3  = "${S}/gfx_rel_es5.x"

TOOLCHAIN_PATH = "${STAGING_DIR_TARGET}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://0001-Add-GLchar-typedef.patch"

PROVIDES += "virtual/libgl"

LIBGLESWINDOWSYSTEM = "libpvrPVR2D_FLIPWSEGL.so.1"

pkg_postinst_${PN}_append() {
ESREV=$(echo ${BINLOCATION} | grep -Po '(\d+)(?!.*\d)' )
echo ${ESREV} > $D${sysconfdir}/powervr-esrev
}
