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

update_file_timestaps() {
    # Update file timestamp to 0 seconds since Epoch time.
    TZ=UTC find ${IMAGE_ROOTFS} -exec touch -h -m -t '197001010000' {} \;
}

ROOTFS_POSTINSTALL_COMMAND += "update_file_timestaps; "
