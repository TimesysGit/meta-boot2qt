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

PACKAGECONFIG += "${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'alsa', '', d)} \
                  ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio', '', d)} \
                  ${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer010', 'gstreamer010', 'gstreamer', d)}"

SRCREV = "6d95682d7ff282180655f2f384d8aba69c4f67af"
