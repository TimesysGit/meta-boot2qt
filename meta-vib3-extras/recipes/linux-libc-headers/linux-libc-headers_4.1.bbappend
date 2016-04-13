
# Use our kernel instead of yocto which defaults to mainline 3.10.
# Commit id of our kernel's include/uapi directory in kernel tree -
# 8c37e1bfe7dd26a9d4cf4510460a75264c906444
SRC_URI = "file://${KERN_DIR}/linux.tar.bz2"

# Extracting linux.tar.bz2 creates directories
# <top>/vibrante-oss-src/kernel
S = "${WORKDIR}/vibrante-oss-src/kernel"
