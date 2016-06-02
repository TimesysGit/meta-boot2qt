############################################################################
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

DESCRIPTION = "Qt IVI"
LICENSE = "(GFDL-1.3 & BSD & The-Qt-Company-GPL-Exception-1.0 & (LGPL-3.0 | GPL-2.0+)) | The-Qt-Company-DCLA-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
                    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
                    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \
                    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02"

inherit qt5-module sdk-sources

SRC_URI = " \
    git://codereview.qt-project.org/qt/qtivi;branch=${BRANCH};protocol=ssh \
    "

SRCREV = "b850b82e70e9585097ceb2812002bb4a7ddba06f"
BRANCH = "5.7"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtdeclarative"
