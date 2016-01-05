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

DEPENDS_${PN}_append_sdkmingw32 = " nativesdk-prebuild-python"
RDEPENDS_${PN}_append_sdkmingw32 = " nativesdk-prebuild-python"
EXTRA_OECONF_append_sdkmingw32 = " --with-python"

do_install_append_sdkmingw32() {
    mkdir -p ${D}${bindir}/lib
    cp -r ${STAGING_DIR_HOST}${exec_prefix}/lib/python2.7/* -d ${D}${bindir}/lib
    cp ${STAGING_DIR_HOST}${exec_prefix}/bin/python27.dll ${D}${bindir}
}
