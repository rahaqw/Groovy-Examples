#!/usr/bin/env groovy
def f
new File("/home/nate/src/groovy").eachFileRecurse {
    if (it.name == "find_file.groovy") {
        f = it
        return
    }
}

println "file is: " + f

