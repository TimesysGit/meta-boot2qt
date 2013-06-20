
do_configure_prepend() {
	# Use multitouch protocol for touchscreen that support it
	echo "CONFIG_TOUCHSCREEN_EGALAX_SINGLE_TOUCH=n"      >> ${WORKDIR}/defconfig
	echo "CONFIG_TOUCHSCREEN_FT5X06_SINGLE_TOUCH=n"      >> ${WORKDIR}/defconfig

	# FunctionFS for adb
	echo "CONFIG_USB_FUNCTIONFS=m"  >> ${WORKDIR}/defconfig
}
