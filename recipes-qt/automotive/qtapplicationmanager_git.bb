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

DESCRIPTION = "Qt component for application lifecycle management"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=317fda864ac33d41406ff3938c3e78d1"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/qtapplicationmanager;branch=${BRANCH};protocol=ssh;sdk-uri=5.7/Src/qtapplicationmanager \
    "

SRCREV = "97530155847257102fe0a159c681857fb9eb1194"
BRANCH = "5.7"

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
