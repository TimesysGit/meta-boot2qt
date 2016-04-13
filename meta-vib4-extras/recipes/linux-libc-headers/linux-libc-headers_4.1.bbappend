# Use our kernel instead of yocto which defaults to mainline 3.18
SRC_URI = "file://${KERN_DIR}/linux.tar.bz2"
PV = "3.18"

# Extracting linux.tar.bz2 creates directories
# <top>/vibrante-oss-src/kernel
S = "${WORKDIR}/vibrante-oss-src/kernel"
