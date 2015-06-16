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

DESCRIPTION = "QtGlesStream"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://qtglesstream.pro;md5=e95d9351d26ed899188e02d44133cae0"

inherit qt5-module

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/qtglesstream.git;branch=${BRANCH};protocol=ssh \
    "

PV = "1.0.0"
SRCREV = "137d476b0e39eaaa6f35296b6bd962175e6ea5d6"
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
