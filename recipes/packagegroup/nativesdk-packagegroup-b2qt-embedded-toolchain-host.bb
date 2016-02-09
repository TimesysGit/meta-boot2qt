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

DESCRIPTION = "Host packages for B2Qt on embedded Linux SDK"
PR = "r0"
LICENSE = "CLOSED"

inherit nativesdk packagegroup

python __anonymous() {
    overrides = d.getVar("OVERRIDES", True).split(":")
    if "mingw32" not in overrides:
        d.appendVar("OVERRIDES", ":linux")
}

RDEPENDS_${PN} = "\
    nativesdk-gperf \
    ${MACHINE_EXTRA_INSTALL_SDK_HOST} \
    "

RDEPENDS_${PN}_append_linux = "\
    nativesdk-python-modules \
    nativesdk-python-misc \
    nativesdk-perl-modules \
    ${@base_contains("DISTRO_FEATURES", "wayland", "nativesdk-wayland", "", d)} \
    "

RDEPENDS_${PN}_append_mingw32 = "\
    nativesdk-make \
    nativesdk-libgcc \
    nativesdk-libstdc++ \
    "
