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

IMAGE_ROOTFS_EXTRA_SPACE = "100000"
SDCARD_ROOTFS = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"
SDCARD_GENERATION_COMMAND_ti33x = "generate_imx_sdcard"

IMAGE_CMD_sdcard_append() {
    parted -s ${SDCARD} set 1 boot on

    rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
    ln -s ${IMAGE_NAME}.rootfs.sdcard ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
}

IMAGE_CMD_rpi-sdimg_append() {
    rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
    ln -s ${IMAGE_NAME}.rootfs.rpi-sdimg ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
}

build_hddimg_append() {
    rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
    ln -s ${IMAGE_NAME}.hddimg ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.img
}
