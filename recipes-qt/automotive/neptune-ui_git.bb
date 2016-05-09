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
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=bc0cb4bfd3f72b3fe47b2b2d0d89762c"

inherit qt5-module sdk-sources systemd

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/neptune-ui;branch=${BRANCH};protocol=ssh \
    file://neptune.service \
    "

SRCREV = "c405b322d773068521855e048f215c6ec59e965f"
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
