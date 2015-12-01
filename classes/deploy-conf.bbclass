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
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

inherit image_types

DEPLOY_CONF_NAME ?= "${MACHINE}"
DEPLOY_CONF_TYPE ?= "Boot2Qt"

IMAGE_CMD_conf() {
    cat > ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.conf <<EOF
[${DEPLOY_CONF_TYPE} | ${DEPLOY_CONF_NAME}]
platform=${MACHINE}
os=linux
board=
imagefile=${IMAGE_LINK_NAME}.img
asroot=true
EOF
}
