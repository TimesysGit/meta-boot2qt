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

DESCRIPTION = "OpenGL dummy library provides headers and a dummy library for EGL/GLES"
SECTION = "devel"
LICENSE = "CLOSED"

PV = "1.0.0"

require opengldummy.inc

do_compile() {
    ${CC} -DQGS_BUILD_CLIENT_DLL -fPIC -shared -Wl,-soname,libEGL.so.1 -I${WORKDIR}/headers -o libEGL.so.1 ${WORKDIR}/egl.cpp
    ${CC} -DQGS_BUILD_CLIENT_DLL -fPIC -shared -Wl,-soname,libGLESv2.so.2 -I${WORKDIR}/headers -o libGLESv2.so.2 ${WORKDIR}/gles2.cpp
}

do_install_append() {
    install -m 0755 -d ${D}${libdir}
    install -m 0755 ${S}/libEGL.so.1 ${D}${libdir}
    ln -s libEGL.so.1 ${D}${libdir}/libEGL.so
    install -m 0755 ${S}/libGLESv2.so.2 ${D}${libdir}
    ln -s libGLESv2.so.2 ${D}${libdir}/libGLESv2.so
}
