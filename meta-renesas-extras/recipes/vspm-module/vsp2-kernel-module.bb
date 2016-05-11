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
