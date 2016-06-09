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

DESCRIPTION = "Qt component for application lifecycle management"
LICENSE = "(GFDL-1.3 & The-Qt-Company-GPL-Exception-1.0 & (LGPL-3.0 | GPL-2.0+)) | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=317fda864ac33d41406ff3938c3e78d1"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/qtapplicationmanager;branch=${BRANCH};protocol=ssh \
    "

SRCREV = "50dd2eb1c4533e80a324bb4b47de6b5a843f6c48"
BRANCH = "5.7"

DEPENDS = "qtbase qtdeclarative libyaml libarchive \
           ${@base_contains("DISTRO_FEATURES", "wayland", "qtwayland", "", d)}"
RDEPENDS_${PN} = "libcrypto"

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "\
    ${@base_contains("DISTRO_FEATURES", "wayland", "-config force-multiprocess", "-config force-singleprocess", d)} \
    -config enable-dummydata \
    -config enable-ivi-logging \
    -config install-prefix=/usr \
    -config systemd-workaround \
    -config hardware-id=neptune \
    "

do_install_append() {
    install -m 0755 -d ${D}/opt/am/
    install -m 0644 ${S}/template-opt/am/config.yaml ${D}/opt/am/
}

FILES_${PN} += "\
    /opt/am \
    ${libdir}/appman \
    ${datadir}/dbus-1"
FILES_${PN}-dbg += "${libdir}/appman/.debug"
FILES_${PN}-dev += "${OE_QMAKE_PATH_LIBS}/*.prl"
