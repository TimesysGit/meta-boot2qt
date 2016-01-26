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

DESCRIPTION = "B2Qt embedded Qt5 SDK toolchain"

LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://${QT_LICENCE};md5=7bc9c54e450006250a60e96604c186c9"

inherit populate_b2qt_qt5_sdk

TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-b2qt-embedded-qt5-toolchain-host"
TOOLCHAIN_TARGET_TASK += "packagegroup-b2qt-embedded-qt5-toolchain-target \
                          packagegroup-b2qt-automotive-qt5-toolchain-target"
