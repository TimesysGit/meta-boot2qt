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

DESCRIPTION = "Boot to Qt Utils module"
LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://src/bluetoothsettings/bluetoothdevice.h;md5=f1bb87e7d92738d5c1cc8492a7c03e9a;beginline=1;endline=35"

inherit qt5-module sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/utils;branch=${BRANCH};protocol=ssh;sdk-uri=5.7/Boot2Qt/sources/b2qt-utils \
    "

SRCREV = "15ac9af2680d63321403f49eca03cdb192851bd3"
BRANCH = "5.7"
PV = "5.7+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative wpa-supplicant qtconnectivity"

do_install_append() {
    rm -rf ${D}/opt
}

FILES_${PN}-examples-dbg = " \
    /data/user/qt/.debug/* \
    /data/user/qt/wifi-cpp/.debug/* \
    "

FILES_${PN}-examples = " \
    /data/user/qt/wifi-cpp/wifi-cpp \
    /data/user/qt/wifi-qml \
    "
