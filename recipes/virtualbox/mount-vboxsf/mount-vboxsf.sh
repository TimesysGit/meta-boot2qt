#!/bin/sh

MOUNTPOINT=/var/vqvideo

case "$1" in
start)
    mkdir -p /var/vqvideo
    /usr/bin/mount.vboxsf vqvideo $MOUNTPOINT
    ;;
stop)
    umount $MOUNTPOINT
    ;;
*)
    echo "Usage: $0 {start|stop}"
    exit 1
esac
exit 0
