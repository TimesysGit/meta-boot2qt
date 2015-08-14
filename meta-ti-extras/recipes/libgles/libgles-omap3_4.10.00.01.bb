require recipes-graphics/libgles/libgles-omap3-no-x.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${COREBASE}/../meta-ti/recipes-graphics/libgles/${PN}:"

LICENSE = "TI-TSPA"

PR = "${INC_PR}.3"

BINLOCATION_omap3 = "${S}/gfx_rel_es3.x"
BINLOCATION_ti816x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti814x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti33x = "${S}/gfx_rel_es8.x"

PLATFORM = "LinuxARMV7"
PVR_INIT = "pvrsrvctl"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

SGXPV = "4_10_00_01"
IMGPV = "1.9.2188537"

TI_BIN_UNPK_WDEXT := "/Graphics_SDK_${SGXPV}"

# Select the corresponding hardfp/softfp filename and checksums based on tune flags
BINFILE_SOFTFP = "Graphics_SDK_setuplinux_${SGXPV}_minimal_demos.bin"
MD5SUM_SOFTFP = "bd35e9d8843aff3a2aca9d41e7db1c7d"
SHA256SUM_SOFTFP = "eb37f75ddde4640b09e760fa86e689beb394330ecdf68786188c34f249247647"

BINFILE_HARDFP = "Graphics_SDK_setuplinux_${SGXPV}_hardfp_minimal_demos.bin"
MD5SUM_HARDFP = "15a3ccb66e98580e474fc112565f66b6"
SHA256SUM_HARDFP = "4d94d5a1869b228ce12027783fc5425c92e9b66685c501247889f1f167e66c9d"

BINFILE = "${@base_contains('TUNE_FEATURES', 'callconvention-hard', '${BINFILE_HARDFP}', '${BINFILE_SOFTFP}', d)}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE} \
           file://cputype \
           file://rc.pvr \
           file://99-bufferclass.rules  \
"

SRC_URI[md5sum] := "${@base_contains('TUNE_FEATURES', 'callconvention-hard', '${MD5SUM_HARDFP}', '${MD5SUM_SOFTFP}', d)}"
SRC_URI[sha256sum] := "${@base_contains('TUNE_FEATURES', 'callconvention-hard', '${SHA256SUM_HARDFP}', '${SHA256SUM_SOFTFP}', d)}"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}"

LIBGLESWINDOWSYSTEM = "libpvrPVR2D_FRONTWSEGL.so.1"

do_configure_append() {
    # PLAT_CC might not have needed arguments, so use CC instead.
    for mak in $(find ${S} -name "*.mak" -o -name Makefile) ; do
        sed -i -e s:\$\(PLAT_CC\):\$\(CC\):g $mak
    done
}
