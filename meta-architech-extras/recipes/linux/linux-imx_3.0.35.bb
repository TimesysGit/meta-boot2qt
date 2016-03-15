# Copyright (C) 2011-2013 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

COMPATIBLE_MACHINE = "(mx6)"

# Revision of 4.1.0 branch
SRCREV = "bdde708ebfde4a8c1d3829578d3f6481a343533a"
LOCALVERSION = "-4.1.0+yocto"

# Patches need for Yocto and not applied by Freescale when doing 4.1.0 branch
SRC_URI += "file://drm-vivante-Add-00-sufix-in-returned-bus-Id.patch \
            file://epdc-Rename-mxcfb_epdc_kernel.h-to-mxc_epdc.h.patch \
            file://0001-perf-tools-Fix-getrusage-related-build-failure-on-gl.patch \
            file://0002-ARM-7668-1-fix-memset-related-crashes-caused-by-rece.patch \
            file://0003-ARM-7670-1-fix-the-memset-fix.patch \
            file://0004-ENGR00271136-Fix-build-break-when-CONFIG_CLK_DEBUG-i.patch \
            file://0005-ENGR00271359-Add-Multi-touch-support.patch \
            file://0006-Add-support-for-DVI-monitors.patch \
            file://0007-ARM-mach-mx6-board-mx6q_sabresd-Register-SDHC3-first.patch"

# kernel image files are not needed in the image
RDEPENDS_kernel-base = ""

do_configure_prepend() {

cat <<EOF >> ${WORKDIR}/defconfig

# FunctionFS for adb
CONFIG_USB_FUNCTIONFS=m

# Enable USB serial support
CONFIG_USB_SERIAL=m
CONFIG_USB_SERIAL_GENERIC=y
CONFIG_USB_SERIAL_FTDI_SIO=m
CONFIG_USB_SERIAL_PL2303=m
CONFIG_USB_ACM=m

# Control group support
CONFIG_CGROUPS=y

# Open by fhandle syscalls
CONFIG_FHANDLE=y
CONFIG_EXPORTFS=y

# Namespaces support
CONFIG_NAMESPACES=y
CONFIG_UTS_NS=y
CONFIG_IPC_NS=y
CONFIG_USER_NS=y
CONFIG_PID_NS=y
CONFIG_NET_NS=y

EOF
}

# bbappend in meta-tibidabo still tries to use PRINC, set to -1 to prevent errors
PRINC = "-1"
