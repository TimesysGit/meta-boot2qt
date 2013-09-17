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
