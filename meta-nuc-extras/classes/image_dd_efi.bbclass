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

DESCRIPTION = "Extends image_dd class to boot via GRUB-EFI and initramfs."
LICENSE = "CLOSED"

inherit image_dd

EXTRA_IMAGECMD_ext3 += "-L rootfs"
IMAGE_DEPENDS_ext3 += "initramfs-basic:do_rootfs"

IMAGE_CMD_ext3_prepend() {

    # https://www.kernel.org/doc/Documentation/x86/early-microcode.txt
    microcode="${@bb.utils.contains('MACHINE_FEATURES', 'intel-ucode', '${DEPLOY_DIR_IMAGE}/microcode.cpio ', '', d)}"
    cat ${microcode} ${DEPLOY_DIR_IMAGE}/${INITRAMFS_IMAGE}-${MACHINE}.cpio.gz > ${IMAGE_ROOTFS}/boot/initramfs
    chmod 0644 ${IMAGE_ROOTFS}/boot/initramfs
}

do_populate_boot() {

    mkdir -p ${WORKDIR}/EFI/BOOT/
    # Path where EFI firmware searches for EFI executable
    cp ${DEPLOY_DIR_IMAGE}/bootx64.efi ${WORKDIR}/EFI/BOOT/
    mcopy -s -i ${WORKDIR}/boot.img ${WORKDIR}/EFI ::/EFI
}

