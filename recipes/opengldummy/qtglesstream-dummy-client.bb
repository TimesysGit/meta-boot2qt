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

DESCRIPTION = "QtGlesStream dummy client provides headers and a dummy library for EGL/GLES"
SECTION = "devel"
LICENSE = "CLOSED"

PV = "1.0.0"
SOLIBMAJOR = "1"
SOLIBMINOR = "0"

require opengldummy.inc

S = "${WORKDIR}"

do_compile() {
    ${CC} -DQGS_BUILD_CLIENT_DLL -fPIC -shared -Wl,-soname,libQtGlesStreamClient.so.${SOLIBMAJOR} \
        -I${WORKDIR}/headers -o libQtGlesStreamClient.so.${PV} ${WORKDIR}/egl.cpp ${WORKDIR}/gles2.cpp
}

do_install_append() {
    install -m 0755 -d ${D}${libdir}
    install -m 0755 ${S}/libQtGlesStreamClient.so.${PV} ${D}${libdir}
    ln -s libQtGlesStreamClient.so.${PV} ${D}${libdir}/libQtGlesStreamClient.so.${SOLIBMAJOR}.${SOLIBMINOR}
    ln -s libQtGlesStreamClient.so.${PV} ${D}${libdir}/libQtGlesStreamClient.so.${SOLIBMAJOR}
    ln -s libQtGlesStreamClient.so.${PV} ${D}${libdir}/libQtGlesStreamClient.so
}
