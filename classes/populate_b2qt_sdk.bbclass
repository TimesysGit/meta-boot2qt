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

