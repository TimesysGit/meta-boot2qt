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

require recipes-qt/qt5/qt5.inc
require recipes-qt/qt5/qt5-git.inc

LICENSE = "GFDL-1.3 & (LGPL-3.0 | GPL-3.0)"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPLv3;md5=8ba7f2099d17d636d5fcc8303bb17587 \
    file://LICENSE.GPLv3;md5=40f9bf30e783ddc201497165dfb32afb \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
"

DEPENDS += "qtbase qtxmlpatterns qtdeclarative qtgraphicaleffects"

SRCREV = "ac152bfcd37f94453e9705b57ca6520ad30bade0"

FILES_${PN}-qmldesigner += " \
    ${OE_QMAKE_PATH_QML}/*/*/*/designer \
"
