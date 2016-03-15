#!/bin/sh

PATH=/sbin:/bin:/usr/sbin:/usr/bin
ROOT_MOUNT="/sysroot/"
ROOT_DEVICE=""

early_setup() {

    mkdir -p /proc
    mkdir -p /sys
    mount -t proc proc /proc
    mount -t sysfs sysfs /sys
    mount -t devtmpfs none /dev

    mkdir -p /run
    mkdir -p /var/run
}

read_args() {

    for arg in $(cat /proc/cmdline); do
        value=$(echo ${arg} | cut -s -f2- -d '=')
        case $arg in
            root=*)
                root=$value
                ;;
            debugshell*)
                if [ -z "$value" ]; then
                     shelltimeout=30
                else
                     shelltimeout=$value
                fi
                ;;
        esac
    done

    if [ -z "$root" ] ; then
        debug_shell "No root= specified via kernel command line."
    else
        case $root in
            LABEL=*)
                label=${root#LABEL=}
                ;;
            *)
                debug_shell "This init script only supports root=LABEL=* for specifying root file system, but root=$root was provided."
                ;;
        esac
    fi
}

mount_rootfs() {

    mkdir -p $ROOT_MOUNT
    mount $ROOT_DEVICE $ROOT_MOUNT
    mount -n --move /proc $ROOT_MOUNT/proc
    mount -n --move /sys $ROOT_MOUNT/sys
    mount -n --move /dev $ROOT_MOUNT/dev

    exec switch_root $ROOT_MOUNT /sbin/init || debug_shell "Couldn't switch_root."
}

switch_real_root() {

    echo "Searching for media..."
    C=0
    while true
    do

    rootfs=$(findfs LABEL=$label)
    if [ -n "$rootfs" ] ; then
        ROOT_DEVICE=$rootfs
        mount_rootfs
    fi

    # don't wait for more than $shelltimeout seconds, if it's set
    if [ -n "$shelltimeout" ]; then
        echo -n " " $(( $shelltimeout - $C ))
        if [ $C -ge $shelltimeout ]; then
            debug_shell "Cannot find root file system."
        fi
        C=$(( C + 1 ))
    fi

    sleep 1
    done
}

debug_shell() {

    echo ${1}
    echo "Dropping to a shell."
    exec sh
}

main() {

    early_setup
    read_args
    switch_real_root
}

main
