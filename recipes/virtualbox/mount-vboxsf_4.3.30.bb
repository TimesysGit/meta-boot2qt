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

DESCRIPTION = "VirtualBox Guest Additions for Linux: mount"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/VirtualBox-${PV}/COPYING;md5=e197d5641bb35b29d46ca8c4bf7f2660"

SRC_URI = "http://download.virtualbox.org/virtualbox/${PV}/VirtualBox-${PV}.tar.bz2 \
          file://mount-vboxsf.sh \
          file://mount-vboxsf.service \
          "

SRC_URI[md5sum] = "cc053340f88922a11ad9d4fab56557bd"
SRC_URI[sha256sum] = "ea9569ec16cd6202ee61bcadb2506d31ac12fd343adb91565773a05eaaea9a36"

S = "${WORKDIR}/VirtualBox-${PV}/src/VBox/Additions/linux/sharedfolders"

do_compile() {
    ${CC} mount.vboxsf.c vbsfmount.c -o mount.vboxsf
}

do_install() {
    install -m 0755 -d ${D}${bindir}/
    install -m 0755 mount.vboxsf ${D}${bindir}/
    install -m 0755 ${WORKDIR}/mount-vboxsf.sh ${D}${bindir}/

    install -m 0755 -d ${D}${sysconfdir}/init.d
    ln -s ${bindir}/mount-vboxsf.sh ${D}${sysconfdir}/init.d/

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/mount-vboxsf.service ${D}${systemd_unitdir}/system/
}

INITSCRIPT_NAME = "mount-vboxsf.sh"
INITSCRIPT_PARAMS = "defaults 33"

SYSTEMD_SERVICE_${PN} = "mount-vboxsf.service"

inherit update-rc.d systemd
