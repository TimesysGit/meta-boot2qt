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

BOOTFS_NAME = "${IMAGE_BASENAME}-boot-${MACHINE}-${DATETIME}"
BOOTFS_LINK_NAME = "${IMAGE_BASENAME}-boot-${MACHINE}"

BOOTFS_DEPENDS ?= ""

fakeroot do_bootfs () {
    if [ -z "${BOOTFS_CONTENT}" ]; then
        exit 0
    fi

    mkdir -p ${S}/bootfs

    for item in ${BOOTFS_CONTENT}; do
        src=`echo $item | awk -F':' '{ print $1 }'`
        dst=`echo $item | awk -F':' '{ print $2 }'`

        install -D -m 0755 ${DEPLOY_DIR_IMAGE}/$src ${S}/bootfs/$dst
    done

    cd ${S}/bootfs
    rm -f ${DEPLOY_DIR_IMAGE}/${BOOTFS_NAME}.tar.gz ${DEPLOY_DIR_IMAGE}/${BOOTFS_LINK_NAME}.tar.gz

    mkdir -p ${DEPLOY_DIR_IMAGE}
    tar czvf ${DEPLOY_DIR_IMAGE}/${BOOTFS_NAME}.tar.gz .
    ln -s ${BOOTFS_NAME}.tar.gz ${DEPLOY_DIR_IMAGE}/${BOOTFS_LINK_NAME}.tar.gz
}

addtask bootfs before do_rootfs

do_bootfs[depends] += "${BOOTFS_DEPENDS}"
