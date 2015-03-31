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
    "

do_configure_prepend() {
	sed -i 's!load(qt_config)!!' ${S}/mkspecs/linux-oe-g++/qmake.conf
	cat >> ${S}/mkspecs/linux-oe-g++/qmake.conf <<EOF
QMAKE_PLATFORM         += boot2qt
QT_QPA_DEFAULT_PLATFORM = eglfs
load(qt_config)
EOF
}

do_configure_prepend_emulator() {
	sed -i 's!load(qt_config)!!' ${S}/mkspecs/linux-oe-g++/qmake.conf
	cat >> ${S}/mkspecs/linux-oe-g++/qmake.conf <<EOF
QMAKE_LIBS_EGL         = -lQtGlesStreamClient
QMAKE_LIBS_OPENGL_ES2  = -lQtGlesStreamClient

load(qt_config)
EOF
}
