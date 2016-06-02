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

SRCREV_qtwebengine = "69351428413edb7a76ce2ca11634b1797e45e296"
SRCREV_chromium = "dc08e3972d36a63dd477de0de005b3e81a5674d9"
