#############################################################################
##
## Copyright (C) 2014 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://qt.digia.com/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

inherit image_types_fsl

IMAGE_ROOTFS_EXTRA_SPACE = "300000"
SDCARD_ROOTFS = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"

IMAGE_CMD_sdcard_append () {
    parted -s ${SDCARD} set 1 boot on
}
