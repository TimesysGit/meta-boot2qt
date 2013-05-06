inherit image_types_fsl

IMAGE_CMD_sdcard_append () {
    parted -s ${SDCARD} set 1 boot on
}
