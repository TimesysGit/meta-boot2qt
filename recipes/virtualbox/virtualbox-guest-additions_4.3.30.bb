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

DESCRIPTION = "Kernel drivers for the VirtualBox guest additions"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/VirtualBox-${PV}/COPYING;md5=e197d5641bb35b29d46ca8c4bf7f2660"

inherit module

MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

SRC_URI = "http://download.virtualbox.org/virtualbox/${PV}/VirtualBox-${PV}.tar.bz2"

SRC_URI[md5sum] = "cc053340f88922a11ad9d4fab56557bd"
SRC_URI[sha256sum] = "ea9569ec16cd6202ee61bcadb2506d31ac12fd343adb91565773a05eaaea9a36"

S = "${WORKDIR}/vbox"

export KERN_DIR="${STAGING_KERNEL_DIR}"
export KBUILD_VERBOSE="1"
export BUILD_TARGET_ARCH="${ARCH}"

do_compile_prepend() {
    ${WORKDIR}/VirtualBox-${PV}/src/VBox/Additions/linux/export_modules ${WORKDIR}/vbox.tar.gz
    tar xf ${WORKDIR}/vbox.tar.gz -C ${WORKDIR}/vbox
}

do_install() {
    install -m 0755 -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/vbox
    install -m 0644 vboxsf.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/vbox
    install -m 0644 vboxguest.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/vbox
    install -m 0644 vboxvideo.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/vbox
}

PKG_${PN} = "kernel-module-vbox"
