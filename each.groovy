#!/usr/bin/env groovy
// 4
(1 .. 100).each {
    def val = it
    println "I'm running ${val}<br />"
}

def numTimes = 1

if (this.args) {
    numTimes = this.args[0].toInteger()
}

println "Num times is ${numTimes}"
(1 .. numTimes).each {
    println "Whee ${it}"
}