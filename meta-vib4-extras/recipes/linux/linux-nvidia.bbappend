
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

do_kernel_defconfig_prepend () {
}

do_compile_prepend () {
    # cross_compile_exports
    export ARCH=${KERNEL_ARCH}
    export CROSS_COMPILE=${CROSS_COMPILE}

    echo "CONFIG_USB_FUNCTIONFS=m"  >> ${B}/.config
    echo "CONFIG_USB_ACM=m"         >> ${B}/.config

    make olddefconfig
}

do_install () {
    kernel_do_install

    s=$(readlink -m "${S}")
    kernsrc="${STAGING_KERNEL_DIR}"

    if [ "${s}" != "${kernsrc}" ]; then
        mkdir -p "${kernsrc}"
        rm -rf "${kernsrc}"
        mv "${S}" "${STAGING_KERNEL_DIR}"
        ln -sf "${kernsrc}" "${s}"
    fi
}

do_deploy() {
    kernel_do_deploy
}

do_compile () {
    kernel_do_compile
}
