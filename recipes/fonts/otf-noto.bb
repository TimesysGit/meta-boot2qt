SUMMARY = "Noto Sans CJK"
SECTION = "fonts"
HOMEPAGE = "http://www.google.com/get/noto"
LICENSE = "Apache-2.0"
# see https://code.google.com/p/noto/issues/detail?id=331
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "http://www.google.com/get/noto/pkgs/NotoSansCJKSC-hinted.zip"

SRC_URI[md5sum] = "fdbacee7b538c42cf1d3a6fc3dd3d106"
SRC_URI[sha256sum] = "71d32727053c9677956b7aff7b150c3c2521072f40d334a37806a577d86fa33d"

do_install() {
    install -m 0644 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${WORKDIR}/*.otf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/otf/noto"
