BINLOCATION_omap3  = "${S}/gfx_rel_es5.x"

TOOLCHAIN_PATH = "${STAGING_DIR_TARGET}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://0001-Add-GLchar-typedef.patch"
