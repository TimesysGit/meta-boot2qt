GRAPHICS_PACKAGES = " \
virtual/libgles2 \
virtual/libegl \
virtual/egl \
libgbm \
libgbm-dev \
"

PROVIDES_append = " ${GRAPHICS_PACKAGES}"
RPROVIDES_append_${PN} = " ${GRAPHICS_PACKAGES}"
CONFLICTS_append_${PN} = " ${GRAPHICS_PACKAGES}"
REPLACES_append_${PN} = " ${GRAPHICS_PACKAGES}"
