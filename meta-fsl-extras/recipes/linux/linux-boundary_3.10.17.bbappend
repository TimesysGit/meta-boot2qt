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

# kernel image files are not needed in the image
RDEPENDS_kernel-base = ""

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
