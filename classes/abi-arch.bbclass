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

# map target architecture to abi architectures used by Qt Creator
valid_archs = "arm x86 itanium mips ppc sh"

def map_abi_arch(a, d):
    import re

    valid_archs = d.getVar('valid_archs', True).split()

    if   re.match('i.86$', a):                  return 'x86'
    elif re.match('x86.64$', a):                return 'x86'
    elif re.match('armeb$', a):                 return 'arm'
    elif re.match('aarch64', a):                return 'arm'
    elif re.match('mips(el|64|64el)$', a):      return 'mips'
    elif re.match('p(pc|owerpc)(|64)', a):      return 'ppc'
    elif re.match('sh(3|4)$', a):               return 'sh'
    elif a in valid_archs:                      return a
    else:
        bb.error("cannot map '%s' to a abi architecture" % a)

ABI = "${@map_abi_arch(d.getVar('TARGET_ARCH', True), d)}"
