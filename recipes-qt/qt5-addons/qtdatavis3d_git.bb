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

DESCRIPTION = "Qt Data Visualization"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/datavisualization/global/qdatavisualizationglobal.h;md5=80b80e41be7c22f5b90fc96163b7d1bf;beginline=1;endline=17"

inherit qt5-module
require recipes-qt/qt5/qt5-git.inc

SRCREV = "4f23f0f984ef2ee96d5baa3a74a465d6734381ba"

DEPENDS += "qtbase qtdeclarative qtmultimedia"
