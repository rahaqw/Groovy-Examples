#!/usr/bin/env groovy
// This doesn't really sort a map.
// find way to get a list of the values
// in a map, sorted by value
// http://snipplr.com/view/2789/sorting-map-keys-by-comparing-its-values/
def someMap = [
    'lesson_1' : 10,
    'lesson_3' : -1,
    'lesson_2' : 2,
    'lesson_4' : 86,
    'lesson_6' : 100100,
    'lesson_59' : 100101,
    'lesson_0' : 200000

]

def keys = someMap.keySet().sort {
    someMap[it]
} 

// List the key value 
assert keys[0] == 'lesson_3'
assert keys[1] == 'lesson_2'
assert keys[2] == 'lesson_1'
assert keys[3] == 'lesson_4'
assert keys[4] == 'lesson_6'
assert keys[5] == 'lesson_59'
assert keys[6] == 'lesson_0'


// strings sort differently
someMap = [
    'lesson_1' : '10',
    'lesson_2' : '20',
    'lesson_3' : '-1',
    'lesson_4' : '200',
    'lesson_5' : '2000',
    'lesson_6' : '3'
]

keys = someMap.keySet().sort {
    someMap[it]
} 

assert keys[0] == 'lesson_3'
assert keys[1] == 'lesson_1'
assert keys[2] == 'lesson_2'
assert keys[3] == 'lesson_4'
assert keys[4] == 'lesson_5'
assert keys[5] == 'lesson_6' // This one has a value of '3', yet is the 'highest'

keys = someMap.keySet().sort {
    someMap[it].toInteger()
} 

assert keys[0] == 'lesson_3'
assert keys[1] == 'lesson_6'
assert keys[2] == 'lesson_1'
assert keys[3] == 'lesson_2'
assert keys[4] == 'lesson_4'
assert keys[5] == 'lesson_5'
