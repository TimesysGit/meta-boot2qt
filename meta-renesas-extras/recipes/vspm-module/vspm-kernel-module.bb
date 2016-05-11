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
