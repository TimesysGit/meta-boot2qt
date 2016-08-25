############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

python __anonymous() {
    provider = ""
    sdk_path = d.getVar('B2QTBASE', True) + "/recipes-qt/qt5-addons/qtquickcompiler-sdk"
    pn = d.getVar("PN", True)

    if d.getVar('ENABLE_QTQUICKCOMPILER', True) == "1":
        provider = "qtquickcompiler"
    elif os.path.isdir(sdk_path):
        provider = "qtquickcompiler-sdk"
    else:
        bb.note("qtquickcompiler not enabled for %s" % pn)
        return

    if "toolchain-host" in pn:
        d.appendVar('RDEPENDS_' + pn, " nativesdk-%s-tools" % provider)
    if "toolchain-target" in pn:
        d.appendVar('RDEPENDS_' + pn, " %s-dev" % provider)
    else:
        d.appendVar('DEPENDS', " %s %s-native" % (provider, provider))
        d.appendVar('EXTRA_QMAKEVARS_PRE', " CONFIG+=qtquickcompiler CONFIG+=no_qtquickcompiler_depend")
}
