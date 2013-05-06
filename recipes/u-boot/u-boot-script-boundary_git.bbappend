
do_mkimage_prepend () {
    if [ ! -e board/boundary/${MACHINE} ]; then
        cp -r board/boundary/nitrogen6x board/boundary/${MACHINE}
    fi
}
