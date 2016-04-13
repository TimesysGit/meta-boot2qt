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

# WARNING: FILESEXTRAPATHS-variable, must always use _prepend (or _append)
FILESEXTRAPATHS_tegra-x1_prepend = "__default:"
FILESEXTRAPATHS_tegra-t18x_prepend = "__default:"

# ERROR: QA Issue: Files/directories were installed but not shipped in any package
FILES_${PN}-gk20a = "${FILES__${PN}-gk20a}"
