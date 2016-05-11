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

BBMASK ?= " "
BBMASK .= "|meta-toradex/recipes-mozilla|meta-toradex/recipes-browser|meta-toradex/recipes-lxde|meta-toradex/recipes-connectivity|meta-toradex/recipes-gnome|meta-toradex/recipes/trdx-config|meta-toradex/recipes-multimedia/webm|meta-toradex/recipes-qt|meta-toradex/recipes-core/psplash|meta-toradex/recipes-support/florence|meta-toradex/recipes-core/systemd|meta-toradex/recipes-efl|meta-toradex/recipes-core/dropbear|meta-toradex/recipes-support/icu|meta-toradex/recipes-support/i2c-tools|meta-toradex/recipes-benchmark|meta-toradex/recipes-core/udev|meta-toradex/recipes-support/gnutls|meta-toradex/recipes-graphics/gpu-viv-bin-mx6q|meta-toradex/recipes-multimedia/gstreamer|meta-toradex/recipes-fsl/packagegroups|meta-toradex/recipes-core/glibc|meta-toradex/recipes-sato/webkit"
