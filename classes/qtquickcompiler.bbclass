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

python __anonymous() {
    sdk_path = d.getVar('QT_SDK_PATH', True) or ""
    if len(sdk_path) != 0:
        bb.note("TODO: QtQuickCompiler not yet available for external builds")
    else:
        pn = d.getVar("PN", True)
        if pn.startswith("nativesdk-"):
            d.appendVar('RDEPENDS_' + pn, " nativesdk-qtquickcompiler-tools")
        else:
            d.appendVar('DEPENDS', " qtquickcompiler qtquickcompiler-native")
            d.appendVar('EXTRA_QMAKEVARS_PRE', " CONFIG+=qtquickcompiler CONFIG+=no_qtquickcompiler_depend")
}
