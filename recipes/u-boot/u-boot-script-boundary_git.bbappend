MACHINE = "nitrogen6x"

do_deploy_append () {
    cd ${DEPLOYDIR}
    rm -f 6x_bootscript 6x_upgrade
    ln -sf 6x_bootscript-${MACHINE}-${PV}-${PR} 6x_bootscript
    ln -sf 6x_upgrade-${MACHINE}-${PV}-${PR} 6x_upgrade
}

