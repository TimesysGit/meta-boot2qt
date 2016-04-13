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

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += " file://egl.pc"
FILES_${PN} += "egl.pc"

GRAPHICS_PACKAGES = " \
    virtual/libgles2 \
    virtual/libegl \
    virtual/egl \
    virtual/libgl \
    virtual/libgles1 \
    virtual/mesa \
    libgbm \
    libgbm-dev \
    "

do_install_append_tegra-t18x() {
    install -d ${D}/usr/lib/pkgconfig
    install -m 0775 ${WORKDIR}/egl.pc ${D}/${libdir}/pkgconfig
}
