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

DESCRIPTION = "B2Qt on embedded Linux SDK toolchain"
PR = "r0"
LICENSE = "CLOSED"

inherit populate_sdk

TOOLCHAIN_HOST_TASK = "nativesdk-packagegroup-b2qt-embedded-toolchain-host packagegroup-cross-canadian-${MACHINE}"
TOOLCHAIN_TARGET_TASK += "packagegroup-b2qt-embedded-toolchain-target"


