FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "\
    file://snd_intel8x0.cfg \
    "

COMPATIBLE_MACHINE += "|emulator"
