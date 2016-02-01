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

inherit populate_sdk

POPULATE_SDK_POST_HOST_COMMAND_append_sdkmingw32 = " replace_host_symlink;"

replace_host_symlink() {
        for SOURCE in `find ${SDK_OUTPUT}/${SDKPATHNATIVE} -type l`
        do
                TARGET=`readlink -f "${SOURCE}"`
                if [ -e ${TARGET} ]; then
                        rm "${SOURCE}"
                        cp -f "${TARGET}" "${SOURCE}"
                fi
        done
}

fakeroot tar_sdk_sdkmingw32() {
        # Package it up
        mkdir -p ${SDK_DEPLOY}
        cd ${SDK_OUTPUT}/${SDKPATH}
        7z a ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}.7z sysroots
}

