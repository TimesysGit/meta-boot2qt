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

PROVIDES = "virtual/libgles2 virtual/libgles3 virtual/egl"

SRC_URI = "file://headers \
           file://egl.cpp \
           file://gles2.cpp \
          "

do_install() {
    install -m 0755 -d ${D}${includedir}/EGL
    install -m 0755 ${WORKDIR}/headers/EGL/* ${D}${includedir}/EGL

    install -m 0755 -d ${D}${includedir}/GLES2
    install -m 0755 ${WORKDIR}/headers/GLES2/* ${D}${includedir}/GLES2

    install -m 0755 -d ${D}${includedir}/GLES3
    install -m 0755 ${WORKDIR}/headers/GLES3/* ${D}${includedir}/GLES3

    install -m 0755 -d ${D}${includedir}/KHR
    install -m 0755 ${WORKDIR}/headers/KHR/* ${D}${includedir}/KHR
}
