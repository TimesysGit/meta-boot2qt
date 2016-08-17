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
LICENSE = "(BSD & GPL-3.0) | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504"

inherit qmake5

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/boot2qt-launcher;branch=${BRANCH};protocol=http \
    file://b2qt-startup.sh \
    file://qtlauncher.service \
    file://b2qt.service \
    "

SRCREV = "7ff96b74f8721dbaf50722561770815a4530b6a0"
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
