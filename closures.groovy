#!/usr/bin/env groovy
class GroovyMain {
    static void main(String[] a) {
	def counter = 0

	// This code has access to the counter above.
	// If there was a variable 'counter' in the num.times method below,
	// it would **not** be able to see that counter variable in 
	// the times method
	def myclosure = {
	    println 'in the closure'
	    counter++
	}

	def myClosure2 = { arg ->
	    println "The arg is: " + arg
	}

	def num = 4
	num.times(myclosure)
	println counter

    }
}

