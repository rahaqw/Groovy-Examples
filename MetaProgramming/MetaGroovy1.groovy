#!/usr/bin/env groovy 
class MetaGroovy1 {
    def name = "Nate"
    
    // metaClass 
    def myMethod1() {
	name.metaClass.methods.each {
	    println it
	}
    }

    static void main(String[] args) {
	println "Hello"
	myMethod1()
    }
}
