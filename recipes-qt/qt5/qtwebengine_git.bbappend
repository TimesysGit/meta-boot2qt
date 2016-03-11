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

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI_append_mx6 = " \
    file://0001-Fix-slow-video-with-webengine-on-nitrogen6x.patch \
    "

SRCREV_qtwebengine = "1d8efc0b6c26baf4fdf5a7a9a136bf3f7bb8c0f2"
SRCREV_chromium = "eed57693d22920959d6b7c8f2b1b90b501994760"
