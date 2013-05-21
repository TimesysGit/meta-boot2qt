
do_configure_prepend() {
	# Builtin network driver, so networking is initialized correctly during boot
	echo "CONFIG_USB_NET_SMSC95XX=y"      >> ${WORKDIR}/defconfig

	# Remove beagleboard logo
	if [ -e ${WORKDIR}/${LOGO_SIZE}/logo_linux_clut224.ppm ]; then
		rm ${WORKDIR}/${LOGO_SIZE}/logo_linux_clut224.ppm
	fi
}
