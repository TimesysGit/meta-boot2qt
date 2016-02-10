# If your distribution supports only qt5, or you don't care
# about conflicts with qt4, then you can add qmake5_paths.bbclass
# to your distro layer and flatten all QT_DIR_NAME directories

QT_DIR_NAME ?= ""

# This is useful for target recipes to reference native mkspecs
QMAKE_MKSPEC_PATH_NATIVE = "${STAGING_LIBDIR_NATIVE}"
QMAKE_MKSPEC_PATH_TARGET = "${STAGING_LIBDIR}"

QMAKE_MKSPEC_PATH = "${QMAKE_MKSPEC_PATH_TARGET}"
QMAKE_MKSPEC_PATH_class-native = "${QMAKE_MKSPEC_PATH_NATIVE}"
QMAKE_MKSPEC_PATH_class-nativesdk = "${QMAKE_MKSPEC_PATH_NATIVE}"

OE_QMAKE_PATH_PREFIX = "${prefix}"
OE_QMAKE_PATH_HEADERS = "${includedir}/qt5"
OE_QMAKE_PATH_LIBS = "${libdir}"
OE_QMAKE_PATH_ARCHDATA = "${libdir}"
OE_QMAKE_PATH_DATA = "${datadir}"
OE_QMAKE_PATH_BINS = "${bindir}"
OE_QMAKE_PATH_LIBEXECS = "${libdir}/libexec"
OE_QMAKE_PATH_PLUGINS = "${libdir}/plugins"
OE_QMAKE_PATH_IMPORTS = "${libdir}/imports"
OE_QMAKE_PATH_QML = "${libdir}/qml"
OE_QMAKE_PATH_TRANSLATIONS = "${datadir}/translations"
OE_QMAKE_PATH_DOCS = "${docdir}"
OE_QMAKE_PATH_SETTINGS = "${sysconfdir}"
OE_QMAKE_PATH_EXAMPLES = "${datadir}/examples"
OE_QMAKE_PATH_TESTS = "${datadir}/tests"
OE_QMAKE_PATH_HOST_PREFIX = ""
OE_QMAKE_PATH_HOST_PREFIX_class-target = "${STAGING_DIR_NATIVE}"
OE_QMAKE_PATH_HOST_BINS = "${bindir}"
OE_QMAKE_PATH_HOST_DATA = "${QMAKE_MKSPEC_PATH_TARGET}"
OE_QMAKE_PATH_HOST_LIBS = "${STAGING_LIBDIR}"
OE_QMAKE_PATH_EXTERNAL_HOST_BINS = "${STAGING_BINDIR_NATIVE}"

# for qt5 components we're using QT_DIR_NAME subdirectory in more
# variables, because we don't want conflicts with qt4
# This block is useful for components which install their
# own files without QT_DIR_NAME but need to reference paths e.g.
# with QT headers
OE_QMAKE_PATH_QT_HEADERS = "${includedir}/qt5"
OE_QMAKE_PATH_QT_ARCHDATA = "${libdir}"
OE_QMAKE_PATH_QT_DATA = "${datadir}"
OE_QMAKE_PATH_QT_BINS = "${bindir}"
OE_QMAKE_PATH_QT_TRANSLATIONS = "${datadir}/translations"
OE_QMAKE_PATH_QT_DOCS = "${docdir}"
OE_QMAKE_PATH_QT_SETTINGS = "${sysconfdir}"
OE_QMAKE_PATH_QT_EXAMPLES = "${datadir}/examples"
OE_QMAKE_PATH_QT_TESTS = "${datadir}/tests"

OE_QMAKE_PATH_QT_FONTS = "${OE_QMAKE_PATH_LIBS}/fonts"
