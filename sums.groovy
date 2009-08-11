#!/usr/bin/env groovy

/* 
 *  Script: sums.groovy
 * Purpose: demonstrate how to sum / average stuff
 *   Usage:
 *  Author:
 * History:
 */

def data = [
    [ grade : 4,
      iq    : 10,
      lastName : 'Finkelstein',
      thesisTitle : 'My Pet Goat by Finkelstein'],
    [ grade : 4,
      iq    : 10,
      lastName : 'Smith',
      thesisTitle : 'My Pet Goat by Smith'],
    [ grade : 5,
      iq    : 20,
      lastName : 'Flintstone',
      thesisTitle : 'Theory of Relativity by Flintstone'],
    [ grade : 5,
      iq    : 30,
      lastName : 'Rubble',
      thesisTitle : 'Theory of Relativity by Rubble']
]

def sums = [:]

data.each {
    it.thesisIndex = it.thesisTitle[0..10]
    if (sums[it.thesisIndex]) {
        sums[it.thesisIndex] += it.iq
    }
    else {
        sums[it.thesisIndex] = it.iq
    }
}
println "Sums"
println sums

def averages = [:]
sums.each { key, value -> 
println "Key is: " + key
    def total = data.findAll { it.thesisIndex == key }
    println "Total size is: " + total.size()
    averages[key] = value.toInteger() / total.size()
}
println "Averages"
averages.each { key, value ->
    println "${key} : ${value.toInteger()}"
}

