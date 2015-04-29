EXTRA_QMAKEVARS_PRE += "CONFIG+=qtquickcompiler CONFIG+=no_qtquickcompiler_depend"

DEPENDS_prepend = "qtquickcompiler qtquickcompiler-native "

#python __anonymous() {
# do the magic:
# if QT_SDK path is set,
#   add dependency to qtquickcompiler-sdk-native package that
#   copies the needed files (binary and mkspec files) from the SDK
# else
#   add dependency to qtquickcompiler-native package that
#   builds it from internal repos
#}
