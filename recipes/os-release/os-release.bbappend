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
