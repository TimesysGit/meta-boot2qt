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

DESCRIPTION = "OpenGL dummy library provides headers and a dummy library for EGL/GLES"
SECTION = "devel"
LICENSE = "CLOSED"

PV = "1.0.0"

require opengldummy.inc

do_compile() {
	${CC} -DQGS_BUILD_CLIENT_DLL -fPIC -shared -I${WORKDIR}/headers -o libEGL.so ${WORKDIR}/egl.cpp
	${CC} -DQGS_BUILD_CLIENT_DLL -fPIC -shared -I${WORKDIR}/headers -o libGLESv2.so ${WORKDIR}/gles2.cpp
}

do_install_append() {
	install -m 0755 -d ${D}${libdir}
	install -m 0755 ${S}/libEGL.so ${D}${libdir}
	install -m 0755 ${S}/libGLESv2.so ${D}${libdir}
}
