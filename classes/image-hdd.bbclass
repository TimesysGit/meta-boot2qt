# need to define the dependency and the ROOTFS for directdisk
do_bootdirectdisk[depends] += "${PN}:do_rootfs"
ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.ext3"

SYSLINUX_ROOT = "root=/dev/hda2 "
SYSLINUX_PROMPT = "0"
SYSLINUX_TIMEOUT = "1"
SYSLINUX_LABELS = "boot"
LABELS_append = " ${SYSLINUX_LABELS} "

inherit image_types boot-directdisk

create_hdd_image () {
	ln -s ${IMAGE_NAME}.hdddirect ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.hdd
}

python do_hddimg() {
        bb.build.exec_func('create_hdd_image', d)
}

python build_syslinux_cfg_append () {
    import re

    try:
        cfgfile = file(cfile, 'r+')
    except OSError:
        raise bb.build.funcFailed('Unable to open %s' % (cfile))

    f_content = cfgfile.read()
    f_content = re.sub('tty0', 'ttyS0,115200', f_content)

    cfgfile.seek(0)
    cfgfile.write(f_content)
    cfgfile.close()
}

addtask hddimg after do_bootdirectdisk before do_build
do_hddimg[nostamp] = "1"
