#!/usr/bin/env groovy
for (a in this.args) {
  println("Argument: " + a)
}

if (this.args) {
    println "First arg is: ${this.args[0]}"
}
else {
    println "First arg is nada"
}
