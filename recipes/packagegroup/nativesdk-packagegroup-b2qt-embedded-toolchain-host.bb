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

DESCRIPTION = "Host packages for B2Qt on embedded Linux SDK"
PR = "r0"
LICENSE = "CLOSED"

inherit nativesdk packagegroup

RDEPENDS_${PN} = "\
    nativesdk-python-modules \
    nativesdk-python-misc \
    nativesdk-gperf \
    nativesdk-ostree \
    ${@base_contains("DISTRO_FEATURES", "wayland", "nativesdk-wayland", "", d)} \
    ${MACHINE_EXTRA_INSTALL_SDK_HOST} \
    "
