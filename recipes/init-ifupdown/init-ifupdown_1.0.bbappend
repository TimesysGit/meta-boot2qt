FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://fixed_mac_address"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/fixed_mac_address ${D}${sysconfdir}/network/if-pre-up.d/
}
