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

DESCRIPTION = "Boot to Qt Utils module"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/wifi/qwifimanager.h;md5=0b2892e6aca7d0750bbd7fe6b6b1c033;beginline=1;endline=17"

inherit qt5-module sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/utils;branch=${BRANCH};protocol=ssh;sdk-uri=5.6/Boot2Qt/sources/b2qt-utils \
    "

SRCREV = "2b81f8dbc97b446b33fb67e3196a8726ed195008"
BRANCH = "5.6"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative wpa-supplicant"

FILES_${PN}-examples-dbg = " \
    /data/user/qt/.debug/* \
    /data/user/qt/wifi-cpp/.debug/* \
    "

FILES_${PN}-examples = " \
    /data/user/qt/wifi-cpp/wifi-cpp \
    /data/user/qt/wifi-qml \
    "
