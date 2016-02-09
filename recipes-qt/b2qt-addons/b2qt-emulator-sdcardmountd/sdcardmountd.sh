#!/bin/sh
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

DAEMON=/usr/bin/sdcardmountd

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
