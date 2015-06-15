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

DESCRIPTION = "Boot to Qt Demos"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://sensors/Accelbubble.qml;md5=1bf19846314f7b0fa81dc4db92338713;beginline=1;endline=40"

inherit qmake5

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/b2qt-demos;branch=${BRANCH};protocol=ssh;name=demos \
    git://code.qt.io/qt-labs/qt5-everywhere-demo.git;protocol=git;name=everywhere;destsuffix=qt5-everywhere-demo \
    git://code.qt.io/qt/qtcanvas3d.git;branch=${QT_BRANCH};protocol=git;name=qtcanvas3d;destsuffix=qtcanvas3d \
    "
BRANCH = "dev"
QT_BRANCH = "5.5.0"
SRCREV_demos = "dcc6470466f8237cc46ac1ac39e865ec2568d702"
SRCREV_everywhere = "6178748a6ea34df40a8e3c9ce67137e33383bb0e"
SRCREV_qtcanvas3d = "0f5e0a235e942e5b274fca7158ac179141014c0a"


S = "${WORKDIR}/git/basicsuite"

DEPENDS = "qtbase qtdeclarative qtxmlpatterns qtquickcontrols qtgraphicaleffects qtsensors qtmultimedia qtcanvas3d \
           ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_install_append() {
    # we only need plugins from the demos
    rm -rf ${D}/data/user/camera
    rm -rf ${D}/data/user/sensorexplorer

    cp -r ${S}/* ${D}/data/user/qt/
    cp -r ${S}/../images ${D}/data/
    cp -r ${S}/../videos ${D}/data/

    cp -r ${WORKDIR}/qt5-everywhere-demo/QtDemo/qml ${D}/data/user/qt/qt5-everywhere/

    # we can't have several top-level windows in b2qt, replace Window -> Rectangle
    sed -i '/import QtQuick.Window/c\' ${D}/data/user/qt/qt5-everywhere/qml/QtDemo/main.qml
    sed -i 's/Window /Rectangle /1' ${D}/data/user/qt/qt5-everywhere/qml/QtDemo/main.qml

    cp ${WORKDIR}/qtcanvas3d/examples/canvas3d/canvas3d/threejs/planets/*.qml  ${D}/data/user/qt/canvas3d-planets
    cp ${WORKDIR}/qtcanvas3d/examples/canvas3d/canvas3d/threejs/planets/*.js ${D}/data/user/qt/canvas3d-planets
    cp -r ${WORKDIR}/qtcanvas3d/examples/canvas3d/canvas3d/threejs/planets/images ${D}/data/user/qt/canvas3d-planets
    cp ${WORKDIR}/qtcanvas3d/examples/canvas3d/canvas3d/threejs/controls/ControlEventSource.qml ${D}/data/user/qt/canvas3d-planets
    cp ${WORKDIR}/qtcanvas3d/examples/canvas3d/canvas3d/3rdparty/*.js ${D}/data/user/qt/canvas3d-planets

    # get rid of qrc:/ prefixes and the custom slider
    sed -i 's/qrc:\(\/\)\?//g' ${D}/data/user/qt/canvas3d-planets/*.qml
    sed -i 's/qrc:\(\/\)\?//g' ${D}/data/user/qt/canvas3d-planets/*.js
    sed -i 's/StyledSlider/Slider/g' ${D}/data/user/qt/canvas3d-planets/planets.qml
    sed -i '39 i import QtQuick.Controls 1.2' ${D}/data/user/qt/canvas3d-planets/planets.qml
}

FILES_${PN} += " \
    /data/images/ \
    /data/videos/ \
    /data/user \
    "

FILES_${PN}-dbg += " \
    /data/user/*/.debug/ \
    /data/user/qt/*/*/.debug/ \
    "
