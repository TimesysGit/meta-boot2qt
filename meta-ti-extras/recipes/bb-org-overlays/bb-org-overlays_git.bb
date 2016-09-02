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

DESCRIPTION = "Device Tree Overlays for bb.org boards"
HOMEPAGE = "https://github.com/beagleboard/bb.org-overlays"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS += "dtc-native"

SRC_URI = "git://github.com/beagleboard/bb.org-overlays"
SRCREV = "c34e3ee970befc511c57e7a42791e588e029b226"

COMPATIBLE_MACHINE = "(beaglebone)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

export DTC = "dtc"

do_install() {
    DESTDIR="${D}" oe_runmake install
}

FILES_${PN} += "/lib/firmware"
