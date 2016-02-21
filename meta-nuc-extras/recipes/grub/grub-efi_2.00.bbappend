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

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://grub.cfg"

do_deploy_prepend() {

cat > ${WORKDIR}/cfg <<EOF
search.file /boot/grub2/grub.cfg root
set prefix=/boot/grub2
EOF
}

do_install_append() {

    install -d ${D}/boot/grub2/
    install -m 644 ${WORKDIR}/grub.cfg ${D}/boot/grub2/
}

PACKAGES += "${PN}-config"
FILES_${PN}-config = "/boot/grub2/"
