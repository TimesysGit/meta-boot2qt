#!/bin/sh
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
