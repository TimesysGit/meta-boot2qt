QMAKE_INCDIR_EGL        = $$[QT_SYSROOT]/usr/include/interface/vcos/pthreads \
                          $$[QT_SYSROOT]/usr/include/interface/vmcs_host/linux
QMAKE_INCDIR_OPENGL_ES2 = $${QMAKE_INCDIR_EGL}

QMAKE_LIBS_EGL          = -lEGL -lGLESv2
QMAKE_CFLAGS           += $$RPI_CFLAGS
QMAKE_CXXFLAGS         += $$RPI_CFLAGS

EGLFS_DEVICE_INTEGRATION = eglfs_brcm
