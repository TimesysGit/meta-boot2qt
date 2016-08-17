DESCRIPTION = "QML Live target runtime"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://../../LICENSE.GPL3;md5=75cd0dbc6f2d24e7eeb128ff59b74f4c"

inherit qmake5 sdk-sources

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI = " \
    git://codereview.qt-project.org/qt-apps/qmllive.git;branch=${BRANCH};protocol=ssh;name=tools \
    file://qmllive-target.patch \
"

BRANCH = "master"
SRCREV_tools="d0d41c71c4691a5f3e2b72e22917f314b4190ffc"

S = "${WORKDIR}/git/src/runtime"

DEPENDS = "qtbase qtdeclarative"
