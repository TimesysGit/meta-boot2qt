############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

# This class is based on meta-fsl-arm/classes/image_types_fsl.bbclass::generate_imx_sdcard()
DESCRIPTION = "The base class for building images that can be deployed with GNU coreutils dd tool."
inherit image_types

IMAGE="${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.img"

# Boot partition size [in KiB]
BOOT_SPACE ?= "8192"

# Set alignment to 4MB [in KiB]
IMAGE_ROOTFS_ALIGNMENT = "4096"

# Boot partition volume id
BOOTDD_VOLUME_ID = "boot"

IMAGE_TYPEDEP_dd = "ext3"
IMAGE_DEPENDS_dd = "parted-native:do_populate_sysroot \
                    dosfstools-native:do_populate_sysroot \
                    mtools-native:do_populate_sysroot"

image_dd_do_populate_boot() {
}
EXPORT_FUNCTIONS do_populate_boot

IMAGE_CMD_dd() {

    ROOTFS="${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"

    # Align boot partition and calculate total binary image size
    BOOT_SPACE_ALIGNED=$(expr ${BOOT_SPACE} + ${IMAGE_ROOTFS_ALIGNMENT} - 1)
    BOOT_SPACE_ALIGNED=$(expr ${BOOT_SPACE_ALIGNED} - ${BOOT_SPACE_ALIGNED} % ${IMAGE_ROOTFS_ALIGNMENT})
    IMAGE_SIZE=$(expr ${IMAGE_ROOTFS_ALIGNMENT} + ${BOOT_SPACE_ALIGNED} + $ROOTFS_SIZE + ${IMAGE_ROOTFS_ALIGNMENT})

    # Initialize a sparse file
    dd if=/dev/zero of=${IMAGE} bs=1 count=0 seek=$(expr 1024 \* ${IMAGE_SIZE})

    # Create partition table
    parted -s ${IMAGE} mklabel msdos
    parted -s ${IMAGE} unit KiB mkpart primary fat32 ${IMAGE_ROOTFS_ALIGNMENT} $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED})
    parted -s ${IMAGE} unit KiB mkpart primary $(expr  ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED}) $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED} \+ $ROOTFS_SIZE)
    parted -s ${IMAGE} set 1 boot on
    parted ${IMAGE} print

    # Create boot partition image
    BOOT_BLOCKS=$(LC_ALL=C parted -s ${IMAGE} unit b print \
                      | awk '/ 1 / { print substr($4, 1, length($4 -1)) / 1024 }')
    mkfs.vfat -n "${BOOTDD_VOLUME_ID}" -S 512 -C ${WORKDIR}/boot.img $BOOT_BLOCKS
    do_populate_boot

    # Burn Partitions
    dd if=${WORKDIR}/boot.img of=${IMAGE} conv=notrunc seek=1 bs=$(expr ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync
    dd if=${ROOTFS} of=${IMAGE} conv=notrunc seek=1 bs=$(expr ${BOOT_SPACE_ALIGNED} \* 1024 + ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync

    rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
    ln -s ${IMAGE_NAME}.rootfs.img ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
}

