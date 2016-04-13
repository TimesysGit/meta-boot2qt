# Append --enable-kernel flag to configure flags
# only for target build case.
# We are setting this to kernel 3.18 to keep glibc
# compatbile across all 3.18 series
# We will not support < 3.18 for V4L:
EXTRA_OECONF_append_class-target = " \
    --enable-kernel=3.18 \
"

# Search $PWD/eglibc-2.18 for additional patches
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# Placeholder for patches
SRC_URI_append_class-target = " \
"
