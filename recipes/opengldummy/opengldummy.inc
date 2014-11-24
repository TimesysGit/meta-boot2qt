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

PROVIDES = "virtual/libgles2 virtual/libgles3 virtual/egl"

SRC_URI = "file://headers \
           file://egl.cpp \
           file://gles2.cpp \
          "

FILES_${PN} = "${libdir}"
FILES_${PN}-dev = "${includedir}/"

do_install() {
	install -m 0755 -d ${D}${includedir}/EGL
	install -m 0755 ${WORKDIR}/headers/EGL/* ${D}${includedir}/EGL

	install -m 0755 -d ${D}${includedir}/GLES2
	install -m 0755 ${WORKDIR}/headers/GLES2/* ${D}${includedir}/GLES2

	install -m 0755 -d ${D}${includedir}/GLES3
	install -m 0755 ${WORKDIR}/headers/GLES3/* ${D}${includedir}/GLES3

	install -m 0755 -d ${D}${includedir}/KHR
	install -m 0755 ${WORKDIR}/headers/KHR/* ${D}${includedir}/KHR
}
