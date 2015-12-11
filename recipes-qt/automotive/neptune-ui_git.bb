#############################################################################
##
## Copyright (C) 2014 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

DESCRIPTION = "Neptune IVI UI"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=024d61f4545fb889faa57982553ce094"

inherit qt5-module sdk-sources systemd

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/neptune-ui;branch=${BRANCH};protocol=ssh;sdk-uri=5.6/Src/neptune-ui \
    file://neptune.service \
    "

SRCREV = "09f6cfda7f0d5756f32199485bd54888500f9461"
BRANCH = "master"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"
RDEPENDS_${PN} = "qtapplicationmanager qtivi ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

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
