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

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_class-nativesdk = " file://just-scanner.patch \
    file://disable-macro-checks-not-used-for-scanner.patch \
    file://0001-Use-native-wayland-scanner-when-building-nativesdk-w.patch \
    "

EXTRA_OECONF_class-nativesdk = "--disable-documentation --enable-scanner"
DEPENDS_class-nativesdk = "libffi-nativesdk wayland-native"

BBCLASSEXTEND = "native nativesdk"
