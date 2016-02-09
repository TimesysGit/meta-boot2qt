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
    qtdatavis3d \
    qtdeclarative \
    qtdeclarative-render2d \
    qtdeclarative-tools \
    qtgraphicaleffects \
    qtimageformats \
    qtlocation \
    qtmultimedia \
    qtquickcontrols \
    qtquickcontrols2 \
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
