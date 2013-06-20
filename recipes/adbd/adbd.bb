DESCRIPTION = "Android Debug Bridge Daemon"
HOMEPAGE = "http://developer.android.com/tools/help/adb.html"
SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://ThirdPartyProject.prop;md5=4e5987c5919a36739dc8f76a4e35d9eb"

PR = "r0"
SRCREV = "android-4.2.2_r1.2"

SRC_URI = "git://android.googlesource.com/platform/system/core;protocol=https;tag=${SRCREV} \
           file://adbd.patch \
           file://Makefile.adbd \
           file://adb-init \
          "

S = "${WORKDIR}/git"

FILES_${PN} += "${bindir}/adbd"

do_compile() {
	make -C adb -f ${WORKDIR}/Makefile.adbd
}

do_install() {
	install -m 0755 -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/git/adb/adbd ${D}${bindir}/

	install -m 0755 -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/adb-init ${D}${sysconfdir}/init.d/
}

INITSCRIPT_NAME = "adb-init"
INITSCRIPT_PARAMS = "defaults 96"

inherit update-rc.d
