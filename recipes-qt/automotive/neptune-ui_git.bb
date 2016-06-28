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

DESCRIPTION = "Neptune IVI UI"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=024d61f4545fb889faa57982553ce094"

inherit qt5-module systemd

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/neptune-ui;branch=${BRANCH};protocol=http \
    file://neptune.service \
    "

SRCREV = "b3f10d156349727310ec30b27d01e639cce4f570"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"
RDEPENDS_${PN} = "qtapplicationmanager qtivi qtvirtualkeyboard \
                  ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_configure_prepend() {
    echo "qml.path = /opt/neptune" >> ${S}/neptuneui.pro
}

do_install_append() {
    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/neptune.service ${D}${systemd_unitdir}/system/

    install -m 0644 ${S}/Main*.qml ${D}/opt/neptune
    install -m 0644 ${S}/am-config.yaml ${D}/opt/neptune
}

PACKAGES =+ "${PN}-apps"
RRECOMMENDS_${PN} += "${PN}-apps"

FILES_${PN}-apps += "/opt/neptune/apps"
FILES_${PN} += "\
    /opt/neptune \
    "

SYSTEMD_SERVICE_${PN} = "neptune.service"
