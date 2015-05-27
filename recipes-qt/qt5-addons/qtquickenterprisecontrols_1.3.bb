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

DESCRIPTION = "Qt Quick Enterprise Controls"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://src/controls/Styles/Base/DialStyle.qml;md5=caa6d9db463140360114e567721eb580;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://qt-gerrit.ci.local/QtRD-15810/qtquick-extras.git;branch=${QT_BRANCH};protocol=ssh \
    "

SRCREV = "ed6f7049e06717113d5f500595c5a1f2074fb13d"
QT_BRANCH = "master"

S = "${WORKDIR}/git"

PACKAGES += "${PN}-fonts"

RRECOMMENDS_${PN} = "${PN}-fonts"

DEPENDS += "qtbase qtdeclarative qtgraphicaleffects"

FILES_${PN}-fonts += " \
    /usr/lib/qt5/qml/QtQuick/Controls/Styles/Flat/fonts \
    "
FILES_${PN} += " \
    /opt/dashboard/bin/dashboard \
    /opt/gallery/bin/gallery \
    "
FILES_${PN}-dbg += " \
    /opt/dashboard/bin/.debug \
    /opt/gallery/bin/.debug \
    "
FILES_${PN}-qmlplugins += " \
	${OE_QMAKE_PATH_QML}/QtQuick/Enterprise/Controls/Styles/*/*.qml \
	${OE_QMAKE_PATH_QML}/QtQuick/Enterprise/Controls/designer/* \
	${OE_QMAKE_PATH_QML}/QtQuick/Enterprise/Controls/Styles/*/*/* \
    "
FILES_${PN}-examples += " \
    /opt/flat/bin/flat \
    "
FILES_${PN}-examples-dbg += " \
    /opt/flat/bin/.debug \
    "
