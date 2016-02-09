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

DESCRIPTION = "Packagegroup for B2Qt embedded Linux image"
LICENSE = "CLOSED"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
        kernel-modules \
        adbd \
        psplash \
        openssh-sftp-server \
        openssl \
        openssl-misc \
        libpng \
        tiff \
        libxslt \
        icu \
        freetype \
        fontconfig \
        liberation-fonts \
        tslib \
        tslib-calibrate \
        alsa-utils-amixer \
        hunspell \
        ca-certificates \
        linux-firmware \
        ttf-devanagari \
        ttf-opensans \
        ttf-dejavu-common \
        ttf-dejavu-sans \
        dbus-session-init \
        otf-noto \
        libmysqlclient \
        libpq \
        tzdata \
        tzdata-americas \
        tzdata-asia \
        tzdata-europe \
        atk \
        libevent \
        ostree \
        dracut \
        connman \
        ${@base_contains("DISTRO_FEATURES", "wayland", "wayland weston weston-examples", "", d)} \
        ${MACHINE_EXTRA_INSTALL} \
        "
