SUMMARY = "GammaRay Qt introspection probe"
HOMEPAGE = "http://www.kdab.com/gammaray"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL.txt;md5=5996517d53e3c2722d457fb633e970ed"

inherit cmake_qt5

SRC_URI = "git://github.com/KDAB/GammaRay;branch=${BRANCH}"

BRANCH = "master"
SRCREV = "6262eaeaee74109f9c1bd85de99c9b039d8938f5"
PV = "master+git${SRCPV}"

DEPENDS = "qtdeclarative qtlocation qtsvg qttools qtconnectivity qt3d"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DGAMMARAY_BUILD_UI=OFF -DGAMMARAY_CORE_ONLY_LAUNCHER=ON"

FILES_${PN}-dev += " \
    /usr/lib/cmake/* \
    /usr/mkspecs/modules/* \
"
FILES_${PN}-dbg += " \
    /usr/lib/.debug/* \
    /usr/lib/gammaray/*/*/.debug \
    /usr/lib/gammaray/*/*/styles/.debug \
"
