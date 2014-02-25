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

do_configure_append() {
	# FunctionFS for adb
	echo "CONFIG_USB_LIBCOMPOSITE=y"        >> ${S}/.config
	echo "CONFIG_USB_FUNCTIONFS=m"          >> ${S}/.config
	echo "CONFIG_USB_FUNCTIONFS_ETH=n"      >> ${S}/.config
	echo "CONFIG_USB_FUNCTIONFS_RNDIS=n"    >> ${S}/.config
	echo "CONFIG_USB_FUNCTIONFS_GENERIC=y"  >> ${S}/.config

	echo "CONFIG_DEVTMPFS=y"                >> ${S}/.config

	yes '' | oe_runmake oldconfig
}
