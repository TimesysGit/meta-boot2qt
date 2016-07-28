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

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://grub.cfg"

do_install[depends] += " \
    virtual/kernel:do_deploy \
    ${INITRAMFS_IMAGE}:do_rootfs \
    ${@bb.utils.contains('MACHINE_FEATURES', 'intel-ucode', 'intel-microcode:do_deploy', '', d)} \
"

do_deploy_prepend() {

cat > ${WORKDIR}/cfg <<EOF
search.file /boot/grub2/grub.cfg root
set prefix=/boot/grub2
EOF
}

do_install_append() {

    install -d ${D}/boot/grub2/
    install -m 644 ${WORKDIR}/grub.cfg ${D}/boot/grub2/

    # https://www.kernel.org/doc/Documentation/x86/early-microcode.txt
    microcode="${@bb.utils.contains('MACHINE_FEATURES', 'intel-ucode', '${DEPLOY_DIR_IMAGE}/microcode.cpio ', '', d)}"
    cat ${microcode} ${DEPLOY_DIR_IMAGE}/${INITRAMFS_IMAGE}-${MACHINE}.cpio.gz > ${D}/boot/initramfs
    chmod 0644 ${D}/boot/initramfs
}

PACKAGES += "${PN}-config"
FILES_${PN}-config = "/boot/grub2/ /boot/initramfs"
