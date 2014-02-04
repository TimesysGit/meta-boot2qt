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

DESCRIPTION = "Kernel drivers for the VirtualBox guest additions"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/VirtualBox-${PV}/COPYING;md5=e197d5641bb35b29d46ca8c4bf7f2660"

inherit module

MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

SRC_URI = "http://download.virtualbox.org/virtualbox/${PV}/VirtualBox-${PV}.tar.bz2"

SRC_URI[md5sum] = "be834de415adaf2f696f7a499f88b4e6"
SRC_URI[sha256sum] = "f8f6dc19612f3c84a5c857b8e5c452b8db2cf3c8c52a678b6a00e5dd5831130d"

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
	install -m 0644 *.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/vbox
}

PKG_${PN} = "kernel-module-vbox"

module_autoload_vboxsf = "vboxsf"
module_autoload_vboxvideo = "vboxvideo"
module_autoload_vboxguest = "vboxguest"
