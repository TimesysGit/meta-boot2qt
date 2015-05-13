QMAKE_INCDIR_EGL        = $$[QT_SYSROOT]/usr/include/interface/vcos/pthreads \
                          $$[QT_SYSROOT]/usr/include/interface/vmcs_host/linux
QMAKE_INCDIR_OPENGL_ES2 = $${QMAKE_INCDIR_EGL}

QMAKE_LIBS_EGL          = -lEGL -lGLESv2
QMAKE_CFLAGS           += $$RPI_CFLAGS
QMAKE_CXXFLAGS         += $$RPI_CFLAGS

EGLFS_PLATFORM_HOOKS_SOURCES = $$PWD/devices/linux-rasp-pi-g++/qeglfshooks_pi.cpp
EGLFS_PLATFORM_HOOKS_LIBS    = -lbcm_host
