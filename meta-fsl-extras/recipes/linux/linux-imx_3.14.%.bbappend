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

# kernel image files are not needed in the image
RDEPENDS_kernel-base = ""

do_configure_prepend() {
    # FunctionFS for adb
    echo "CONFIG_USB_FUNCTIONFS=m"  >> ${WORKDIR}/defconfig

    # Enable USB serial support
    echo "CONFIG_USB_SERIAL=m"              >> ${WORKDIR}/defconfig
    echo "CONFIG_USB_SERIAL_GENERIC=y"      >> ${WORKDIR}/defconfig
    echo "CONFIG_USB_SERIAL_FTDI_SIO=m"     >> ${WORKDIR}/defconfig
    echo "CONFIG_USB_SERIAL_PL2303=m"       >> ${WORKDIR}/defconfig
    echo "CONFIG_USB_ACM=m"                 >> ${WORKDIR}/defconfig

    echo "CONFIG_NAMESPACES=y"              >> ${WORKDIR}/defconfig
    echo "CONFIG_FHANDLE=y"                 >> ${WORKDIR}/defconfig
}
