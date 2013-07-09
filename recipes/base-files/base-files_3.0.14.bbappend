do_install_append() {
       ln -s /home/root ${D}/root
       echo ${MACHINE_HOSTNAME} > ${D}${sysconfdir}/hostname
}
