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
## http://qt.digia.com/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

DESCRIPTION = "B2Qt on embedded Linux SDK toolchain"
PR = "r0"
LICENSE = "CLOSED"

TOOLCHAIN_HOST_TASK = "nativesdk-packagegroup-b2qt-embedded-toolchain-host packagegroup-cross-canadian-${MACHINE}"
TOOLCHAIN_TARGET_TASK = "nativesdk-packagegroup-b2qt-embedded-toolchain-target"

require recipes-core/meta/meta-toolchain.bb

toolchain_create_sdk_env_script_append() {
    sed -i -e '/export CC/d' $script
    sed -i -e '/export CXX/d' $script
    sed -i -e '/export CFLAGS/d' $script
    sed -i -e '/export CXXFLAGS/d' $script
    sed -i -e '/export LDFLAGS/d' $script
    sed -i -e '/export CPPFLAGS/d' $script
    sed -i -e '/export CFLAGS/d' $script
    sed -i -e '/export CPP/d' $script
    sed -i -e '/export AS/d' $script
    sed -i -e '/export LD/d' $script
    sed -i -e '/export STRIP/d' $script
    sed -i -e '/export RANLIB/d' $script
    sed -i -e '/export OBJCOPY/d' $script
    sed -i -e '/export OBJDUMP/d' $script
    sed -i -e '/export AR/d' $script
    sed -i -e '/export NM/d' $script
}
