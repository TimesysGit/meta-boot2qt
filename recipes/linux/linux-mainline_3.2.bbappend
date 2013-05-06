
do_configure_prepend() {
	# Builtin network driver, so networking is initialized correctly during boot
	echo "CONFIG_USB_NET_SMSC95XX=y"      >> ${WORKDIR}/defconfig
}
