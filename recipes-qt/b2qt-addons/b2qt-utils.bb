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

DESCRIPTION = "Boot to Qt Utils module"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/qconnectivity/main.cpp;md5=0b2892e6aca7d0750bbd7fe6b6b1c033;beginline=1;endline=17"

inherit qt5-module sdk-sources

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/b2qt-utils;branch=${BRANCH};protocol=ssh;sdk-uri=5.5/Boot2Qt/sources/b2qt-utils \
    "

SRCREV = "602034c3a71c53d050e67101e070185cbcf7ccee"
BRANCH = "dev"

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
