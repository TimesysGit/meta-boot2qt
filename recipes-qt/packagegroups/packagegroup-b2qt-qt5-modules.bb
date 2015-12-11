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

DESCRIPTION = "Qt5 modules"
LICENSE = "QtEnterprise"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS_${PN} += " \
    qt3d \
    qtbase \
    qtbase-fonts \
    qtcanvas3d \
    qtcharts \
    qtconnectivity \
    qtdatavisualization \
    qtdeclarative \
    qtdeclarative-tools \
    qtgraphicaleffects \
    qtimageformats \
    qtlocation \
    qtmultimedia \
    qtquickcontrols \
    qtsensors \
    qtserialbus \
    qtserialport \
    qtsvg \
    qttools \
    qttranslations-qt \
    qttranslations-qtbase \
    qttranslations-qtdeclarative \
    qttranslations-qtconnectivity \
    qttranslations-qtlocation \
    qttranslations-qtmultimedia \
    qttranslations-qtquickcontrols \
    qttranslations-qtserialport \
    qttranslations-qtwebsockets \
    qttranslations-qtxmlpatterns \
    ${@base_contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine qttranslations-qtwebengine', '', d)} \
    qtwebsockets \
    qtwebchannel \
    qtxmlpatterns \
    qtvirtualkeyboard \
    "
