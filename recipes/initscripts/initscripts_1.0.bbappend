do_configure_append() {
	sed -i -e "/echo/d" ${WORKDIR}/banner.sh
}
