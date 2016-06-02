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

LICENSE = "GFDL-1.3 & (LGPL-3.0 | GPL-2.0)"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPLv3;md5=b8c75190712063cde04e1f41b6fdad98 \
    file://LICENSE.GPLv2;md5=05832301944453ec79e40ba3c3cfceec \
    file://LICENSE.FDL;md5=f70ee9a6c44ae8917586fea34dff0ab5 \
"

DEPENDS += "qtbase qtserialport"

SRCREV = "ec7b4b226818fa39646ec9c619b9df995952ea9c"
