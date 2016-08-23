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

do_deploy_append() {
    if [ "${RPI_FT5406}" = "1" ]; then
        echo "# Enable rpi-ft5406 touch" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtoverlay=rpi-ft5406" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi
}
