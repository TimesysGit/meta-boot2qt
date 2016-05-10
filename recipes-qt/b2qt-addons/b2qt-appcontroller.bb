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

DESCRIPTION = "Boot to Qt Appcontroller"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://main.cpp;md5=1fcdf6b49fbbf2bc9c831893cca1b279;beginline=1;endline=17"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/appcontroller;branch=${BRANCH};protocol=ssh;sdk-uri=5.7/Boot2Qt/sources/b2qt-appcontroller/ \
    file://appcontroller.conf \
    "

SRCREV = "1e3c96e0e4f28a072c835775f7fdc310eb3b4f28"
BRANCH = "5.7"
PV = "5.7+git${SRCPV}"

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
