DESCRIPTION = "B2Qt on embedded Linux SDK image"
LICENSE = "CLOSED"
PR = "r0"

IMAGE_FEATURES += "\
        package-management \
        ssh-server-dropbear \
        tools-debug \
        tools-profile \
        debug-tweaks \
        hwcodecs \
        "

inherit core-image

MACHINE_EXTRA_INSTALL = ""

MACHINE_EXTRA_INSTALL_mx6 += "\
        gpu-viv-bin-mx6q \
        gst-fsl-plugin \
        "

MACHINE_EXTRA_INSTALL_beagleboard += "\
        libgles-omap3 \
        libgles-omap3-rawdemos \
        "

GSTREAMER_EXTRA_INSTALL = "\
        gst-meta-video \
        gst-meta-audio \
        gst-plugins-good \
        gst-plugins-base-app \
        gst-plugins-good-videofilter \
        gst-plugins-good-id3demux \
        gst-plugins-good-auparse \
        gst-plugins-ugly-rmdemux \
        gst-plugins-ugly-asf \
        gst-plugins-ugly-a52dec \
        "

TOOLS_EXTRA_INSTALL = "\
        ldd \
        "

IMAGE_INSTALL += "\
        psplash \
        openssh-sftp-server \
        openssl \
        libpng \
        jpeg \
        tiff \
        libxslt \
        icu \
        freetype \
        fontconfig \
        liberation-fonts \
        ${GSTREAMER_EXTRA_INSTALL} \
        ${TOOLS_EXTRA_INSTALL} \
        ${MACHINE_EXTRA_INSTALL} \
        "
