# Upstream recipe mistakenly depends on systemd, we remove that dependency here.
RDEPENDS_${PN}_remove = "systemd"
REQUIRED_DISTRO_FEATURES_remove = "systemd"
# https://bugzilla.yoctoproject.org/show_bug.cgi?id=8522
RDEPENDS_${PN} +=  "util-linux"
