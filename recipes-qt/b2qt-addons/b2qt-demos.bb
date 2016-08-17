############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

DESCRIPTION = "Boot to Qt Demos"
LICENSE = "BSD | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://about-b2qt/AboutBoot2Qt.qml;md5=b0a1a6eef4a172b0a8cb4dad9a167d91;beginline=1;endline=49"

inherit qmake5 sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/boot2qt-demos.git;branch=${BRANCH};protocol=http;name=demos \
    ${QT_GIT}/qtcanvas3d.git;branch=${QT_BRANCH};name=qtcanvas3d;destsuffix=qtcanvas3d \
    ${QT_GIT}/qtquickcontrols.git;branch=${QT_BRANCH};name=qtquickcontrols;destsuffix=qtquickcontrols \
    git://codereview.qt-project.org/qt-apps/qtwebbrowser.git;branch=${BROWSER_BRANCH};protocol=http;name=qtwebbrowser;destsuffix=git/basicsuite/qtwebbrowser/tqtc-qtwebbrowser;sdk-uri=5.7/Boot2Qt/sources/b2qt-demos/basicsuite/qtwebbrowser/tqtc-qtwebbrowser \
    https://s3-eu-west-1.amazonaws.com/qt-files/examples/Videos/Qt_video_720p.webm;name=video1 \
    https://s3-eu-west-1.amazonaws.com/qt-files/examples/Videos/Qt+World+Summit+2015+Recap.mp4;name=video2 \
    "

PV = "5.7+git${SRCPV}"

BRANCH = "5.7"
BROWSER_BRANCH = "dev"
QT_BRANCH = "5.7"
SRCREV_demos = "cd9f0c40f30226c7ce1c3259aea8ebca08acfbb8"
SRCREV_qtcanvas3d = "32404e27101c5ec81b4ab965faf38263429bbc5a"
SRCREV_qtquickcontrols = "c6713e212ef0b97c45d6466b73220567e94a05f1"
SRCREV_qtwebbrowser = "7c570ee4297946f3ed70565a630d690070533cbd"
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
    sed -i '/import QtCanvas3D/a import QtQuick.Controls 1.2' ${D}/data/user/qt/canvas3d-planets/planets.qml

    # Qt Quick Extras
    cp -r ${WORKDIR}/qtquickcontrols/examples/quickcontrols/extras/dashboard/qml ${D}/data/user/qt/enterprise-dashboard/
    cp -r ${WORKDIR}/qtquickcontrols/examples/quickcontrols/extras/dashboard/images ${D}/data/user/qt/enterprise-dashboard/

    cp -r ${WORKDIR}/qtquickcontrols/examples/quickcontrols/extras/gallery/qml ${D}/data/user/qt/enterprise-gallery/
    cp -r ${WORKDIR}/qtquickcontrols/examples/quickcontrols/extras/gallery/images ${D}/data/user/qt/enterprise-gallery/
    cp -r ${WORKDIR}/qtquickcontrols/examples/quickcontrols/extras/gallery/fonts ${D}/data/user/qt/enterprise-gallery/

    cp -r ${WORKDIR}/qtquickcontrols/examples/quickcontrols/extras/flat/images ${D}/data/user/qt/enterprise-flat-controls/
    cp ${WORKDIR}/qtquickcontrols/examples/quickcontrols/extras/flat/*.qml ${D}/data/user/qt/enterprise-flat-controls/

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
