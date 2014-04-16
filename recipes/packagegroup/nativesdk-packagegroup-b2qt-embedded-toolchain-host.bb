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
## http://qt.digia.com/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

DESCRIPTION = "Host packages for B2Qt on embedded Linux SDK"
PR = "r0"
ALLOW_EMPTY_${PN} = "1"
LICENSE = "CLOSED"

require recipes-core/packagegroups/nativesdk-packagegroup-sdk-host.bb

RDEPENDS_${PN} = "\
    python-nativesdk \
    python-subprocess-nativesdk \
    "


