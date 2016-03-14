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

LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = " \
file://GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
file://MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
"

SRC_URI = " \
    git://github.com/renesas-devel/vsp2driver.git;protocol=git;branch=RCAR-GEN2/1.0.0 \
    file://vsp2drv-init \
"
SRCREV = "8cc362a6c961661e4655904f8d7731e501529d6c"
S = "${WORKDIR}/git"

DEPENDS = "vspm-kernel-module"
do_configure[depends] += "vspm-kernel-module:do_shared_workdir"

MODULE_NAME = "vsp2"
INITSCRIPT_NAME = "vsp2drv"
INITSCRIPT_PARAMS = "start 8 5 2 . stop 61 0 1 6 ."

inherit renesas-module update-rc.d

do_compile_prepend() {
    export VSP2_VSPMDIR=${STAGING_KERNEL_BUILDDIR}/include
    export VSP2_VSPMSYMVERS=vspm.symvers
}

do_install_append() {
    install -D -m 0755 ${WORKDIR}/vsp2drv-init ${D}/${sysconfdir}/init.d/vsp2drv
}

FILES_${PN} += "/etc/init.d/vsp2drv"
