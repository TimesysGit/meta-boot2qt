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

# To build for the rcar devices you must install the binary gpu drivers as
# follows. These are made available under the name R-Car Series Evaluation
# Software Package for Linux at the following address:
#
#   http://www.renesas.com/secret/r_car_download/rcar_demoboard.jsp
#
# You need two files named as follows:
#  - R-Car_Series_Evaluation_Software_Package_for_Linux-<yyyymmdd>.zip
#  - R-Car_Series_Evaluation_Software_Package_of_Linux_Drivers-<yyyymmdd>.zip
#
# You can place them in any location, below ~/Downloads is assumed. Now do
# the following:
#
#   $ mkdir build && cd build
#   $ export MACHINE=YourMachineHere
#   $ ~/meta-boot2qt/b2qt-init-build-env init --device $MACHINE
#   $ cd sources/meta-renesas
#   $ ./meta-rcar-gen2/docs/sample/copyscript/copy_eva_sw_pkgs.sh ~/Downloads
#
# The script takes as the sole argument the location of the two zips. You must
# be in the right directory when you call the script!
#
# You can now build as usual:
#   $ cd ../..
#   $ . setup-environment.sh
#   $ bitbake b2qt-embedded-image
#

# internal copy of R-Car_Series_Evaluation_Software_Packages used for CI
FILESEXTRAPATHS_append = "${BSPDIR}/sources/renesas-rcar-gen2/${PN}:"

GLES_DRIVER = "sgx"
GLES_DRIVER_r8a7790 = "rgx"

DISTRO_FEATURES += "wayland bluetooth bluez5 h264avcenc_lib"
MACHINE_FEATURES += "multimedia ${GLES_DRIVER}"

IMAGE_FSTYPES += "ext3 sdcard"
IMAGE_CLASSES += "image_types_fsl"

PREFERRED_VERSION_gstreamer1.0-libav = "1.2.3"

PREFERRED_PROVIDER_virtual/libgles2 = "gles-user-module"
PREFERRED_PROVIDER_virtual/egl = "libegl"
PREFERRED_PROVIDER_libgbm = "libgbm"
PREFERRED_PROVIDER_libgbm-dev = "libgbm-dev"

MULTIMEDIA_PACKAGES = " \
    gstreamer1.0-plugins-base-videorate \
    gstreamer1.0-plugins-base-videotestsrc \
    gstreamer1.0-plugins-base-audiotestsrc \
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-video4linux2 \
    gstreamer1.0-plugins-good-videocrop \
    gstreamer1.0-plugins-bad-asfmux \
    gstreamer1.0-plugins-bad-fbdevsink \
    gstreamer1.0-plugins-bad-faad \
    gstreamer1.0-plugins-bad-videoparsersbad \
    packagegroup-rcar-gen2-multimedia \
"

# Unfortunately several Renesas components suffer from various issues requiring workarounds
#   libgbm-dev is required as some part of the binary driver stack attempts to dlopen an unversioned so
#   bash is required as it is hardcoded in a system setup script
#   libdrm-tests appears to be required (to be confirmed?)
RENESAS_WORKAROUNGS = " \
    libgbm-dev \
    bash \
    libdrm-tests \
"

MACHINE_EXTRA_INSTALL = " \
    kernel-devicetree \
    libdrm-kms \
    libegl \
    gles-kernel-module \
    gles-user-module \
    ${RENESAS_WORKAROUNGS} \
    ${@base_contains("MACHINE_FEATURES", "multimedia", "${MULTIMEDIA_PACKAGES}", "", d)} \
"

MACHINE_EXTRA_INSTALL_append_lcb = " \
    can-utils \
    libsocketcan \
    ${@base_contains("MACHINE_FEATURES", "multimedia", "packagegroup-lcb-oss-codecs", "", d)} \
"

BB_MULTIMEDIA_TEST_MODULE = "\
|fdpm-tp-user-module\
|mmngr-tp-user-module\
|mmngrbuf-tp-user-module\
|s3ctl-tp-user-module\
|vspm-tp-user-module\
"

BBMASK ?= " "
BBMASK .= "\
${BB_MULTIMEDIA_TEST_MODULE}\
|dtv-module|ssp-module|scu-module\
|gles-test-module\
|poky/meta/recipes-graphics/mesa\
|meta-fsl-arm/recipes-graphics/mesa\
"
