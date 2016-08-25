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

DESCRIPTION = "QML Live target runtime"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://../../LICENSE.GPL3;md5=75cd0dbc6f2d24e7eeb128ff59b74f4c"

inherit qmake5
require recipes-qt/qt5/qt5-git.inc

QT_MODULE = "qt-apps-qmllive"
QT_MODULE_BRANCH = "master"

SRC_URI += " \
    file://qmllive-target.patch \
    "

SRCREV = "d0d41c71c4691a5f3e2b72e22917f314b4190ffc"

S = "${WORKDIR}/git/src/runtime"

DEPENDS = "qtbase qtdeclarative"
