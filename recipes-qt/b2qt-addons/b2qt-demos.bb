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

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/demos;branch=${BRANCH};protocol=ssh;name=demos;sdk-uri=5.5/Boot2Qt/sources/b2qt-demos \
    git://code.qt.io/qt-labs/qt5-everywhere-demo.git;protocol=git;name=everywhere;destsuffix=qt5-everywhere-demo \
    git://code.qt.io/qt/qtcanvas3d.git;branch=${QT_BRANCH};protocol=git;name=qtcanvas3d;destsuffix=qtcanvas3d \
    git://code.qt.io/qt/qtquickcontrols.git;branch=${QT_BRANCH};protocol=git;name=qtquickcontrols;destsuffix=qtquickcontrols \
    "

BRANCH = "dev"
QT_BRANCH = "5.5"
SRCREV_demos = "de50ff5dbf2f789786e25540ba0b0efc8c68e0f9"
SRCREV_everywhere = "6178748a6ea34df40a8e3c9ce67137e33383bb0e"
SRCREV_qtcanvas3d = "debe68a85b571b70e2fe0824e5ed40484a72c216"
SRCREV_qtquickcontrols = "b4dc4a98d5deffbbb30f7011f6c0d3d10f430b98"


S = "${WORKDIR}/git/basicsuite"

DEPENDS = "qtbase qtdeclarative qtxmlpatterns qtquickcontrols qtgraphicaleffects qtsensors qtmultimedia qtcanvas3d \
           ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_install_append() {
    # we only need plugins from the demos
    rm -rf ${D}/data/user/camera
    rm -rf ${D}/data/user/sensorexplorer

    cp -r ${S}/* ${D}/data/user/qt/
    if [ -d ${S}/../images ]; then
        cp -r ${S}/../images ${D}/data/
    fi
    if [ -d ${S}/../videos ]; then
        cp -r ${S}/../videos ${D}/data/
    fi

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

    # Qt Quick Extras
    cp -r ${WORKDIR}/qtquickcontrols/examples/quick/extras/dashboard/qml ${D}/data/user/qt/enterprise-dashboard/
    cp -r ${WORKDIR}/qtquickcontrols/examples/quick/extras/dashboard/images ${D}/data/user/qt/enterprise-dashboard/

    cp -r ${WORKDIR}/qtquickcontrols/examples/quick/extras/gallery/qml ${D}/data/user/qt/enterprise-gallery/
    cp -r ${WORKDIR}/qtquickcontrols/examples/quick/extras/gallery/images ${D}/data/user/qt/enterprise-gallery/
    cp -r ${WORKDIR}/qtquickcontrols/examples/quick/extras/gallery/fonts ${D}/data/user/qt/enterprise-gallery/

    cp -r ${WORKDIR}/qtquickcontrols/examples/quick/extras/flat/images ${D}/data/user/qt/enterprise-flat-controls/
    cp ${WORKDIR}/qtquickcontrols/examples/quick/extras/flat/*.qml ${D}/data/user/qt/enterprise-flat-controls/

    sed -i '/import QtQuick.Window/c\' ${D}/data/user/qt/enterprise-dashboard/qml/dashboard.qml ${D}/data/user/qt/enterprise-gallery/qml/gallery.qml
    sed -i 's/Window /Rectangle /1' ${D}/data/user/qt/enterprise-dashboard/qml/dashboard.qml ${D}/data/user/qt/enterprise-gallery/qml/gallery.qml
    sed -i 's/ApplicationWindow /Rectangle /1' ${D}/data/user/qt/enterprise-flat-controls/main.qml
    sed -i '/title: "Qt Quick Extras Demo"/c\' ${D}/data/user/qt/enterprise-dashboard/qml/dashboard.qml ${D}/data/user/qt/enterprise-gallery/qml/gallery.qml
    sed -i '/title: "Flat Example"/c\' ${D}/data/user/qt/enterprise-flat-controls/main.qml
    sed -i 's/"Light Flat UI Demo"/"Qt Quick Controls"/1' ${D}/data/user/qt/enterprise-flat-controls/main.qml
    sed -i '/{ name: "Exit", action: null }/c\' ${D}/data/user/qt/enterprise-flat-controls/main.qml

    sed -i -e 's/qrc:/../g' ${D}/data/user/qt/enterprise-dashboard/qml/* ${D}/data/user/qt/enterprise-gallery/qml/*
    sed -i 's/qrc:\///g' ${D}/data/user/qt/enterprise-flat-controls/Content.qml
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
