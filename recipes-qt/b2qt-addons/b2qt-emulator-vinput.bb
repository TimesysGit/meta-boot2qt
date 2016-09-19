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

DESCRIPTION = "Virtual input plugin for QtSimulator"
LICENSE = "The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://qvinput.h;md5=f25c7436dbc72d4719a5684b28dbcf4b;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/emulator;branch=${BRANCH};protocol=ssh \
    "

SRCREV = "011e1c40716c8323f247e927de6640653d6811c4"
BRANCH = "master"
PV = "1.0+git${SRCPV}"

EXTRA_QMAKEVARS_PRE += "CONFIG+=force_independent"

S = "${WORKDIR}/git/src/helperlibs/vinput"

DEPENDS = "qtbase qtsimulator"
