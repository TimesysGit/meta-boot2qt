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

DESCRIPTION = "Boot to Qt Demo Launcher"
LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://src/main.cpp;md5=9320b0d61b46bdd5f27afcc40a0ad77f;beginline=1;endline=17"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/launcher;branch=${BRANCH};protocol=ssh;sdk-uri=5.7/Boot2Qt/sources/b2qt-launcher \
    file://b2qt-startup.sh \
    file://qtlauncher.service \
    file://b2qt.service \
    "

SRCREV = "1cf3f43163f38d9a00415b61777ecb71f989fe1a"
BRANCH = "5.7"
PV = "5.7+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative \
           ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_install_append() {
    install -m 0755 -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/b2qt-startup.sh ${D}${sysconfdir}/init.d/

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/qtlauncher.service ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/b2qt.service ${D}${systemd_unitdir}/system/
}

INITSCRIPT_NAME = "b2qt-startup.sh"
INITSCRIPT_PARAMS = "defaults 30"

SYSTEMD_SERVICE_${PN} = "qtlauncher.service b2qt.service"

inherit update-rc.d systemd
