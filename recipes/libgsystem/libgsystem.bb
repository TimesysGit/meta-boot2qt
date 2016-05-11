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

SUMMARY = "LibGSystem is a GIO-based library, targeted primarily for use by operating system components."

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

inherit autotools pkgconfig

SRC_URI = "gitsm://github.com/GNOME/libgsystem.git;protocol=git"
SRCREV = "86c24c181ec6c3ec334a39145efc022c3e744929"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 attr libcap"

do_configure_prepend() {
    # Workaround a broken configure.ac. It should check first if GTK_DOC_CHECK
    # macro is actually defined before trying to use it. For how-to see:
    # https://developer.gnome.org/gtk-doc-manual/stable/settingup_autoconf.html.en
    # We get a syntax error since we do not bundle gnome recipes that define this macro.
    sed -i '/GTK_DOC_CHECK/d' ${S}/configure.ac
}
