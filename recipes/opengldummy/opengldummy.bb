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
