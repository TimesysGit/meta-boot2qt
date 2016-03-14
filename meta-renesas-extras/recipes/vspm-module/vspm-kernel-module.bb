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
"

SRC_URI = "file://vspm-kernel.tar.bz2"
S = "${WORKDIR}/vspm"

inherit renesas-module

MODULE_NAME = "vspm"
MODULE_HEADERS = " \
include/vspm_public.h \
include/vsp_drv.h \
include/tddmac_drv.h \
include/vspm_if.h \
"

VSPM_CFG_r8a7790 = "H2CONFIG"
VSPM_CFG_r8a7791 = "M2CONFIG"
VSPM_CFG_r8a7793 = "M2CONFIG"
VSPM_CFG_r8a7794 = "E2CONFIG"

do_compile_prepend() {
    export VSPM_CONFIG=${VSPM_CFG}
}

do_install_append() {
    # Copy for vspm-user-module
    install -t ${STAGING_INCDIR} ${S}/include/vspm_if.h
}

FILES_${PN}-dev += "/usr/include/vspm_if.h"
