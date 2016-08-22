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

DESCRIPTION = "Qt Quick Compiler"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://compiler/qtquickcompiler.h;md5=02f6307ab0d6c4bd38a1540f16ea705d;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/qt/tqtc-qmlcompiler;branch=${BRANCH};protocol=ssh \
    "

SRCREV = "321c7d8bbc9e25fbb49dbba187b04916eddfdb2a"
BRANCH = "5.6"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"

BBCLASSEXTEND = "native nativesdk"
