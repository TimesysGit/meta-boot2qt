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
LIC_FILES_CHKSUM = "\
file://drv/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
file://drv/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
file://include/GPL-COPYING;md5=ffa10f40b98be2c2bc9608f56827ed23 \
file://include/MIT-COPYING;md5=5526ef6e21dc96a1dd89fac4bde9f995 \
"

DEPENDS = "mmngr-kernel-module"
SRC_URI = "file://fdpm-kernel.tar.bz2"
S = "${WORKDIR}/fdpm"

do_configure[depends] += "mmngr-kernel-module:do_shared_workdir"

inherit renesas-module

FDPM_CFG_r8a7790 = "H2CONFIG"
FDPM_CFG_r8a7791 = "M2CONFIG"
FDPM_CFG_r8a7793 = "M2CONFIG"
FDPM_CFG_r8a7794 = "E2CONFIG"

MODULE_NAME = "fdpm"
MODULE_HEADERS = "include/fdpm_drv.h include/fdpm_public.h include/fdpm_api.h"

do_compile_prepend() {
    export FDPM_CONFIG=${FDPM_CFG}
    export FDPM_MMNGRDIR=${STAGING_KERNEL_BUILDDIR}/include
    export FDPM_MMNGRSYMVERS=mmngr.symvers
}
