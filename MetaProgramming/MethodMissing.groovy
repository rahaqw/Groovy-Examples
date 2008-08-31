#!/usr/bin/env groovy 
// Declare some crappy class.
class MethodMissing {
    def existingMethod() {
	println "This method exists"
	}
}

// Muck with the class, and add a method if something calls
// an undefined method
// MethodMissing.metaClass.methodMissing = { String name, args ->
//     MethodMissing.metaClass."$name" = { Object[] varArgs ->
// 	name
//     }
//     name
// } // end closure


// Create a new instance of this class
def foo = new MethodMissing()
assert "hello" == foo.hello()
assert "goodbye" == foo.goodbye()
