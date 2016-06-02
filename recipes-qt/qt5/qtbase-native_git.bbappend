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

SRCREV = "540978288ea0f6ed0b166bb9207f427a4c825ab6"

FILESEXTRAPATHS_prepend := "${THISDIR}/qtbase:"

SRC_URI += "\
    file://0001-Add-win32-g-oe-mkspec-that-uses-the-OE_-environment.patch \
    "
