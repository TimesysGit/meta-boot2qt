BBMASK ?= " "
BBMASK .= "|meta-fsl-arm/qt5-layer/recipes-qt/qt5"

MACHINE_EXTRA_INSTALL_SDK = " \
        ${@base_contains("DISTRO_FEATURES", "wayland", "libwayland-egl-mx6-dev", "", d)} \
        "

