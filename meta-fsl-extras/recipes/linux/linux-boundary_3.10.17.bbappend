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
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

FILESEXTRAPATHS_prepend := "${THISDIR}/../../../recipes/linux/linux:"
SRC_URI += "\
    file://ARM-perf-add-support-for-perf-registers-API.diff \
    file://ARM-perf-wire-up-perf_regs-and-unwind-support-for-AR.patch \
    "

# kernel image files are not needed in the image
RDEPENDS_kernel-base = ""

LOCALVERSION = "-1.0.2_ga+yocto"
SRCBRANCH = "boundary-imx_3.10.17_1.0.2_ga"
SRCREV = "4ed13da788a463b1c5b6b26ecc2524d500ad1e9b"

do_configure_prepend() {
	# fix imx-vpu break on video decoding
	echo "CONFIG_VMSPLIT_2G=y"              >> ${WORKDIR}/defconfig

	# include H4 UART for Broadcom BT on Nitrogen6_Lite
	echo "CONFIG_BT_HCIUART_H4=y"           >> ${WORKDIR}/defconfig

	# include Broadcom WiFi for Nitrogen6_Lite
	echo "CONFIG_BRCMFMAC=m"                >> ${WORKDIR}/defconfig

	# include LEDS_GPIO for Nitrogen6_Lite
	echo "CONFIG_LEDS_GPIO=y"               >> ${WORKDIR}/defconfig
}
