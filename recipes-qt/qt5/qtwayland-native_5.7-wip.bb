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

require recipes-qt/qt5/qtwayland-native_git.bb

FILESEXTRAPATHS_append := "${COREBASE}/../meta-qt5/recipes-qt/qt5/qtwayland:"

SRCREV = "22caa63a70245087e0fca51f2186597c232e2d21"
PV = "5.7-wip+git${SRCPV}"
QT_MODULE_BRANCH = "wip-compositor-api"
