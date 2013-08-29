DESCRIPTION = "Target packages for B2Qt on embedded Linux SDK"
PR = "r0"
ALLOW_EMPTY_${PN} = "1"
LICENSE = "CLOSED"

PACKAGES = "${PN}"

MACHINE_EXTRA_INSTALL_SDK ?= ""

RDEPENDS_${PN} += "\
    task-core-standalone-sdk-target \
    task-core-standalone-sdk-target-dbg \
    glib-2.0-dev \
    openssl-dev \
    libpng-dev \
    tiff-dev \
    alsa-dev \
    dbus-dev \
    freetype-dev \
    fontconfig-dev \
    gstreamer-dev \
    gst-plugins-base-dev \
    icu-dev \
    libxslt-dev \
    libudev-dev \
    tslib-dev \
    ${MACHINE_EXTRA_INSTALL_SDK} \
    "
