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

DESCRIPTION = "Qt component for application lifecycle management"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=311507adb75495acc0b61d69109485ce"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/qtapplicationmanager;branch=${BRANCH};protocol=ssh;sdk-uri=5.6/Src/qtapplicationmanager \
    "

SRCREV = "b7578378b578788c2ae9c60708a2908d3b090c16"
BRANCH = "master"

DEPENDS = "qtbase qtdeclarative libyaml libarchive \
           ${@base_contains("DISTRO_FEATURES", "wayland", "qtwayland", "", d)}"

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "\
    -config force-singleprocess \
    -config enable-dummydata \
    -config enable-ivi-logging \
    -config install-prefix=/usr \
    -config systemd-workaround \
    "

do_install_append() {
    install -m 0755 -d ${D}/opt/am/
    install -m 0644 ${S}/template-opt/am/config.yaml ${D}/opt/am/
}

FILES_${PN} += "\
    /opt/am \
    ${libdir}/appman \
    ${datadir}/dbus-1"
FILES_${PN}-dbg += "${libdir}/appman/.debug"
FILES_${PN}-dev += "${OE_QMAKE_PATH_LIBS}/*.prl"
