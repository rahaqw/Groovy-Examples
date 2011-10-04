#!/usr/bin/env groovy
def today = new Date()
def deadline = Date.parse('MM/dd/yyyy', '11/01/2011')
println "Days left: " + (deadline - today)
