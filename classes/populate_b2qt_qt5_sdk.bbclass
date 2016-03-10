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

inherit populate_b2qt_sdk populate_sdk_qt5_base

SDK_MKSPEC_DIR = "${SDK_OUTPUT}${SDKTARGETSYSROOT}${libdir}/${QT_DIR_NAME}/mkspecs"
SDK_MKSPEC = "devices/linux-oe-generic-g++"
SDK_DEVICE_PRI = "${SDK_MKSPEC_DIR}/qdevice.pri"
SDK_DYNAMIC_FLAGS = "-O. -pipe -g"

create_sdk_files_append () {
    # Create the toolchain user's generic device mkspec
    install -d ${SDK_MKSPEC_DIR}/${SDK_MKSPEC}
    cat > ${SDK_MKSPEC_DIR}/${SDK_MKSPEC}/qmake.conf <<EOF
include(../common/linux_device_pre.conf)
exists(../../oe-device-extra.pri):include(../../oe-device-extra.pri)
include(../common/linux_device_post.conf)
load(qt_config)
EOF

    cat > ${SDK_MKSPEC_DIR}/${SDK_MKSPEC}/qplatformdefs.h <<EOF
#include "../../linux-g++/qplatformdefs.h"
EOF

    # Fill in the qdevice.pri file which will be used by the device mksspec
    static_cflags="${TARGET_CFLAGS}"
    static_cxxflags="${TARGET_CXXFLAGS}"
    for i in ${SDK_DYNAMIC_FLAGS}; do
        static_cflags=$(echo $static_cflags | sed -e "s/$i //")
        static_cxxflags=$(echo $static_cxxflags | sed -e "s/$i //")
    done
    echo "MACHINE = ${MACHINE}" > ${SDK_DEVICE_PRI}
    echo "CROSS_COMPILE = \$\$[QT_HOST_PREFIX]${bindir_nativesdk}/${TARGET_SYS}/${TARGET_PREFIX}" >> ${SDK_DEVICE_PRI}
    echo "QMAKE_CFLAGS *= ${TARGET_CC_ARCH} ${static_cflags}" >> ${SDK_DEVICE_PRI}
    echo "QMAKE_CXXFLAGS *= ${TARGET_CC_ARCH} ${static_cxxflags}" >> ${SDK_DEVICE_PRI}
    echo "QMAKE_LFLAGS *= ${TARGET_CC_ARCH} ${TARGET_LDFLAGS}" >> ${SDK_DEVICE_PRI}

    # Setup qt.conf to point at the device mkspec by default
    qtconf=${SDK_OUTPUT}/${SDKPATHNATIVE}${OE_QMAKE_PATH_HOST_BINS}/qt.conf
    echo 'HostSpec = linux-g++' >> $qtconf
    echo 'TargetSpec = devices/linux-oe-generic-g++' >> $qtconf

    create_qtcreator_configure_script
}

create_qtcreator_configure_script () {
    # add qtcreator configuration script
    install -m 0755 ${B2QTBASE}/scripts/configure-qtcreator.sh ${SDK_OUTPUT}/${SDKPATH}
    sed -i -e '/^CONFIG=/c\CONFIG="${SDKPATH}/environment-setup-${REAL_MULTIMACH_TARGET_SYS}"' ${SDK_OUTPUT}/${SDKPATH}/configure-qtcreator.sh
    sed -i -e '/^ABI=/c\ABI="${ARCH}-linux-generic-elf-${SITEINFO_BITS}bit"' ${SDK_OUTPUT}/${SDKPATH}/configure-qtcreator.sh
}

create_qtcreator_configure_script_mingw32 () {
}
