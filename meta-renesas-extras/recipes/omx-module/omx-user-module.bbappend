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

# The recipe adds an unpack_append where it creates the folder, but by then
# base.bbclass will have reported a non-existent directory warning.
do_unpack_prepend() {
    bb.utils.mkdirhier(d.getVar('S', True))
}

do_configure[depends] += "\
    mmngr-kernel-module:do_shared_workdir \
    vspm-kernel-module:do_shared_workdir \
    s3ctl-kernel-module:do_shared_workdir \
    fdpm-kernel-module:do_shared_workdir \
    uvcs-kernel-module:do_shared_workdir"
