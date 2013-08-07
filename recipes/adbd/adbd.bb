DESCRIPTION = "Android Debug Bridge Daemon"
HOMEPAGE = "http://developer.android.com/tools/help/adb.html"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://NOTICE;md5=2ddb23e63b1f9c3c46aaa4195f819a6d"

PV = "android-4.2.2_r1.2"
PR = "r0"
SRCREV = "${PV}"

RRECOMMENDS_${PN} += "kernel-module-g-ffs"

SRC_URI = "git://android.googlesource.com/platform/system/core;protocol=https \
           file://adbd.patch;striplevel=2 \
           file://Makefile.adbd \
           file://adb-init \
          "

S = "${WORKDIR}/git/adb"

FILES_${PN} += "${bindir}/adbd"

PRODUCTID_beagleboard = "0x9018"
PRODUCTID_mx6 = "0x0d02"
PRODUCTID_raspberrypi = "0xabcd"

do_configure() {
	if [ -n "${PRODUCTID}" ]; then
		sed -i -e 's/PRODUCT=.*/PRODUCT=${PRODUCTID}/' ${WORKDIR}/adb-init
	fi
}

do_compile() {
	make -f ${WORKDIR}/Makefile.adbd
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
