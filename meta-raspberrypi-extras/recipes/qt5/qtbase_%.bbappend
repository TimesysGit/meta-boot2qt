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

do_configure_prepend_rpi() {
	sed -i 's!load(qt_config)!!' ${S}/mkspecs/linux-oe-g++/qmake.conf
	cat >> ${S}/mkspecs/linux-oe-g++/qmake.conf <<EOF
RPI_CFLAGS              = -DLINUX=1 -DEGL_API_FB=1

QMAKE_INCDIR_EGL        = \$\$[QT_SYSROOT]/usr/include/interface/vcos/pthreads \
                          \$\$[QT_SYSROOT]/usr/include/interface/vmcs_host/linux
QMAKE_INCDIR_OPENGL_ES2 = \$\${QMAKE_INCDIR_EGL}

QMAKE_LIBS_EGL          = -lEGL -lGLESv2
QMAKE_CFLAGS           += \$\$RPI_CFLAGS
QMAKE_CXXFLAGS         += \$\$RPI_CFLAGS

EGLFS_PLATFORM_HOOKS_SOURCES = \$\$PWD/../devices/linux-rasp-pi-g++/qeglfshooks_pi.cpp
EGLFS_PLATFORM_HOOKS_LIBS    = -lbcm_host

load(qt_config)

EOF
}
