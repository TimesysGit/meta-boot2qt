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

DESCRIPTION = "B2Qt Automotive Qt5 image"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://${QT_LICENCE};md5=7bc9c54e450006250a60e96604c186c9"
PR = "r0"

DEPLOY_CONF_TYPE = "Automotive"

IMAGE_FEATURES += "\
        package-management \
        ssh-server-dropbear \
        tools-debug \
        debug-tweaks \
        hwcodecs \
        "

inherit core-image
inherit bootfs-image

MACHINE_EXTRA_INSTALL_QT ?= ""

IMAGE_INSTALL += "\
    ${MACHINE_EXTRA_INSTALL_QT} \
    packagegroup-b2qt-embedded-base \
    packagegroup-b2qt-embedded-tools \
    ${@base_contains("DISTRO_FEATURES", "gstreamer010", "packagegroup-b2qt-embedded-gstreamer010", "", d)} \
    ${@base_contains("DISTRO_FEATURES", "gstreamer", "packagegroup-b2qt-embedded-gstreamer", "", d)} \
    packagegroup-b2qt-qt5-modules \
    packagegroup-b2qt-automotive-addons \
    "
