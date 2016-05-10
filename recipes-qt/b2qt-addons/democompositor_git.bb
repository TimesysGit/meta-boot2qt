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

DESCRIPTION = "Boot to Qt Wayland Demo Compositor"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://main.cpp;md5=9fab217254862959183461343b99a1ab;beginline=1;endline=39"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/demos;branch=${BRANCH};protocol=ssh;sdk-uri=5.7/Boot2Qt/sources/b2qt-demos \
    "

SRCREV = "307b6bec8b73f780a14b13f8dccf0f2cb79bc63c"
BRANCH = "5.7"
PV = "5.7+git${SRCPV}"

S = "${WORKDIR}/git/wayland/democompositor/"

DEPENDS = "qtbase qtwayland"

FILES_${PN} += "/data/user/democompositor"
FILES_${PN}-dbg += "/data/user/democompositor/.debug"
