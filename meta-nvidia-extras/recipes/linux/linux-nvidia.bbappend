do_kernel_defconfig_prepend_tegra-t18x () {
}

do_install_append_tegra-t18x () {
    s=$(readlink -m "${S}")
    kernsrc="${STAGING_KERNEL_DIR}"

    if [ "${s}" != "${kernsrc}" ]; then
        mkdir -p "${kernsrc}"
        rm -rf "${kernsrc}"
        mv "${S}" "${STAGING_KERNEL_DIR}"
        ln -sf "${kernsrc}" "${s}"
    fi
}

do_compile_prepend_tegra-t18x () {
    if [ -z "${TOOLCHAIN_PATH}" ] ; then
        echo "TOOLCHAIN_PATH must be set"
        exit -1
    fi

    export PATH="${TOOLCHAIN_PATH}/usr/bin/aarch64-gnu-linux:${PATH}"

    echo "CONFIG_USB_FUNCTIONFS=m"  >> ${B}/.config
    echo "CONFIG_USB_ACM=m"         >> ${B}/.config

    make olddefconfig
}
