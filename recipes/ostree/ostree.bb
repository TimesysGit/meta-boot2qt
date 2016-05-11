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

SUMMARY = "Shared library with a reference command line tool for managing bootable, immutable, versioned filesystem trees."

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

inherit autotools pkgconfig systemd

SRC_URI = " \
    git://github.com/GNOME/ostree.git \
    file://Fix-enable_rofiles_fuse-no-build.patch \
    file://Mount-boot-partition.patch \
    file://Allow-updating-files-in-the-boot-directory.patch \
    file://u-boot-Merge-ostree-s-and-systems-uEnv.txt.patch \
    file://Create-firmware-convenience-symlinks.patch \
    "

SRCREV = "v2016.5"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 e2fsprogs gpgme attr libsoup-2.4 libgsystem libassuan xz"
# Bash is needed by the shipped dracut module. This dracut module is used to generate initramfs image.
# The production image do not require bash for proper working.
RDEPENDS_${PN} += "bash"
RRECOMMENDS_${PN} += "gnupg"

PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)}"
PACKAGECONFIG[systemd] = "--with-systemdsystemunitdir=${systemd_unitdir}/system/,,,"

SYSTEMD_SERVICE_${PN} = "ostree-prepare-root.service ostree-remount.service"
FILES_${PN} += "${systemd_unitdir}/system/ \
                ${libdir}/dracut/"

EXTRA_OECONF = "--with-dracut \
                --without-selinux \
                --without-libarchive \
                --with-builtin-grub2-mkconfig \
                --enable-rofiles-fuse=no \
                --enable-gtk-doc-html=no \
                --enable-man=no \
                --with-soup \
                --enable-libsoup-client-certs"

do_configure_prepend() {
    cd ${S}
    # Update submodules and workaround bugs.
    env NOCONFIGURE=1 ./autogen.sh
    cd -
}
