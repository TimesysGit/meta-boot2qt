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

DESCRIPTION = "Boot to Qt Demo Launcher"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/main.cpp;md5=1fcdf6b49fbbf2bc9c831893cca1b279;beginline=1;endline=17"

inherit qmake5

SRC_URI = " \
    git://qt-gerrit.it.local/QtRD-15810/b2qt-launcher;branch=${QT_BRANCH};protocol=ssh \
    file://b2qt-startup.sh \
    "

SRCREV = "e824e206f28eb20bcb6f1d9064990f5e927261f4"
QT_BRANCH = "dev"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative \
           ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_install_append() {
	install -m 0755 -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/b2qt-startup.sh ${D}${sysconfdir}/init.d/
}

FILES_${PN} += "${sysdir}/init.d/b2qt-startup.h"

INITSCRIPT_NAME = "b2qt-startup.sh"
INITSCRIPT_PARAMS = "defaults 30"

inherit update-rc.d
