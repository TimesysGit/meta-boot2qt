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
## http://qt.digia.com/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

DESCRIPTION = "B2Qt on embedded Linux SDK image"
LICENSE = "CLOSED"
PR = "r0"

IMAGE_FEATURES += "\
        package-management \
        ssh-server-dropbear \
        tools-debug \
        debug-tweaks \
        hwcodecs \
        "

inherit core-image

EXTRA_IMAGEDEPENDS_mx6 += "u-boot-script-boundary"

MACHINE_EXTRA_INSTALL ?= ""

GSTREAMER_EXTRA_INSTALL = "\
        gst-meta-video \
        gst-meta-audio \
        gst-plugins-good \
        gst-plugins-base-app \
        gst-plugins-good-videofilter \
        gst-plugins-good-id3demux \
        gst-plugins-good-auparse \
        gst-plugins-good-isomp4 \
        gst-plugins-ugly-rmdemux \
        gst-plugins-ugly-asf \
        gst-plugins-ugly-a52dec \
        gst-ffmpeg \
        "

TOOLS_EXTRA_INSTALL = "\
        adbd \
        ldd \
        binutils \
        binutils-symlinks \
        "

IMAGE_INSTALL += "\
        kernel-modules \
        psplash \
        openssh-sftp-server \
        openssl \
        libpng \
        jpeg \
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
        ${GSTREAMER_EXTRA_INSTALL} \
        ${TOOLS_EXTRA_INSTALL} \
        ${MACHINE_EXTRA_INSTALL} \
        "
