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
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=a40e2bb02b1ac431f461afd03ff9d1d6"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/tqtc-qtwebbrowser;branch=${BRANCH};protocol=ssh;sdk-uri=5.7/Src/qtwebbrowser \
    "

SRCREV = "7c570ee4297946f3ed70565a630d690070533cbd"
BRANCH = "dev"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative qtwebengine"

FILES_${PN} += "/data/user/qt/qtwebbrowser-app"
FILES_${PN}-dbg += "/data/user/qt/qtwebbrowser-app/.debug"
