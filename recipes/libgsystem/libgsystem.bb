#############################################################################
##
## Copyright (C) 2015 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

SUMMARY = "LibGSystem is a GIO-based library, targeted primarily for use by operating system components."

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

inherit autotools pkgconfig

SRC_URI = "gitsm://github.com/GNOME/libgsystem.git;tag=v2015.2;protocol=git"
S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 attr libcap"

do_configure_prepend() {
    # Workaround a broken configure.ac. It should check first if GTK_DOC_CHECK
    # macro is actually defined before trying to use it. For how-to see:
    # https://developer.gnome.org/gtk-doc-manual/stable/settingup_autoconf.html.en
    # We get a syntax error since we do not bundle gnome recipes that define this macro.
    sed -i '/GTK_DOC_CHECK/d' ${S}/configure.ac
}
