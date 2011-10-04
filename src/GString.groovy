#!/usr/bin/env groovy 
class GroovyMain {
    static void main(String[] args) {
	def num = 42
	def message = "num is ${num}"
	println message
	println message.class
	num = 2112
	// This could be argued to print num is 2112,
	// because GString will evaluate ${num}
	println message


	// When you use a list, it's pointing to the reference to the List
	num = ["nate", "boffo"]
	message = "list is ${num}"
	println message
	num << "Brian"
	// I expect this to have Brian added, unlike above, where 42 did not change
	println message
    }
}
