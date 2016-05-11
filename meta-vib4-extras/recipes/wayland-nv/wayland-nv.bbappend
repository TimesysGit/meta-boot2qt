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
