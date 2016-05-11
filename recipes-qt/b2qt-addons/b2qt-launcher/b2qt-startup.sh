#!/bin/sh
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

case "$1" in
start)
    if [ -x /data/user/b2qt ]; then
        APP="/data/user/b2qt"
    elif [ -x /usr/bin/b2qt ]; then
        APP="/usr/bin/b2qt"
    else
        APP="/usr/bin/qtlauncher --applications-root /data/user/qt"
    fi
    /usr/bin/appcontroller ${APP} &
    ;;
stop)
    /usr/bin/appcontroller --stop
    ;;
*)
    echo "Usage: $0 {start|stop}"
    exit 1
esac
exit 0
