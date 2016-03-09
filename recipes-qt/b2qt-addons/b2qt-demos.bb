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

DESCRIPTION = "Boot to Qt Demos"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://about-b2qt/AboutBoot2Qt.qml;md5=1bf19846314f7b0fa81dc4db92338713;beginline=1;endline=40"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/demos.git;branch=${BRANCH};protocol=ssh;name=demos;sdk-uri=5.6/Boot2Qt/sources/b2qt-demos \
    ${QT_GIT}/qtcanvas3d.git;branch=${QT_BRANCH};name=qtcanvas3d;destsuffix=qtcanvas3d \
    ${QT_GIT}/qtquickcontrols.git;branch=${QT_BRANCH};name=qtquickcontrols;destsuffix=qtquickcontrols \
    git://codereview.qt-project.org/qt-apps/tqtc-qtwebbrowser.git;branch=${BROWSER_BRANCH};protocol=ssh;name=qtwebbrowser;destsuffix=git/basicsuite/qtwebbrowser/tqtc-qtwebbrowser;sdk-uri=5.6/Boot2Qt/sources/b2qt-demos/basicsuite/qtwebbrowser/tqtc-qtwebbrowser \
    https://s3-eu-west-1.amazonaws.com/qt-files/examples/Videos/Qt_video_720p.webm;name=video1 \
    https://s3-eu-west-1.amazonaws.com/qt-files/examples/Videos/Qt+World+Summit+2015+Recap.mp4;name=video2 \
    "

PV = "5.6+git${SRCPV}"

BRANCH = "5.6"
BROWSER_BRANCH = "dev"
QT_BRANCH = "5.6"
SRCREV_demos = "cdaf26d23204a0a745885ab0db886388618d50db"
SRCREV_qtcanvas3d = "5a17c4ca0552c9f4e6b5646f0cee2b21a55c3d18"
SRCREV_qtquickcontrols = "fc9c57cf8b66bafbcaa6957bb22293047aa3d9df"
SRCREV_qtwebbrowser = "c86bb8a400f79be205025598310926df5d01c7bc"
SRCREV_FORMAT = "demos_qtcanvas3d_qtquickcontrols_qtwebbrowser"

SRC_URI[video1.md5sum] = "56de4dcfd5201952dce9af9c69fcec9b"
SRC_URI[video1.sha256sum] = "809123419acac99353439e52c870e2e497dfa8f434ef0777e6c7303e6ad27f89"
SRC_URI[video2.md5sum] = "e03422de1dba27189872e7d579e7da1b"
SRC_URI[video2.sha256sum] = "651e0b4d2b3272dc10bfc9edba4f0c1a7084cd087c75e8a098f7ba3454c7e485"

S = "${WORKDIR}/git/basicsuite"

DEPENDS = "qtbase qtdeclarative qtxmlpatterns qtquickcontrols qtgraphicaleffects qtsensors qtmultimedia qtcanvas3d \
           ${@base_contains('DISTRO_FEATURES', 'webengine', 'qtwebengine', '', d)}"

do_install_append() {
    # we only need plugins from the demos
    rm -rf ${D}/data/user/camera
    rm -rf ${D}/data/user/sensorexplorer
    rm -rf ${D}/data/user/qtwebbrowser

    # we need all qml and content files
    cp -r ${S}/* ${D}/data/user/qt/

    # but none of the source files
    find ${D}/data/user/qt/ \( -name '*.cpp' -or -name '*.h' -or -name '*.pro' \) -delete
    rm -rf ${D}/data/user/qt/qtwebbrowser/tqtc-qtwebbrowser

    if [ -d ${WORKDIR}/git/images ]; then
        install -d 0755 ${D}/data/images
        install -m 0644 ${WORKDIR}/git/images/* ${D}/data/images/
    fi

    install -d -m 0755 ${D}/data/videos
    install -m 0644 ${WORKDIR}/Qt_video_720p.webm ${D}/data/videos
    install -m 0644 ${WORKDIR}/Qt+World+Summit+2015+Recap.mp4 ${D}/data/videos

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
    /data/user/qt/qmlplugins/*/.debug/ \
    "
