SUMMARY = "Noto Sans CJK"
SECTION = "fonts"
HOMEPAGE = "http://www.google.com/get/noto"
LICENSE = "Apache-2.0"
# see https://code.google.com/p/noto/issues/detail?id=331
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

PV = "1.003"
SRC_URI = "http://www.google.com/get/noto/pkgs/NotoSansCJKSC-hinted.zip"

SRC_URI[md5sum] = "88234bce857b885e14878e90c3b39b6e"
SRC_URI[sha256sum] = "c43825352ce901f3ae638f3f20b0ac5995529caf2f4e3ac54148bd20a567179e"

do_install() {
    install -m 0644 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${WORKDIR}/*.otf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/otf/noto"
