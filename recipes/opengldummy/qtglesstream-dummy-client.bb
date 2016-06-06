############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

DESCRIPTION = "QtGlesStream dummy client provides headers and a dummy library for EGL/GLES"
SECTION = "devel"
LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://${QT_LICENSE};md5=80e06902b5f0e94ad0a78ee4f7fcb74b"

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
