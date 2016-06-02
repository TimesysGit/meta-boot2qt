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

DESCRIPTION = "Qt Charts"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/charts/qchart.h;md5=a712f087e2146153f45db2e8eb1a3985;beginline=1;endline=17"

inherit qt5-module qtquickcompiler
require recipes-qt/qt5/qt5-git.inc

SRCREV = "d137ae33ccf01882f80770919b1daa199dec7019"

DEPENDS = "qtbase qtdeclarative qtmultimedia"
