#!/usr/bin/env groovy
// 4
(1 .. 100).each {
    def val = it
    // println "I'm running ${val}<br />"
}

def numTimes = 1


def l = ['foo', 'bar', 'baz', 'quk']
def res = []
l.eachWithIndex { item, i ->
    if (i > 1) {
        return
    }
    res << item
}

assert res.size() == 2
println res[0]

if (this.args) {
    numTimes = this.args[0].toInteger()
}

println "Num times is ${numTimes}"
(1 .. numTimes).each {
    println "Whee ${it}"
}

def ten = []
(1..10).each {ten.add(it)}
println ten

// Doesn't work
// def eleven = [ 1 .. 11 ]
// prnitln eleven
//
