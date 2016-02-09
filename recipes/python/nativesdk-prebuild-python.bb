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

LICENSE = "PSFv2"

inherit bin_package nativesdk

SRC_URI[md5sum] = "6d37712f01fa836b1303141a6d4cabda"
SRC_URI[sha256sum] = "3835868c171dddb8cb68ed5578b6d4d639387a038e999a5b008f393b704d6ad7"
SRC_URI = "http://download.qt.io/development_releases/prebuilt/gdb/build-prerequisites/python.zip"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install ${WORKDIR}/python/python27.dll ${D}${bindir}
    install -d ${D}${includedir}
    install ${WORKDIR}/python/include/* ${D}${includedir}
    install -d ${D}${libdir}
    install ${WORKDIR}/python/libs/* ${D}${libdir}
    install -d ${D}${libdir}/python2.7
    cp -r ${WORKDIR}/python/lib/* ${D}${libdir}/python2.7
}

sysroot_stage_dirs_append() {
    sysroot_stage_dir $from${bindir} $to${bindir}
}
