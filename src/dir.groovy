#!/usr/bin/env groovy
new File(".").eachFile {
    println it.getParentFile().getAbsolutePath()
    println it.parent
}
