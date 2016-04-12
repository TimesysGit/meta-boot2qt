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

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://0001-ARM-8158-1-LLVMLinux-use-static-inline-in-ARM-ftrace.patch \
    file://0001-ARM-LLVMLinux-Change-extern-inline-to-static-inline-.patch \
    "

do_configure_prepend() {
    sed -e '/CONFIG_USB_FUNCTIONFS_ETH=/d' \
        -e '/CONFIG_USB_FUNCTIONFS_RNDIS=/d' \
        -i ${WORKDIR}/defconfig

    echo "CONFIG_NAMESPACES=y"              >> ${WORKDIR}/defconfig
    echo "CONFIG_FHANDLE=y"                 >> ${WORKDIR}/defconfig
    echo "CONFIG_CGROUPS=y"                 >> ${WORKDIR}/defconfig
}
