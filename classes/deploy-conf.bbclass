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
