#!/usr/bin/env groovy
class Dangle {
    def foo() {
	println "foo"
    }

    def bar() {
	println "bar"
    }
}
def method = "foo"
def dangle = new Dangle()
dangle."${method}"
