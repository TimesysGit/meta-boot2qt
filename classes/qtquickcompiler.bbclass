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

python __anonymous() {
    provider = "qtquickcompiler"

    sdk_path = d.getVar('QT_SDK_PATH', True) or ""
    if len(sdk_path) != 0:
        qtquickcompiler_path = d.getVar('B2QTBASE', True) + "/recipes-qt/qt5-addons/qtquickcompiler-sdk"
        if not os.path.isdir(qtquickcompiler_path):
            bb.note("QtQuickCompiler not available")
            return
        else:
            provider = "qtquickcompiler-sdk"

    pn = d.getVar("PN", True)
    if "toolchain-host" in pn:
        d.appendVar('RDEPENDS_' + pn, " nativesdk-%s-tools" % provider)
    if "toolchain-target" in pn:
        d.appendVar('RDEPENDS_' + pn, " %s-dev" % provider)
    else:
        d.appendVar('DEPENDS', " %s %s-native" % (provider, provider))
        d.appendVar('EXTRA_QMAKEVARS_PRE', " CONFIG+=qtquickcompiler CONFIG+=no_qtquickcompiler_depend")
}
