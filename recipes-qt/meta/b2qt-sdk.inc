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

LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://${QT_LICENCE};md5=7bc9c54e450006250a60e96604c186c9"

inherit populate_sdk populate_sdk_qt5_base

SRC_URI = " \
    file://qmake.conf \
    file://qplatformdefs.h \
    "
S = "${WORKDIR}"

SDK_MKSPEC_DIR = "${SDK_OUTPUT}${SDKTARGETSYSROOT}${libdir}/${QT_DIR_NAME}/mkspecs"
SDK_MKSPEC = "devices/linux-oe-generic-g++"
SDK_DEVICE_PRI = "${SDK_MKSPEC_DIR}/qdevice.pri"
SDK_DYNAMIC_FLAGS = "-O. -pipe -g"

create_sdk_files_append () {
    # Install the toolchain user's generic device mkspec
    install -d ${SDK_MKSPEC_DIR}/${SDK_MKSPEC}
    install -m 0644 ${WORKDIR}/qmake.conf ${SDK_MKSPEC_DIR}/${SDK_MKSPEC}
    install -m 0644 ${WORKDIR}/qplatformdefs.h ${SDK_MKSPEC_DIR}/${SDK_MKSPEC}

    # Fill in the qdevice.pri file which will be used by the device mksspec
    static_cflags="${TARGET_CFLAGS}"
    static_cxxflags="${TARGET_CXXFLAGS}"
    for i in ${SDK_DYNAMIC_FLAGS}; do
        static_cflags=$(echo $static_cflags | sed -e "s/$i //")
        static_cxxflags=$(echo $static_cxxflags | sed -e "s/$i //")
    done
    echo "MACHINE = ${MACHINE}" > ${SDK_DEVICE_PRI}
    echo "CROSS_COMPILE = ${SDKPATHNATIVE}${bindir_nativesdk}/${TARGET_SYS}/${TARGET_PREFIX}" >> ${SDK_DEVICE_PRI}
    echo "QMAKE_CFLAGS *= ${TARGET_CC_ARCH} --sysroot=${SDKTARGETSYSROOT} ${static_cflags}" >> ${SDK_DEVICE_PRI}
    echo "QMAKE_CXXFLAGS *= ${TARGET_CC_ARCH} --sysroot=${SDKTARGETSYSROOT} ${static_cxxflags}" >> ${SDK_DEVICE_PRI}
    echo "QMAKE_LFLAGS *= ${TARGET_CC_ARCH} --sysroot=${SDKTARGETSYSROOT} ${TARGET_LDFLAGS}" >> ${SDK_DEVICE_PRI}

    # Setup qt.conf to point at the device mkspec by default
    qtconf=${SDK_OUTPUT}/${SDKPATHNATIVE}${OE_QMAKE_PATH_HOST_BINS}/qt.conf
    echo 'HostSpec = linux-g++' >> $qtconf
    echo 'TargetSpec = devices/linux-oe-generic-g++' >> $qtconf

    # change staging paths to target sdk paths, so they can be relocated at install time
    sed -i -e 's:${STAGING_DIR_NATIVE}:${SDKPATHNATIVE}:g' ${SDK_MKSPEC_DIR}/*.pri
    sed -i -e 's:${STAGING_DIR}/[^/]*:${SDKTARGETSYSROOT}:g' ${SDK_MKSPEC_DIR}/*.pri
}

SDK_POST_INSTALL_COMMAND += "$SUDO_EXEC sed -i -e "s:$DEFAULT_INSTALL_DIR:$target_sdk_dir:g" \
    $target_sdk_dir/sysroots/@REAL_MULTIMACH_TARGET_SYS@/usr/lib/${QT_DIR_NAME}/mkspecs/*.pri ;"
