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

DESCRIPTION = "Neptune IVI UI"
LICENSE = "GPL-3.0 | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=bc0cb4bfd3f72b3fe47b2b2d0d89762c"

inherit qt5-module systemd
require recipes-qt/qt5/qt5-git.inc

QT_MODULE = "qt-apps-neptune-ui"
QT_MODULE_BRANCH = "master"

SRC_URI += " \
    file://neptune.service \
    "

SRCREV = "3d36a7b8e53770c91db60cec9586ef572a2f2814"

DEPENDS = "qtbase qtdeclarative"
RDEPENDS_${PN} = "qtapplicationmanager qtivi qtvirtualkeyboard \
                  ${@bb.utils.contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_configure_prepend() {
    echo "qml.path = /opt/neptune" >> ${S}/neptuneui.pro
}

do_install_append() {
    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/neptune.service ${D}${systemd_unitdir}/system/

    install -m 0644 ${S}/Main*.qml ${D}/opt/neptune
    install -m 0644 ${S}/MainWithCluster.qml ${D}/opt/neptune
    install -m 0644 ${S}/am-config.yaml ${D}/opt/neptune
}

PACKAGES =+ "${PN}-apps"
RRECOMMENDS_${PN} += "${PN}-apps"

FILES_${PN}-apps += "/opt/neptune/apps"
FILES_${PN} += "\
    /opt/neptune \
    "

SYSTEMD_SERVICE_${PN} = "neptune.service"
