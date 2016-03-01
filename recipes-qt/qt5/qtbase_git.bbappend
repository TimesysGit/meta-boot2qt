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
    "
do_configure_prepend() {
    install -m 0644 ${WORKDIR}/oe-device-extra.pri ${S}/mkspecs
}

SRCREV = "38944d662eda76ecc57cb1fd61da42775fa52f6f"

# Temporarily here, until merged upstream
PACKAGECONFIG[kms] = "-kms,-no-kms,drm virtual/egl"
PACKAGECONFIG[xkbcommon-evdev] = "-xkbcommon-evdev,-no-xkbcommon-evdev,libxkbcommon,xkeyboard-config"
