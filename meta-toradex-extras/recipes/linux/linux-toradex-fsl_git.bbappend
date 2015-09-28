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
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

FILESEXTRAPATHS_prepend := "${THISDIR}/../../../recipes/linux/linux:"
SRC_URI += "\
    file://ARM-perf-add-support-for-perf-registers-API.diff \
    file://ARM-perf-wire-up-perf_regs-and-unwind-support-for-AR.patch \
    "

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += " \
        file://0001-Colibri-iMX6-set-1280x720-16-for-HDMI-by-default.patch \
        "

# kernel image files are not needed in the image
RDEPENDS_kernel-base = ""

config_script () {
    # FunctionFS for adb
    echo "CONFIG_USB_FUNCTIONFS=m"  >> ${S}/.config
    echo "CONFIG_USB_ACM=m"         >> ${S}/.config
}
