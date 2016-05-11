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

FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"
SRC_URI += " \
    file://dbus-session.init \
    file://dbus-session-address \
    "

INITSCRIPT_PACKAGES = "${PN} ${PN}-session-init"
INITSCRIPT_NAME_${PN}-session-init = "dbus-session"
INITSCRIPT_PARAMS_${PN}-session-init = "start 20 5 3 2 . stop 10 0 1 6 ."

PACKAGES =+ "${PN}-session-init"
FILES_${PN}-session-init = " \
    ${sysconfdir}/init.d/dbus-session \
    ${sysconfdir}/profile.d/dbus-session-address \
    "

do_install_append_class-target() {
    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed 's:@bindir@:${bindir}:' < ${WORKDIR}/dbus-session.init >${WORKDIR}/dbus-session.init.sh
        install -m 0755 ${WORKDIR}/dbus-session.init.sh ${D}${sysconfdir}/init.d/dbus-session
    fi
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 ${WORKDIR}/dbus-session-address ${D}${sysconfdir}/profile.d/
}
