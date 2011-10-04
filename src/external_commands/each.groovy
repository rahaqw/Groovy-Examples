#!/usr/bin/env groovy -w

def mymap = [:]

mymap["foo"] = "bar"
mymap['bar'] = 'foo'

['this', 'is', 'my', 'each','thingy', 'bar', 'foo'].each {
    println it + " hello"
    
    println mymap[it]
}
