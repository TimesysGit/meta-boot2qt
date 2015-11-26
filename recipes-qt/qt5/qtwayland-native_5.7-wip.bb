#############################################################################
##
## Copyright (C) 2014 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

require recipes-qt/qt5/qtwayland-native_git.bb

FILESEXTRAPATHS_append := "${COREBASE}/../meta-qt5/recipes-qt/qt5/qtwayland:"

SRCREV = "22caa63a70245087e0fca51f2186597c232e2d21"
PV = "5.7-wip+git${SRCPV}"
QT_MODULE_BRANCH = "wip-compositor-api"
