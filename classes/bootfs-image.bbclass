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

		install -m 0755 ${DEPLOY_DIR_IMAGE}/$src ${S}/bootfs/$dst
	done

	cd ${S}/bootfs
	rm -f ${DEPLOY_DIR_IMAGE}/${BOOTFS_NAME}.tar.gz ${DEPLOY_DIR_IMAGE}/${BOOTFS_LINK_NAME}.tar.gz

	tar czvf ${DEPLOY_DIR_IMAGE}/${BOOTFS_NAME}.tar.gz .
	ln -s ${BOOTFS_NAME}.tar.gz ${DEPLOY_DIR_IMAGE}/${BOOTFS_LINK_NAME}.tar.gz
}

addtask bootfs before do_rootfs

do_bootfs[depends] += "${BOOTFS_DEPENDS}"
