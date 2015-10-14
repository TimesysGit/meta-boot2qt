SUMMARY = "Noto Sans CJK"
SECTION = "fonts"
HOMEPAGE = "http://www.google.com/get/noto"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE_CJK.txt;md5=55719faa0112708e946b820b24b14097"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

PV = "1.004"
SRC_URI = "https://noto-website.storage.googleapis.com/pkgs/NotoSansCJKSC-hinted.zip"

SRC_URI[md5sum] = "c0fa6153aa826ee96041ba4470a1f51f"
SRC_URI[sha256sum] = "31459f6d8c36a1136bec3f8d720b2b637e4dded681b7bb610186c9986be25848"

S = "${WORKDIR}"

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${WORKDIR}/*.otf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/otf/noto"
