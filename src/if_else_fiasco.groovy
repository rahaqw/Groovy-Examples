#!/usr/bin/env groovy 
something = 0
something_else = 0
if (true) {
    if (true) {
	println "hello world"
	    println "I should be here"
	    something++
    } else {
	if (false || false) {
	    println "I shouldn't be here"
		something_else++
	}
	else {
	    println "I shouldn't be here either"

		something_else++
	}
    }
}
