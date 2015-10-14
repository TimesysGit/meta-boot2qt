#############################################################################
##
## Copyright (C) 2014 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

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
    "

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://oe-device-extra.pri \
    file://0001-qdoc-workaround-for-gcc-s-ICE.patch \
    "

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/oe-device-extra.pri ${S}/mkspecs
    sed -i 's!load(qt_config)!!' ${S}/mkspecs/linux-oe-g++/qmake.conf
    cat >> ${S}/mkspecs/linux-oe-g++/qmake.conf <<EOF
QMAKE_PLATFORM         += boot2qt
QT_QPA_DEFAULT_PLATFORM = eglfs

exists(../oe-device-extra.pri):include(../oe-device-extra.pri)

load(qt_config)
EOF
}
