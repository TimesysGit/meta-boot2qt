############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

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
