SUMMARY = "Noto Sans CJK"
SECTION = "fonts"
HOMEPAGE = "http://www.google.com/get/noto"
LICENSE = "Apache-2.0"
# see https://code.google.com/p/noto/issues/detail?id=331
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

PV = "1.004"
SRC_URI = "http://www.google.com/get/noto/pkgs/NotoSansCJKSC-hinted.zip"

SRC_URI[md5sum] = "dc40e8af0b0178451ccc301f1d41e726"
SRC_URI[sha256sum] = "25143bb803ebb20fd17ffd1299012ee2f3a929182ff0700ab656c181872413a4"

do_install() {
    install -m 0644 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${WORKDIR}/*.otf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/otf/noto"
