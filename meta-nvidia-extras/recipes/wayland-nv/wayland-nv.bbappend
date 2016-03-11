EXTRA_PROVIDES = " \
virtual/wayland-native \
wayland-native \
"

PROVIDES_append = "${EXTRA_PROVIDES}"
RPROVIDES_append_${PN} = "${EXTRA_PROVIDES}"
CONFLICTS_append_${PN} = "${EXTRA_PROVIDES}"
REPLACES_append_${PN} = "${EXTRA_PROVIDES}"
