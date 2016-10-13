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

DESCRIPTION = "Boot to Qt Wayland Demo Compositor"
LICENSE = "BSD | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://main.cpp;md5=b0a1a6eef4a172b0a8cb4dad9a167d91;beginline=1;endline=49"

inherit qmake5
require recipes-qt/qt5/qt5-git.inc

QT_MODULE = "qt-apps-boot2qt-demos"

SRCREV = "b9585b440819e1444b20f30435f81c46801158c5"

S = "${WORKDIR}/git/wayland/democompositor/"

DEPENDS = "qtbase qtwayland"

FILES_${PN} += "/data/user/democompositor"
FILES_${PN}-dbg += "/data/user/democompositor/.debug"
