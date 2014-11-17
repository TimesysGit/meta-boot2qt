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

DESCRIPTION = "QtGlesStream dummy client provides headers and a dummy library for EGL/GLES"
SECTION = "devel"
LICENSE = "CLOSED"

SRCREV = "72b9fdd9373a383c8b94afdbeb8cfbbfcde95e6e"
PV = "5.4.0+git${SRCREV}"

PROVIDES = "virtual/libgles2 virtual/libgles3 virtual/egl"

SRC_URI = "git://qt-gerrit.it.local/QtRD-15810/qtglesstream.git;protocol=ssh;branch=dev"

S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"

do_compile() {
	${CC} -DQGS_BUILD_CLIENT_DLL -fPIC -shared -Iheaders -o libQtGlesStreamClient.so src/client-dummy/*.cpp
}

do_install() {
	install -m 0755 -d ${D}${includedir}/EGL
	install -m 0755 ${WORKDIR}/git/headers/EGL/* ${D}${includedir}/EGL

	install -m 0755 -d ${D}${includedir}/GLES2
	install -m 0755 ${WORKDIR}/git/headers/GLES2/* ${D}${includedir}/GLES2

	install -m 0755 -d ${D}${includedir}/GLES3
	install -m 0755 ${WORKDIR}/git/headers/GLES3/* ${D}${includedir}/GLES3

	install -m 0755 -d ${D}${includedir}/KHR
	install -m 0755 ${WORKDIR}/git/headers/KHR/* ${D}${includedir}/KHR

	install -m 0755 -d ${D}${libdir}
	install -m 0755 ${WORKDIR}/git/libQtGlesStreamClient.so ${D}${libdir}
}
