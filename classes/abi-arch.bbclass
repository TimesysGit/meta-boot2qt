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
