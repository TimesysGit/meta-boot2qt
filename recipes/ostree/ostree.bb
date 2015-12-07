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

SUMMARY = "Tool for managing bootable, immutable, versioned filesystem trees."

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

inherit autotools pkgconfig systemd

SRC_URI = " \
    git://github.com/GNOME/ostree.git \
    file://0001-Allow-updating-files-on-the-boot-partition.patch \
    file://0002-u-boot-Merge-ostree-s-and-systems-uEnv.txt.patch \
    file://0003-Allow-updating-files-in-root-of-boot.patch \
    "

SRCREV = "efdb4d8f443768e59529c299290bee8b1f8f93c3"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 e2fsprogs gpgme attr libsoup-2.4 libgsystem libassuan xz"
RRECOMMENDS_${PN} += "gnupg"

PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)}"
PACKAGECONFIG[systemd] = "--with-systemdsystemunitdir=${systemd_unitdir}/system/,,,"

SYSTEMD_SERVICE_${PN} = "ostree-prepare-root.service ostree-remount.service"
FILES_${PN} += "${systemd_unitdir}/system/"

EXTRA_OECONF = "--with-dracut \
                --without-selinux \
                --without-libarchive \
                --with-grub2=no \
                --enable-gtk-doc-html=no \
                --with-soup \
                --enable-libsoup-client-certs"

do_configure_prepend() {
    cd ${S}
    # Update submodules and workaround bugs.
    env NOCONFIGURE=1 ./autogen.sh
    cd -
}

do_install_append() {
    # Silence installed-vs-shipped error message. We provide our own dracut module.
    # The only way to force OSTree to build necessary binaries is to pass "--with-dracut",
    # this of course is a broken configure.ac logic.
    rm -rf ${D}${libdir}/dracut/
}
