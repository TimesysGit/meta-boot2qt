##############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: http://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:COMM$
##
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see http://www.qt.io/terms-conditions. For further
## information use the contact form at http://www.qt.io/contact-us.
##
## $QT_END_LICENSE$
##
##############################################################################

BBMASK ?= " "
BBMASK .= "|meta-fsl-arm/qt5-layer/recipes-qt/qt5"

IMAGE_FSTYPES += "ext3 sdcard"

MACHINE_EXTRA_INSTALL_SDK = " \
        ${@base_contains("DISTRO_FEATURES", "wayland", "libwayland-egl-mx6-dev", "", d)} \
        "

