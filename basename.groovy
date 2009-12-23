#!/usr/bin/env groovy

import javax.activation.MimetypesFileTypeMap;
File f = new File("foo/bar/baz.gif")
println f.getName()
println new MimetypesFileTypeMap().getContentType(f)
f = new File("http://yahoo.com/someimage.gif")
println f.getName()
println new MimetypesFileTypeMap().getContentType(f)
