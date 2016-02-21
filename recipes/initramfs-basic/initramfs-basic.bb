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

DESCRIPTION = "Basic initramfs image. Useful as a template for more advanced functionality."
LICENSE = "CLOSED"

# findfs from busybox fails to do its jobs, the full version from util-linux-findfs works fine
PACKAGE_INSTALL = "init-basic busybox util-linux-findfs ${ROOTFS_BOOTSTRAP_INSTALL}"

# Do not pollute the initramfs image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "initramfs-basic"
IMAGE_LINGUAS = ""

IMAGE_FSTYPES = "cpio.gz"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

BAD_RECOMMENDATIONS += "busybox-syslog"

