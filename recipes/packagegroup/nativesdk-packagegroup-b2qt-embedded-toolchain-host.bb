DESCRIPTION = "Host packages for B2Qt on embedded Linux SDK"
PR = "r0"
ALLOW_EMPTY_${PN} = "1"
LICENSE = "CLOSED"

require recipes-core/packagegroups/nativesdk-packagegroup-sdk-host.bb

RDEPENDS_${PN} = "\
    mkcard-nativesdk \
    python-modules-nativesdk \
    "


