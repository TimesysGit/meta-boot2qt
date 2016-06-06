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

DESCRIPTION = "Additional gstreamer packagegroup for B2Qt embedded Linux image"
LICENSE = "The-Qt-Company-DCLA-2.1"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
        gst-meta-video \
        gst-meta-audio \
        gst-plugins-good \
        gst-plugins-base-app \
        gst-plugins-base-audiorate \
        gst-plugins-base-videorate \
        gst-plugins-base-encodebin \
        gst-plugins-good-videofilter \
        gst-plugins-good-id3demux \
        gst-plugins-good-auparse \
        gst-plugins-good-isomp4 \
        gst-plugins-good-icydemux \
        gst-plugins-good-video4linux2 \
        gst-plugins-good-multifile \
        gst-plugins-good-videocrop \
        gst-plugins-good-jpeg \
        gst-plugins-ugly-rmdemux \
        gst-plugins-ugly-asf \
        gst-plugins-ugly-a52dec \
        gst-plugins-bad-mpegdemux \
        gst-plugins-bad-faad \
        gst-plugins-bad-camerabin2 \
        gst-plugins-bad-jpegformat \
        gst-plugins-ugly-mad \
        gst-plugins-ugly-mpegaudioparse \
        gst-plugins-ugly-mpeg2dec \
        gst-plugins-ugly-mpegstream \
        gst-plugins-bad-mpegvideoparse \
        gst-ffmpeg \
        "
