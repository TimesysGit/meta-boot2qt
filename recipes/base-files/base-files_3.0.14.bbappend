FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append() {
       ln -s /home/root ${D}/root
       echo ${MACHINE_HOSTNAME} > ${D}${sysconfdir}/hostname
}

