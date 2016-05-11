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

# Reported upstream https://bugzilla.yoctoproject.org/show_bug.cgi?id=9144
python do_fix_quotes () {
    with open(d.expand('${B}/os-release'), 'w') as f:
        for field in d.getVar('OS_RELEASE_FIELDS', True).split():
            value = d.getVar(field, True)
            if value:
                f.write('{0}="{1}"\n'.format(field, value))
}

do_verify_if_fixed_by_upstream () {
    pretty_name_first_char=$(cat ${B}/os-release | grep "^PRETTY_NAME" | cut -f 2 -d '=' | cut -c1)
    if [ "${pretty_name_first_char}" = "\"" ]] ; then
        bbwarn "Issue appears to be fixed by upstream, remove this workaround."
    fi
}

addtask do_verify_if_fixed_by_upstream after do_compile before do_install
addtask do_fix_quotes after do_verify_if_fixed_by_upstream before do_install
