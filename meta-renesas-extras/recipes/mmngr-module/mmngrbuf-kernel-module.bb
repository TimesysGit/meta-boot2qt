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
SRC_URI = "file://mmngrbuf.tar.bz2"
LIC_FILES_CHKSUM = "file://drv/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://drv/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
    file://include/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://include/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 "

inherit renesas-module

S = "${WORKDIR}/mmngrbuf"

MODULE_NAME = "mmngrbuf"
