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

BBMASK ?= " "
BBMASK .= "|meta-toradex/recipes-mozilla|meta-toradex/recipes-browser|meta-toradex/recipes-lxde|meta-toradex/recipes-connectivity|meta-toradex/recipes-gnome|meta-toradex/recipes/trdx-config|meta-toradex/recipes-multimedia/webm|meta-toradex/recipes-qt|meta-toradex/recipes-core/psplash|meta-toradex/recipes-support/florence|meta-toradex/recipes-core/systemd|meta-toradex/recipes-efl|meta-toradex/recipes-core/dropbear|meta-toradex/recipes-support/icu|meta-toradex/recipes-support/i2c-tools|meta-toradex/recipes-benchmark|meta-toradex/recipes-core/udev|meta-toradex/recipes-support/gnutls|meta-toradex/recipes-graphics/gpu-viv-bin-mx6q|meta-toradex/recipes-multimedia/gstreamer|meta-toradex/recipes-fsl/packagegroups|recipes-core/glibc/glibc_linaro-2.20.bbappend"

PREFERRED_PROVIDER_u-boot = "u-boot-toradex"

MACHINEDIR = "${@d.getVar('MACHINE', True).replace('-','_')}"
BOOT_SCRIPTS += " \
    fwd_blk.img:flash_blk.img \
    fwd_eth.img:flash_eth.img \
    fwd_mmc.img:flash_mmc.img \
    ${MACHINE}:${MACHINEDIR} \
    u-boot-${MACHINE}.imx:${MACHINEDIR}/u-boot.imx \
    "
