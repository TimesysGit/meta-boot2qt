#!/bin/bash
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

while test -n "$1"; do
  case "$1" in
    "--upload")
      UPLOAD=1
      ;;
  esac
  shift
done

echo "-------------------------------------" >> build.log
for DIR in $(ls -d build-*); do
    (
    export MACHINE=${DIR#*-}
    . ./setup-environment.sh

    echo "${MACHINE}:" >> ../build.log
    echo "  start: $(date)" >> ../build.log
    bitbake b2qt-embedded-image meta-toolchain-b2qt-embedded-sdk
    if [ $? = 0 ]; then
        if [ -n "${UPLOAD}" ]; then
            ../sources/meta-b2qt/scripts/upload.sh
        fi
    else
        echo "    build failed" >> ../build.log
    fi
    echo "  end:   $(date)" >> ../build.log
    )
done
