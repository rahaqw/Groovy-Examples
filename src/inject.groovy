#!/usr/bin/env groovy
// The inject method takes a closure, and allows
// you to pass the result of each iteration to the next
// iteration.
// http://groovy.codehaus.org/Quick+Start
// see also createHashmapFromList.groovy

def tagList = [
    
    ['mytag', 0], 
    ['histag', 5],
    ['bootag', 15],
    ['bartag', 20]
    ]

def tagcloudMap = tagList.inject([ : ]) { map, tag ->
   map[ tag[0] ] = tag[1]; map
}

assert tagcloudMap['mytag'] == 0
assert tagcloudMap['histag'] == 5
assert tagcloudMap['bootag'] == 15


def listOfCrap = [ 'nate', 'jeff', 'bung']
def mapOfCrap = listOfCrap.inject([:]) { map, crap ->
   map[crap] = crap.reverse(); map
}


assert mapOfCrap['jeff'] == 'ffej'
assert mapOfCrap['nate'] == 'etan'
