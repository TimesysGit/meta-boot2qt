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

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Disable-angle-for-embedded-linux.patch \
    "
SRC_URI_append_mx6 = " \
    file://0001-Fix-slow-video-with-webengine-on-nitrogen6x.patch \
    "

SRCREV_qtwebengine = "6106d6b0b3833e63aeb568f37a47fc6adca8fdb9"
SRCREV_chromium = "8158f645b0cfea734b5ff99777227380f615873f"
