DESCRIPTION = "mkcard.sh v0.5"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/bitbake/COPYING;md5=751419260aa954499f7abaabaa882bbe"
SECTION = "devel"
PR = "0"

SRC_URI = "file://mkcard.sh"

do_install () {
    install -d ${D}${bindir}/
    install -m 0755 ${WORKDIR}/mkcard.sh ${D}${bindir}/
}

BBCLASSEXTEND = "nativesdk"
