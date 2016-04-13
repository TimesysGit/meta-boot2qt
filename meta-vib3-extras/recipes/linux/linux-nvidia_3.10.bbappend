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

FILESEXTRAPATHS_prepend := "__default:${THISDIR}/${PN}:"

DEPENDS_remove = "external-tegra-toolchain"
do_kernel_defconfig[depends] = "kern-tools-native:do_populate_sysroot"

SRC_URI += "\
    file://0001-ARM-8158-1-LLVMLinux-use-static-inline-in-ARM-ftrace.patch \
    file://0001-Change-extern-inline-to-static-inline.patch \
    file://Fix_compile_error_in_tegra_drivers.patch \
    file://Fix_compiler_error_in_tegra12_lock.patch \
    "

do_compile_prepend () {
    # Cross compiling exports
    export ARCH=${TARGET_ARCH}
    export CROSS_COMPILE=${CROSS_COMPILE}

    echo "CONFIG_FHANDLE=y" >> ${B}/.config
    make olddefconfig
}

do_install_append() {
    s=$(readlink -m "${S}")
    kernsrc="${STAGING_KERNEL_DIR}"

    if [ "${s}" != "${kernsrc}" ]; then
        mkdir -p "${kernsrc}"
        rm -rf "${kernsrc}"
        mv "${S}" "${STAGING_KERNEL_DIR}"
        ln -sf "${kernsrc}" "${s}"
    fi
}

python do_patch () {
    bb.build.exec_func('patch_do_patch', d)
}
