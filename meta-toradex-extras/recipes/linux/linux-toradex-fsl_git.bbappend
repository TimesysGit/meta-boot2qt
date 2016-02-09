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

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "\
    file://ARM-perf-add-support-for-perf-registers-API.diff \
    file://ARM-perf-wire-up-perf_regs-and-unwind-support-for-AR.patch \
    "

# kernel image files are not needed in the image
RDEPENDS_kernel-base = ""

config_script () {
    # FunctionFS for adb
    echo "CONFIG_USB_FUNCTIONFS=m"  >> ${S}/.config
    echo "CONFIG_USB_ACM=m"         >> ${S}/.config
}

B = "${S}"
