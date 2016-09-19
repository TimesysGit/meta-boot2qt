############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

DESCRIPTION = "Boot to Qt Appcontroller"
LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://main.cpp;md5=1fcdf6b49fbbf2bc9c831893cca1b279;beginline=1;endline=17"

inherit qmake5
require recipes-qt/qt5/qt5-git.inc

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/boot2qt-appcontroller;${QT_MODULE_BRANCH_PARAM};protocol=http \
    file://appcontroller.conf \
    "

SRCREV = "1e3c96e0e4f28a072c835775f7fdc310eb3b4f28"

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
