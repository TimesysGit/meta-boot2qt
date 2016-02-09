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

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_class-nativesdk = " \
    file://disable-macro-checks-not-used-for-scanner.patch \
    file://0001-Use-native-wayland-scanner-when-building-nativesdk-w.patch \
    "

EXTRA_OECONF_class-nativesdk = "--disable-documentation --enable-scanner"
DEPENDS_class-nativesdk = "libffi-nativesdk wayland-native"

BBCLASSEXTEND = "native nativesdk"
