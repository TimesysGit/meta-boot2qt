inherit image_types_fsl

IMAGE_ROOTFS_EXTRA_SPACE = "300000"
SDCARD_ROOTFS = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"

IMAGE_CMD_sdcard_append () {
    parted -s ${SDCARD} set 1 boot on
}
