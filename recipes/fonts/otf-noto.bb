SUMMARY = "Noto Sans CJK"
SECTION = "fonts"
HOMEPAGE = "http://www.google.com/get/noto"
LICENSE = "Apache-2.0"
# see https://code.google.com/p/noto/issues/detail?id=331
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "http://www.google.com/get/noto/pkgs/NotoSansCJKSC-hinted.zip"

SRC_URI[md5sum] = "9c59b0a684b03d3220dc05c6f7d4a097"
SRC_URI[sha256sum] = "c815b154a57877bfc3c9baa9650f22217e509bddc73f5433f640d875ae6f35e0"

do_install() {
    install -m 0644 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${WORKDIR}/*.otf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/otf/noto"
