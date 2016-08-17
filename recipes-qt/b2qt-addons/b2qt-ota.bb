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

DESCRIPTION = "Qt OTA Update module"
LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://src/lib/qotaclient.h;md5=da66cc6e520f8151501c0f6c11480077;beginline=1;endline=28"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/qt/qtotaupdate;branch=${BRANCH};protocol=http \
    "

SRCREV = "d8d81530692454e4e38f682f6a09049d27b8c1ad"
BRANCH = "master"
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative ostree"

