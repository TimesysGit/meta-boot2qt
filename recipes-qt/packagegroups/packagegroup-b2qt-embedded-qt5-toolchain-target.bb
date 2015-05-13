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

DESCRIPTION = "Target packages for B2Qt embedded Qt5 SDK"
LICENSE = "QtEnterprise"
PR = "r0"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS_${PN} += " \
    packagegroup-b2qt-embedded-toolchain-target \
    qt3d-dev \
    qtbase-dev \
    qtbase-staticdev \
    qtconnectivity-dev \
    qtdeclarative-dev \
    qtdeclarative-staticdev \
    qtgraphicaleffects-dev \
    qtimageformats-dev \
    qtlocation-dev \
    qtmultimedia-dev \
    qtsensors-dev \
    qtserialport-dev \
    qtsvg-dev \
    qtsystems-dev \
    qttools-dev \
    qttools-staticdev \
    ${@base_contains('DISTRO_FEATURES', 'wayland', 'qtwayland-dev', '', d)} \
    qtwebsockets-dev \
    qtwebchannel-dev \
    qtxmlpatterns-dev \
    qtquickcontrols-dev \
    ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine-dev', '', d)} \
    "
