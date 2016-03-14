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

QT_MODULE_BRANCH = "5.6.0"
SRCREV = "d0cdc7ad1e2728caf363abf328b2ad81f2ed5a5b"

FILESEXTRAPATHS_prepend := "${THISDIR}/qtbase:"

SRC_URI += "\
    file://0001-Add-win32-g-oe-mkspec-that-uses-the-OE_-environment.patch \
    "
