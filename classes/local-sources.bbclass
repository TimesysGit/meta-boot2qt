#############################################################################
##
## Copyright (C) 2014 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

python do_fetch () {
    src_uri = (d.getVar('SRC_URI', True) or "").split()
    if len(src_uri) == 0:
        return

    sdk_path = d.getVar('QT_SDK_PATH', True) or ""
    if len(sdk_path) != 0:
        uris = list(src_uri);
        for url in uris:
            ud = list(bb.fetch2.decodeurl(url))
            if ("local-uri" in ud[5]):
                src_uri.remove(url)

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
            if ("local-uri" in ud[5]):
                unpack_local_uri(ud, d)
                src_uri.remove(url)

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
    srcdir = os.path.join(sdk_path, ud[5].get("local-uri"))
    cmd = "cp -vrf %s %s" % (srcdir, destdir)

    if os.path.exists(destdir):
        bb.utils.prunedir(destdir)

    ret = subprocess.call(cmd, shell=True)

    if ret != 0:
        raise bb.fetch.UnpackError("Unpack command %s failed with return value %s" % (cmd, ret), ud)
