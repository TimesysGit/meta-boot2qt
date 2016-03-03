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

require recipes-qt/qt5/qtwayland_git.bb

SRCREV = "0b9967d0f16652b0c77d454923bb7a1423792658"
PV = "5.7-wip+git${SRCPV}"
QT_MODULE_BRANCH = "wip-compositor-api"
EXTRA_QMAKEVARS_PRE += "CONFIG+=explicitlib"

SRC_URI_remove = "file://0001-examples-wayland-include-server-buffer-only-when-bui.patch"
