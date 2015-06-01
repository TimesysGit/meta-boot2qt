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

DAEMON=/usr/bin/emulatorproxyd

case "$1" in
start)
    start-stop-daemon --start --quiet --exec $DAEMON &
    ;;
stop)
    start-stop-daemon --stop --quiet --exec $DAEMON
    ;;
restart)
    start-stop-daemon --stop --quiet --exec $DAEMON
    sleep 1
    start-stop-daemon --start --quiet --exec $DAEMON &
    ;;
*)
    echo "Usage: $0 {start|stop|restart}"
    exit 1
esac
exit 0
