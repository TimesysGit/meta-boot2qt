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

DESCRIPTION = "Qt Web Browser"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://src/main.cpp;md5=e78c6c33aa5ec2464456b72daf61ef9c;beginline=1;endline=36"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/tqtc-qtwebbrowser;branch=${BRANCH};protocol=ssh;sdk-uri=5.6/Src/qtwebbrowser \
    "

SRCREV = "2e18b419a7084b1e39bf8749855768a1002e34de"
BRANCH = "dev"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative qtwebengine"

FILES_${PN} += "/data/user/qt/qtwebbrowser"
FILES_${PN}-dbg += "/data/user/qt/qtwebbrowser/.debug"
