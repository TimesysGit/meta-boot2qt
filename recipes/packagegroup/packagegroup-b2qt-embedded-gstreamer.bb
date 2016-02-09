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
