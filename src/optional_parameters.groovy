#!/usr/bin/env groovy
// Default param2 to false, if not provided
doSomething("Should be false", false)
doSomething("Should be true", true)
doSomething("Should be false")

def doSomething(param1, param2 = false) {
    
    println "Param2 is ${param2}"
    
}