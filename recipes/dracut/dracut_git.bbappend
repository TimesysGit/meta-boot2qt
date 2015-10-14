# Upstream recipe mistakenly depends on systemd, we remove that dependency here.
RDEPENDS_${PN}_remove = "systemd"
