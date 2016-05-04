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

DESCRIPTION = "Qt IVI"
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://header.LGPL3-PELAGICORE;md5=0f5beb4df202cb6ef5cbc5296f3a3fa4"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/qt/qtivi;branch=${BRANCH};protocol=ssh \
    "

SRCREV = "2d378320dc07b8b3ac9a9ce89b7f7a99caa72f8a"
BRANCH = "dev"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"
