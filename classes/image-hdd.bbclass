##############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: http://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:COMM$
##
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see http://www.qt.io/terms-conditions. For further
## information use the contact form at http://www.qt.io/contact-us.
##
## $QT_END_LICENSE$
##
##############################################################################

# need to define the dependency and the ROOTFS for directdisk
do_bootdirectdisk[depends] += "${PN}:do_rootfs"
ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.ext3"

SYSLINUX_ROOT = "root=/dev/hda2 "
SYSLINUX_PROMPT = "0"
SYSLINUX_TIMEOUT = "1"
SYSLINUX_LABELS = "boot"
LABELS_append = " ${SYSLINUX_LABELS} "
SYSLINUX_DEFAULT_CONSOLE = "console=ttyS0,115200"

inherit image_types boot-directdisk

create_hdd_image () {
    cd ${DEPLOY_DIR_IMAGE}
    rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.hdd
    ln -s ${IMAGE_NAME}.hdddirect ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.hdd
}

python do_hddimg() {
        bb.build.exec_func('create_hdd_image', d)
}

addtask hddimg after do_bootdirectdisk before do_build
