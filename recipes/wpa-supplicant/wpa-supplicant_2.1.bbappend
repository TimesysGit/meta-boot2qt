do_install_append () {
	install -d ${D}${includedir}/wpa-supplicant

	install -m 0644 ${S}/src/common/wpa_ctrl.c ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/common/wpa_ctrl.h ${D}${includedir}/wpa-supplicant/

	install -m 0644 ${S}/src/utils/build_config.h ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/utils/common.h ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/utils/includes.h ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/utils/os.h ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/utils/os_unix.c ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/utils/trace.h ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/utils/wpa_debug.h ${D}${includedir}/wpa-supplicant/
	install -m 0644 ${S}/src/utils/wpabuf.h ${D}${includedir}/wpa-supplicant/
}

FILES_${PN}-dev += "${includedir}/wpa-supplicant/*"

