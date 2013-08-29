# dependency to x11 only when distro features have it
DEPENDS = "${@base_contains('DISTRO_FEATURES', 'x11', 'virtual/libx11', '', d)}"

PROVIDES += "virtual/libgl"
