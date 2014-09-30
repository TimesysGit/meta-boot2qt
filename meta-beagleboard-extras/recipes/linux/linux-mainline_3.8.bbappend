FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "\
    file://0001-AM335x-Adding-SGX-DT-node.patch \
    file://0002-AM33XX-Invoke-hwmod-deassert-for-SGX-graphics-device.patch \
    file://0003-video-da8xx-fb-Add-API-to-register-wait-for-vsync-ca.patch \
    "

INSANE_SKIP_${PN} = "installed-vs-shipped"
KERNEL_IMAGETYPE = "zImage"
