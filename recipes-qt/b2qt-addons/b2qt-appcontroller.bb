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

DESCRIPTION = "Boot to Qt Appcontroller"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://main.cpp;md5=1fcdf6b49fbbf2bc9c831893cca1b279;beginline=1;endline=17"

inherit qmake5

SRC_URI = " \
    git://qt-gerrit.it.local/QtRD-15810/b2qt-appcontroller;branch=${QT_BRANCH};protocol=ssh \
    file://appcontroller.conf \
    "

SRCREV = "cac8839211fc5bb53592d3d04c344834c4c054df"
QT_BRANCH = "stable"

S = "${WORKDIR}/git"

DEPENDS = "qtbase"

do_configure_append() {
	sed -i -e '/^platform=/d' ${WORKDIR}/appcontroller.conf
	echo platform=${MACHINE} >> ${WORKDIR}/appcontroller.conf
}

do_install_append() {
	install -m 0755 -d ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/appcontroller.conf ${D}${sysconfdir}/
}

FILES_${PN} += "${sysconfdir}/appcontroller.conf"
