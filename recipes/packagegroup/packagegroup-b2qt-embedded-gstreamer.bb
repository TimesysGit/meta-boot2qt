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

DESCRIPTION = "Additional gstreamer packagegroup for B2Qt embedded Linux image"
LICENSE = "CLOSED"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
        gstreamer1.0-meta-base \
        gstreamer1.0-meta-video \
        gstreamer1.0-meta-audio \
        gstreamer1.0-plugins-base-meta \
        gstreamer1.0-plugins-good-meta \
        gstreamer1.0-plugins-ugly-meta \
        gstreamer1.0-plugins-bad-meta \
        gstreamer1.0-libav \
        "
