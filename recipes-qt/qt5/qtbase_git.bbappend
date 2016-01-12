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
    xkbcommon-evdev \
    "

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://oe-device-extra.pri \
    "
do_configure_prepend() {
    install -m 0644 ${WORKDIR}/oe-device-extra.pri ${S}/mkspecs
}

SRCREV = "3880f41e683f02b905c8cbc3c578c3f3a0a1eb2e"

# Temporarily here, until merged upstream
PACKAGECONFIG[openssl] = "-openssl,-no-openssl,openssl,libssl"

do_install_append() {
    # Temporarily here, until merged upstream
    sed -i -e 's|${STAGING_DIR_NATIVE}${prefix_native}|$$[QT_HOST_PREFIX]|g' \
        -e 's|${STAGING_DIR_HOST}|$$[QT_SYSROOT]|g' \
        ${D}/${OE_QMAKE_PATH_QT_ARCHDATA}/mkspecs/*.pri
}
