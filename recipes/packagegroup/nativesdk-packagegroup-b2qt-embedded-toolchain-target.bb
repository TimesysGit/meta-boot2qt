DESCRIPTION = "Target packages for B2Qt on embedded Linux SDK"
PR = "r0"
ALLOW_EMPTY_${PN} = "1"
LICENSE = "CLOSED"

PACKAGES = "${PN}"

SGX_mx6 = " \
    gpu-viv-bin-mx6q-dev \
    libgal-mx6 \
    libgles-mx6-dev \
    libgles2-mx6-dev \
    "

SGX_beagleboard = "\
    libgles-omap3-dev \
    "

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
    ${SGX} \
    "
