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

DESCRIPTION = "SD-Card mount daemon for Emulator"
LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://sdcardmountd.h;md5=709ec9e3c40137fa6068a903c57acdc1;beginline=1;endline=17"

inherit qmake5

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/emulator;branch=${BRANCH};protocol=ssh \
    file://sdcardmountd.sh \
    file://sdcardmount.service \
    "

SRCREV = "ab4a9f13831f44f3dcd375fa17ed7e102647febe"
BRANCH = "master"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git/src/helperlibs/sdcarddaemon"

DEPENDS = "qtbase qtsimulator"

do_install_append() {
    install -m 0755 -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/sdcardmountd.sh ${D}${sysconfdir}/init.d/

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/sdcardmount.service ${D}${systemd_unitdir}/system/
}

INITSCRIPT_NAME = "sdcardmountd.sh"
INITSCRIPT_PARAMS = "defaults 97 10"

SYSTEMD_SERVICE_${PN} = "sdcardmount.service"

inherit update-rc.d systemd
