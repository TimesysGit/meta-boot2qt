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

PACKAGECONFIG_GL = "gles2"
PACKAGECONFIG += " \
    accessibility \
    alsa \
    cups \
    fontconfig \
    glib \
    iconv \
    icu \
    linuxfb \
    sql-sqlite \
    tslib \
    libinput \
    xkbcommon-evdev \
    "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://oe-device-extra.pri \
    file://0001-Add-win32-g-oe-mkspec-that-uses-the-OE_-environment.patch \
    "
do_configure_prepend() {
    install -m 0644 ${WORKDIR}/oe-device-extra.pri ${S}/mkspecs
}

SRCREV = "6c1e352803a6efbd8b14e5296434e22165b65084"

# Temporarily here, until merged upstream
PACKAGECONFIG[kms] = "-kms,-no-kms,drm virtual/egl"
