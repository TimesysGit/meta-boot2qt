DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ea5743acf520dd81ca172e69f818a3d4"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require recipes-ti/includes/ti-eula-unpack.inc

SGXPV = "4_10_00_01"
IMGPV = "1.9.2188537"

inherit module

MACHINE_KERNEL_PR_append = "c"
PR = "${MACHINE_KERNEL_PR}"

DEFAULT_PREFERENCE = "-1"

# Select the corresponding hardfp/softfp filename and checksums based on tune flags
BINFILE_SOFTFP = "Graphics_SDK_setuplinux_${SGXPV}_minimal_demos.bin"
MD5SUM_SOFTFP = "bd35e9d8843aff3a2aca9d41e7db1c7d"
SHA256SUM_SOFTFP = "eb37f75ddde4640b09e760fa86e689beb394330ecdf68786188c34f249247647"

BINFILE_HARDFP = "Graphics_SDK_setuplinux_${SGXPV}_hardfp_minimal_demos.bin"
MD5SUM_HARDFP = "15a3ccb66e98580e474fc112565f66b6"
SHA256SUM_HARDFP = "4d94d5a1869b228ce12027783fc5425c92e9b66685c501247889f1f167e66c9d"

BINFILE = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '${BINFILE_HARDFP}', '${BINFILE_SOFTFP}', d)}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE} \
    file://Change-for-interfacing-with-SGX-DT-node.patch \
    file://linux-3.8.patch \
    file://0001-Graphics-SDK-04.10.00.01-AM335x-sgx-irq-change.patch \
    "

SRC_URI[md5sum] := "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '${MD5SUM_HARDFP}', '${MD5SUM_SOFTFP}', d)}"
SRC_URI[sha256sum] := "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '${SHA256SUM_HARDFP}', '${SHA256SUM_SOFTFP}', d)}"

TI_BIN_UNPK_WDEXT="/Graphics_SDK_${SGXPV}"
S = "${WORKDIR}${TI_BIN_UNPK_WDEXT}/GFX_Linux_KM"

PVRBUILD = "release"
export KERNELDIR = "${STAGING_KERNEL_DIR}"

INHIBIT_PACKAGE_STRIP = "1"

TI_PLATFORM_omap3 = "omap3630"
TI_PLATFORM_ti814x = "ti81xx"
TI_PLATFORM_ti816x = "ti81xx"
TI_PLATFORM_ti33x = "ti335x"

MODULESLOCATION_omap3 = "dc_omapfb3_linux"
MODULESLOCATION_ti814x = "dc_ti81xx_linux"
MODULESLOCATION_ti816x = "dc_ti81xx_linux"
MODULESLOCATION_ti33x = "dc_ti335x_linux"

MAKE_TARGETS = " BUILD=${PVRBUILD} TI_PLATFORM=${TI_PLATFORM} SUPPORT_XORG=0"

MAKE_TARGETS_append_ti33x = " PM_RUNTIME=1"

do_install() {
    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
    cp  ${S}/pvrsrvkm.ko \
        ${S}/services4/3rdparty/${MODULESLOCATION}/omaplfb.ko  \
        ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
        ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
