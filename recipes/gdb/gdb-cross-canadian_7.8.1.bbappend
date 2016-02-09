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

DEPENDS_${PN}_append_sdkmingw32 = " nativesdk-prebuild-python"
RDEPENDS_${PN}_append_sdkmingw32 = " nativesdk-prebuild-python"
EXTRA_OECONF_append_sdkmingw32 = " --with-python"

do_install_append_sdkmingw32() {
    mkdir -p ${D}${bindir}/lib
    cp -r ${STAGING_DIR_HOST}${exec_prefix}/lib/python2.7/* -d ${D}${bindir}/lib
    cp ${STAGING_DIR_HOST}${exec_prefix}/bin/python27.dll ${D}${bindir}
}
