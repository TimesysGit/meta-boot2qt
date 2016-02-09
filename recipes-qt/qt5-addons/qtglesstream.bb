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

DESCRIPTION = "QtGlesStream"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://qtglesstream.pro;md5=e95d9351d26ed899188e02d44133cae0"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-qtglesstream;branch=${BRANCH};protocol=ssh \
    "

PV = "1.0.0"
SRCREV = "c11bf065f7630b7800dda157e4bc1aeba7a533d2"
BRANCH = "dev"

S = "${WORKDIR}/git"

DEPENDS = "qtbase"
RREPLACES_${PN} = "qtglesstream-dummy-client"
RREPLACES_${PN}-dev = "qtglesstream-dummy-client-dev"

do_install_append() {
    install -m 0755 -d ${D}${includedir}/EGL
    install -m 0755 ${S}/headers/EGL/* ${D}${includedir}/EGL

    install -m 0755 -d ${D}${includedir}/GLES2
    install -m 0755 ${S}/headers/GLES2/* ${D}${includedir}/GLES2

    install -m 0755 -d ${D}${includedir}/GLES3
    install -m 0755 ${S}/headers/GLES3/* ${D}${includedir}/GLES3

    install -m 0755 -d ${D}${includedir}/KHR
    install -m 0755 ${S}/headers/KHR/* ${D}${includedir}/KHR
}

# no not overwrite files from qtglesstream-dummy-client
do_populate_sysroot[noexec] = "1"
