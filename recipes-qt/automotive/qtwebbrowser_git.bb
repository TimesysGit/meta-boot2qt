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

DESCRIPTION = "Qt Web Browser"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=a40e2bb02b1ac431f461afd03ff9d1d6"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/tqtc-qtwebbrowser;branch=${BRANCH};protocol=http;sdk-uri=5.7/Src/qtwebbrowser \
    "

SRCREV = "023733af5523a5ad84359926224fa106001215f4"
BRANCH = "dev"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative qtwebengine"

FILES_${PN} += "/data/user/qt/qtwebbrowser-app"
FILES_${PN}-dbg += "/data/user/qt/qtwebbrowser-app/.debug"
