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

DESCRIPTION = "B2Qt on embedded Linux SDK toolchain"
PR = "r0"
LICENSE = "CLOSED"

inherit populate_b2qt_sdk

TOOLCHAIN_HOST_TASK = "nativesdk-packagegroup-b2qt-embedded-toolchain-host packagegroup-cross-canadian-${MACHINE}"
TOOLCHAIN_TARGET_TASK += "packagegroup-b2qt-embedded-toolchain-target"

