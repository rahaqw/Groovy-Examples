#!/usr/bin/env groovy

/* 
 *  Script: sort.groovy
 * Purpose: Demonstrates ways to sort arrays
 */

def all = [
         ['foo', 'bar', 'baz', 'quk'],   // <- 3rd
         [ 1, 2, 3, 4 ],                 // <- 1st
         [ 2, 3, 4, 5 ],                 // <- 2nd
         ['he', 'hate', 'me', 'bad']     // <- 4th
]

// Sort by the 2nd element in all the arrays
def allSorted = all.sort { a, b -> a[1].toString() <=> b[1].toString() }
println allSorted

assert allSorted[0][1] == 2
assert allSorted[1][1] == 3
assert allSorted[2][1] == 'bar'
assert allSorted[3][1] == 'hate'
