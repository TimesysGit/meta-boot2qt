SUMMARY = "A free implementation of the OpenGL API"
DESCRIPTION = "Mesa is an open-source implementation of the OpenGL specification - \
a system for rendering interactive 3D graphics.  \
A variety of device drivers allows Mesa to be used in many different environments \
ranging from software emulation to complete hardware acceleration for modern GPUs. \
Mesa is used as part of the overall Direct Rendering Infrastructure and X.org \
environment."

HOMEPAGE = "http://mesa3d.org"
BUGTRACKER = "https://bugs.freedesktop.org"
SECTION = "x11"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://docs/license.html;md5=42d77d95cba529a3637129be87d6555d"

INC_PR = "r9"
PE = "2"

export WANT_LLVM_RELEASE = "3.2"

DEPENDS = "expat makedepend-native flex-native bison-native llvm${WANT_LLVM_RELEASE}"

PROVIDES = "virtual/libgl virtual/libgles1 virtual/libgles2 virtual/egl"

inherit autotools pkgconfig pythonnative

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2 \
           file://EGL-Mutate-NativeDisplayType-depending-on-config.patch \
           file://fix-glsl-cross.patch \
           file://0001-configure-Avoid-use-of-AC_CHECK_FILE-for-cross-compi.patch \
           file://0001-llvmpipe-remove-the-power-of-two-sizeof-struct-cmd_b.patch \
           file://0001-fix-xlib-dependency-from-pipe-loader.patch \
           file://glapi.patch \
           "

SRC_URI[md5sum] = "952ccd03547ed72333b64e1746cf8ada"
SRC_URI[sha256sum] = "8d5dac2202d0355bff5cfd183582ec8167d1d1227b7bb7a669acecbeaa52d766"

S = "${WORKDIR}/Mesa-${PV}"

EXTRA_OECONF = " \
                --enable-opengl \
                --enable-gles2 \
                --enable-egl --with-egl-platforms=fbdev \
                --enable-gallium --enable-gallium-llvm --enable-gallium-egl --with-llvm-shared-libs --with-gallium-drivers="swrast" \
                --enable-shared-glapi \
                --disable-glx \
                --enable-dri --with-dri-drivers="" \
                --disable-gles1 \
                --disable-gles3 \
                --disable-openvg \
                "

# llvmpipe is slow if compiled with -fomit-frame-pointer (e.g. -O2)
FULL_OPTIMIZATION_append = " -fno-omit-frame-pointer"

# Multiple virtual/gl providers being built breaks staging
EXCLUDE_FROM_WORLD = "1"

# Remove the mesa dependency on mesa-dev, as mesa is empty
RDEPENDS_${PN}-dev = ""

PACKAGES =+ "libegl-mesa libegl-mesa-dev \
             libglapi libglapi-dev \
             libgles2-mesa libgles2-mesa-dev \
             libegl-gallium \
            "

do_install_append () {
    # Drivers never need libtool .la files
    rm -f ${D}${libdir}/egl/*.la
    rm -f ${D}${libdir}/gallium-pipe/*.la
}

# For the packages that make up the OpenGL interfaces, inject variables so that
# they don't get Debian-renamed (which would remove the -mesa suffix), and
# RPROVIDEs/RCONFLICTs on the generic libgl name.
python __anonymous() {
    for p in (("libegl", "libegl1"), ("libgl", "libgl1"),
              ("libgles1", "libglesv1-cm1"), ("libgles2", "libglesv2-2"),
              ("libgles3",)):
        fullp = p[0] + "-mesa"
        pkgs = " ".join(p)
        d.setVar("DEBIAN_NOAUTONAME_" + fullp, "1")
        d.appendVar("RREPLACES_" + fullp, pkgs)
        d.appendVar("RPROVIDES_" + fullp, pkgs)
        d.appendVar("RCONFLICTS_" + fullp, pkgs)

        # For -dev, the first element is both the Debian and original name
        fullp += "-dev"
        pkgs = p[0] + "-dev"
        d.setVar("DEBIAN_NOAUTONAME_" + fullp, "1")
        d.appendVar("RREPLACES_" + fullp, pkgs)
        d.appendVar("RPROVIDES_" + fullp, pkgs)
        d.appendVar("RCONFLICTS_" + fullp, pkgs)
}

python mesa_populate_packages() {
    pipe_drivers_root = os.path.join(d.getVar('libdir', True), "gallium-pipe")
    do_split_packages(d, pipe_drivers_root, '^pipe_(.*)\.so$', 'mesa-driver-pipe-%s', 'Mesa %s pipe driver', extra_depends='')
}

PACKAGESPLITFUNCS_prepend = "mesa_populate_packages "

PACKAGES_DYNAMIC += "^mesa-driver-.*"

FILES_libegl-mesa = "${libdir}/libEGL.so.*"
FILES_libgles2-mesa = "${libdir}/libGLESv2.so.*"
FILES_libglapi = "${libdir}/libglapi.so.*"
FILES_libegl-gallium = "${libdir}/egl/egl_gallium.so* ${libdir}/egl/st_GL.so*"

FILES_libegl-mesa-dev = "${libdir}/libEGL.* ${includedir}/EGL ${includedir}/KHR ${libdir}/pkgconfig/egl.pc"
FILES_libglapi-dev = "${libdir}/libglapi.*"
FILES_libgles2-mesa-dev = "${libdir}/libGLESv2.* ${includedir}/GLES2 ${libdir}/pkgconfig/glesv2.pc"

FILES_${PN}-dbg += "${libdir}/egl/.debug/* ${libdir}/gallium-pipe/.debug"


