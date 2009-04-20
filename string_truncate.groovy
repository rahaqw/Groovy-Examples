#!/usr/bin/env groovy
def s = "ABCDEFGHIJKL"
println s[0 .. 1]



println "Length of string is: " + s.length()
println s[0 .. s.length() - 14]

s = ""
println "Length of string is: " + s.length()
println s[0 .. s.length() - 1]
