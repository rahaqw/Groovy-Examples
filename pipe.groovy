#!/usr/bin/env/groovy
// Pipes output from one process to the other.
def command = "echo TOWELIE!!!" // Create the String
def proc = command.execute().pipeTo('tr [A-Z] [a-z]'.execute())
proc.waitFor()
// Print output.  Should be lower-case "towelie!!"
println "stdout: ${proc.in.text}"

