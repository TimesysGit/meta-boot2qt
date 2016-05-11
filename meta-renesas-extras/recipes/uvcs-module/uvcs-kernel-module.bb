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
file://include/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
file://include/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
"

SRC_URI = "file://uvcs-kernel.tar.bz2"
S = "${WORKDIR}/uvcs"

inherit renesas-module

export UVCS_DRV_SRC_DIR = "${S}/source/uvcs_lkm"
export UVCS_CMN_SRC_DIR = "${S}/source/uvcs_cmn"
export UVCS_CMN_INC_DIR = "${S}/include"
export DRV_CORE_SRC_DIR = "${S}/source/driver_core"

MODULE_NAME = "uvcs_cmn"
MODULE_HEADERS = "include/uvcs_cmn.h include/uvcs_types.h"
MODULE_SOURCE_DIR = "${S}/source/makefile/linaro_4_7_3/"
