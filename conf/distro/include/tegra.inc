python set_nv_drv_version () {
    # Boiler plate code to setup bitbake objects
    d = e.data

    nv_drv_version = d.getVar('NV_DRV_VER', True)
    if nv_drv_version != "ignore":
        # FIXME: When we add support to internal builds, both debug and release
        # builds will need to be considered
        path = d.getVar('PLATFORM_TOPDIR', True)
        get_nv_drv_cmd = "strings " + path + "/lib-target/nvidia_drv.so \
| grep -o -P '(?<=Driver ).*(?=Release)' | awk {'print $1'}"
        # Execute cmd
        nv_drv_version = bb.process.run(get_nv_drv_cmd)[0].strip()
        # Store returned value in NV_DRV_VER
        d.setVar('NV_DRV_VER', nv_drv_version)
}

