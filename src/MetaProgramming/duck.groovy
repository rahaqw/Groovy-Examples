#!/usr/bin/env groovy
class Foo {
    def searchTags() {
        println "Searching from Foo"
    }
}

class Bar {
    def searchTags() {
        println "Searching from Bar"
    }
}

def foo = new Foo()
def bar = new Bar()

def someMethodThatCallsSearchTags(something) {
    something.searchTags()
}

someMethodThatCallsSearchTags(foo)
someMethodThatCallsSearchTags(bar)



