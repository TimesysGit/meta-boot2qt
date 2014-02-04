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

do_configure_prepend() {
	# Builtin network driver, so networking is initialized correctly during boot
	echo "CONFIG_USB_NET_SMSC95XX=y"        >> ${WORKDIR}/defconfig

	# FunctionFS for adb
	echo "CONFIG_USB_FUNCTIONFS_ETH=n"      >> ${WORKDIR}/defconfig
	echo "CONFIG_USB_FUNCTIONFS_RNDIS=n"    >> ${WORKDIR}/defconfig
	echo "CONFIG_USB_FUNCTIONFS_GENERIC=y"  >> ${WORKDIR}/defconfig

	# Remove beagleboard logo
	if [ -e ${WORKDIR}/${LOGO_SIZE}/logo_linux_clut224.ppm ]; then
		rm ${WORKDIR}/${LOGO_SIZE}/logo_linux_clut224.ppm
	fi
}
