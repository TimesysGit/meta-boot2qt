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

SRC_URI += " \
    file://wayland-client.pc \
    file://wayland-cursor.pc \
    file://wayland-egl.pc \
    file://wayland-server.pc \
    file://${PLATFORM_TOPDIR}/include/wayland-egl-core.h \
    "

FILES_${PN} += "${libdir}/pkgconfig"

WAYLAND_PACKAGES += "wayland-dev"

do_install_append() {
    install -d ${D}${libdir}/pkgconfig
    install -m 0776 ${WORKDIR}/*.pc ${D}${libdir}/pkgconfig
    install -d ${D}${includedir}
    install -m 0775 ${PLATFORM_TOPDIR}/include/wayland-egl-core.h ${D}${includedir}
}
