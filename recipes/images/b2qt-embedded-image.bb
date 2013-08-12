DESCRIPTION = "B2Qt on embedded Linux SDK image"
LICENSE = "CLOSED"
PR = "r0"

IMAGE_FEATURES += "\
        package-management \
        ssh-server-dropbear \
        tools-debug \
        debug-tweaks \
        hwcodecs \
        "

inherit core-image

EXTRA_IMAGEDEPENDS_mx6 += "u-boot-script-boundary"

MACHINE_EXTRA_INSTALL = ""

MACHINE_EXTRA_INSTALL_raspberrypi += "\
        vc-graphics \
        "

MACHINE_EXTRA_INSTALL_mx5 += "\
        amd-gpu-x11-bin-mx51 \
        "

MACHINE_EXTRA_INSTALL_mx6 += "\
        libgal-mx6 \
        libegl-mx6 \
        libgles2-mx6 \
        gst-fsl-plugin \
        "

MACHINE_EXTRA_INSTALL_beagleboard += "\
        libgles-omap3 \
        libgles-omap3-rawdemos \
        "

MACHINE_EXTRA_INSTALL_emulator = "\
        llvm3.2 \
        libegl-mesa \
        libegl-gallium \
        libgles2-mesa \
        mount-vboxsf \
        "

GSTREAMER_EXTRA_INSTALL = "\
        gst-meta-video \
        gst-meta-audio \
        gst-plugins-good \
        gst-plugins-base-app \
        gst-plugins-good-videofilter \
        gst-plugins-good-id3demux \
        gst-plugins-good-auparse \
        gst-plugins-good-isomp4 \
        gst-plugins-ugly-rmdemux \
        gst-plugins-ugly-asf \
        gst-plugins-ugly-a52dec \
        gst-ffmpeg \
        "

TOOLS_EXTRA_INSTALL = "\
        adbd \
        ldd \
        binutils \
        binutils-symlinks \
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
