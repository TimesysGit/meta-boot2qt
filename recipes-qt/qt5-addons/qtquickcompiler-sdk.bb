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

DESCRIPTION = "Qt Quick Compiler using prebuilt binaries from Qt SDK"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://${QT_LICENCE};md5=7bc9c54e450006250a60e96604c186c9"

inherit allarch qmake5_paths

DEPENDS = "qtbase"

S = "${WORKDIR}"

QT_VERSION = "5.6"

NATIVESDK_BINARY = "qtquickcompiler"
NATIVESDK_BINARY_mingw32 = "qtquickcompiler.exe"

do_install() {
    install -d ${D}${OE_QMAKE_PATH_ARCHDATA}/mkspecs/features
    install -m 0755 ${THISDIR}/qtquickcompiler-sdk/mkspecs/features/qtquickcompiler.prf ${D}${OE_QMAKE_PATH_ARCHDATA}/mkspecs/features
    install -d ${D}${OE_QMAKE_PATH_ARCHDATA}/cmake/Qt5QuickCompiler
    install -m 0644 ${THISDIR}/qtquickcompiler-sdk/lib/cmake/Qt5QuickCompiler/Qt5QuickCompilerConfig.cmake ${D}${OE_QMAKE_PATH_ARCHDATA}/cmake/Qt5QuickCompiler

    if [ "${PN}" = "qtquickcompiler-sdk-native" ]; then
        install -d ${D}${OE_QMAKE_PATH_BINS}
        install -m 0755 ${THISDIR}/qtquickcompiler-sdk/bin/qtquickcompiler ${D}${OE_QMAKE_PATH_BINS}
    elif [ "${PN}" = "nativesdk-qtquickcompiler-sdk" ]; then
        install -d ${D}${OE_QMAKE_PATH_BINS}
        install -m 0755 ${THISDIR}/qtquickcompiler-sdk/bin/${NATIVESDK_BINARY} ${D}${OE_QMAKE_PATH_BINS}
    fi
}

INHIBIT_PACKAGE_STRIP = "1"
ALLOW_EMPTY_${PN} = "1"
PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${OE_QMAKE_PATH_BINS}"
FILES_${PN}-dev = "${OE_QMAKE_PATH_ARCHDATA}"

BBCLASSEXTEND = "native nativesdk"
