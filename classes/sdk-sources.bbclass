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

python do_fetch () {
    src_uri = (d.getVar('SRC_URI', True) or "").split()
    if len(src_uri) == 0:
        return

    sdk_path = d.getVar('QT_SDK_PATH', True) or ""
    if len(sdk_path) != 0:
        uris = list(src_uri);
        for url in uris:
            ud = list(bb.fetch2.decodeurl(url))
            if ("sdk-uri" in ud[5]):
                src_uri.remove(url)


    if len(src_uri) == 0:
        return

    try:
        fetcher = bb.fetch2.Fetch(src_uri, d)
        fetcher.download()
    except bb.fetch2.BBFetchException as e:
        raise bb.build.FuncFailed(e)
}

python do_unpack () {
    src_uri = (d.getVar('SRC_URI', True) or "").split()
    if len(src_uri) == 0:
        return

    rootdir = d.getVar('WORKDIR', True)

    sdk_path = d.getVar('QT_SDK_PATH', True) or ""
    if len(sdk_path) != 0:
        uris = list(src_uri);
        for url in uris:
            ud = list(bb.fetch2.decodeurl(url))
            if ("sdk-uri" in ud[5]):
                unpack_local_uri(ud, d)
                src_uri.remove(url)

    if len(src_uri) == 0:
        return

    try:
        fetcher = bb.fetch2.Fetch(src_uri, d)
        fetcher.unpack(rootdir)
    except bb.fetch2.BBFetchException as e:
        raise bb.build.FuncFailed(e)
}

def unpack_local_uri(ud, d):
    import subprocess
    rootdir = d.getVar('WORKDIR', True)
    sdk_path = d.getVar('QT_SDK_PATH', True)

    destdir = os.path.join(rootdir, ud[5].get("destsuffix", "git"))
    srcdir = os.path.join(sdk_path, ud[5].get("sdk-uri"))
    cmd = "cp -vrf %s %s" % (srcdir, destdir)

    bb.note("Unpacking SDK sources %s to %s" % (srcdir, destdir))

    if os.path.exists(destdir):
        bb.utils.prunedir(destdir)

    ret = subprocess.call(cmd, shell=True)

    if ret != 0:
        raise bb.fetch.UnpackError("Unpack command %s failed with return value %s" % (cmd, ret), ud)
