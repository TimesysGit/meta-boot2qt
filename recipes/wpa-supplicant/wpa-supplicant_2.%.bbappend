##############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: http://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:COMM$
##
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see http://www.qt.io/terms-conditions. For further
## information use the contact form at http://www.qt.io/contact-us.
##
## $QT_END_LICENSE$
##
##############################################################################

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

