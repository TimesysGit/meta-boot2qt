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
