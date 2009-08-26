#!/usr/bin/env groovy
def seed = new Random()
println seed.nextInt(100)
println seed.nextInt(100000)


println "Next double: " + (seed.nextDouble() * 100000).toInteger()

(0 .. 100).each {
    println seed.nextInt(3)
}
