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

DESCRIPTION = "Boot to Qt Demo Launcher"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/main.cpp;md5=1fcdf6b49fbbf2bc9c831893cca1b279;beginline=1;endline=17"

inherit qmake5
require recipes-qt/qt5/qt5-git.inc

QT_MODULE = "qt-apps-boot2qt-launcher"

SRC_URI += " \
    file://b2qt-startup.sh \
    file://qtlauncher.service \
    file://b2qt.service \
    "

SRCREV = "f5aaf9297648b397ee8fecb0a494b4774e130422"

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
