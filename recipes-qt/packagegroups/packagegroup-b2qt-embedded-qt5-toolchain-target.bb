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

DESCRIPTION = "Target packages for B2Qt embedded Qt5 SDK"
LICENSE = "The-Qt-Company-DCLA-2.1"
PR = "r0"

inherit packagegroup qtquickcompiler

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

MACHINE_EXTRA_INSTALL_QT_SDK ?= ""

RDEPENDS_${PN} += " \
    ${MACHINE_EXTRA_INSTALL_QT_SDK} \
    packagegroup-b2qt-embedded-toolchain-target \
    \
    qt3d-dev \
    qtbase-dev \
    qtbase-staticdev \
    qtcanvas3d \
    qtconnectivity-dev \
    qtdeclarative-dev \
    qtdeclarative-render2d-dev \
    qtdeclarative-staticdev \
    qtgraphicaleffects-dev \
    qtimageformats-dev \
    qtlocation-dev \
    qtmultimedia-dev \
    qtquickcontrols-dev \
    qtquickcontrols2-dev \
    qtsensors-dev \
    qtserialbus-dev \
    qtserialport-dev \
    qtsvg-dev \
    qttools-dev \
    qttools-staticdev \
    ${@base_contains('DISTRO_FEATURES', 'wayland', 'qtwayland-dev', '', d)} \
    ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine-dev', '', d)} \
    qtwebsockets-dev \
    qtwebchannel-dev \
    qtxmlpatterns-dev \
    \
    b2qt-utils-dev \
    b2qt-ota-dev \
    qtcharts-dev \
    qtdatavis3d-dev \
    qtvirtualkeyboard-dev \
    "
