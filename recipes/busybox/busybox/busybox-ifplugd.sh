#!/bin/sh
DAEMON=/usr/sbin/ifplugd
NAME=ifplugd
DESC="Busybox IFPLUG Server"
ARGS="-i eth0"

test -f $DAEMON || exit 1

set -e

case "$1" in
	start)
		echo -n "starting $DESC: $NAME... "
		/sbin/start-stop-daemon -S -b -n $NAME -a $DAEMON -- $ARGS
		echo "done."
	;;
	stop)
		echo -n "stopping $DESC: $NAME... "
		/sbin/start-stop-daemon -K -n $NAME
		echo "done."
	;;
	restart)
		echo "restarting $DESC: $NAME... "
		$0 stop
		$0 start
		echo "done."
	;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
	;;
esac
