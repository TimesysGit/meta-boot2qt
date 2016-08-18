#!/bin/bash
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

if [ $# -ne 1 ]; then
    echo "Usage: $0 <qt5.git>"
    echo "Update SRCREVs for all Qt modules in the current folder."
    echo "The <qt5.git> is path to the qt5 super repo, where modules' SHA1 is taken."
    exit 1
fi

SHA1S=$(git -C $1 submodule status --recursive |  cut -c2- | awk '{print $1$2}')

for S in $SHA1S; do
    SHA1=${S:0:40}
    PROJECT=${S:40}

    if [ "${PROJECT}" = "qtwebengine" ]; then
        sed -i -e "/^SRCREV_qtwebengine/s/\".*\"/\"${SHA1}\"/" qtwebengine_git.bb*
        echo "${PROJECT} -> ${SHA1}"
    elif [ "${PROJECT}" = "qtwebengine/src/3rdparty" ]; then
        sed -i -e "/^SRCREV_chromium/s/\".*\"/\"${SHA1}\"/" qtwebengine_git.bb*
        echo "qtwebengine (chromium) -> ${SHA1}"
    elif [ "${PROJECT}" = "tqtc-qmlcompiler" ]; then
        sed -i -e "/^SRCREV_chromium/s/\".*\"/\"${SHA1}\"/" qtquickcompiler_git.bb*
        echo "qtquickcompiler -> ${SHA1}"
    elif [ "$(echo *${PROJECT}*_git.bb*)" != "*${PROJECT}*_git.bb*" ]; then
        sed -i -e "/^SRCREV/s/\".*\"/\"${SHA1}\"/" *${PROJECT}*_git.bb*
        echo "${PROJECT} -> ${SHA1}"
    else
        echo "${PROJECT} -> no recipe found"
    fi
done

