DESCRIPTION = "Target packages for B2Qt on embedded Linux SDK"
PR = "r0"
ALLOW_EMPTY_${PN} = "1"
LICENSE = "CLOSED"

PACKAGES = "${PN}"

MACHINE_EXTRA_INSTALL = ""

MACHINE_EXTRA_INSTALL_mx6 = " \
    libgal-mx6 \
    libegl-mx6 \
    libegl-mx6-dev \
    libgles2-mx6 \
    libgles2-mx6-dev \
    "

MACHINE_EXTRA_INSTALL_mx5 = " \
    libgsl-fsl-mx51-dev \
    libegl-mx51-dev \
    libgles2-mx51-dev \
    "

MACHINE_EXTRA_INSTALL_beagleboard = "\
    libgles-omap3-dev \
    "

MACHINE_EXTRA_INSTALL_emulator = "\
    libegl-mesa-dev \
    libgles2-mesa-dev \
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
    ${MACHINE_EXTRA_INSTALL} \
    "
