#!/usr/bin/env groovy
for (a in this.args) {
    println("Argument: " + a)
}

def foo = 'Foo'
def bar = 'Bar'

// Go through each argument, and print index, and value.
this.args.eachWithIndex { obj, index ->
    println "Arg: ${index} is ${obj}"
    switch ( index ) {
        case 0:
            foo = obj
            break
        case 1:
            bar = obj
            break
    }
}

println "Foo is ${foo} Bar is: ${bar}"

if (this.args) {
    println "First arg is: ${this.args[0]}"
}
else {
    println "First arg is nada"
}
