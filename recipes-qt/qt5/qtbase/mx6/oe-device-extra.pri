IMX6_CFLAGS             = -DLINUX=1 -DEGL_API_FB=1
QMAKE_LIBS_EGL         += -lEGL
QMAKE_LIBS_OPENGL_ES2  += -lGLESv2 -lEGL -lGAL
QMAKE_LIBS_OPENVG      += -lOpenVG -lEGL -lGAL
QMAKE_CFLAGS           += $$IMX6_CFLAGS
QMAKE_CXXFLAGS         += $$IMX6_CFLAGS

EGLFS_PLATFORM_HOOKS_SOURCES = $$PWD/devices/linux-imx6-g++/qeglfshooks_imx6.cpp
