#!/usr/bin/env groovy 
class MetaGroovy1 {
    String name = "Nate"


String foobar = ''

def foobaz = 1

    static void main(String[] args) {
        println "Hello"
            def mg = new MetaGroovy1()
            mg.metaClass.methods.each {
                println it
            }

        println "Properties: "
            mg.metaClass.properties.each {
                println it.name
            }
        if(mg.metaClass.hasProperty(mg, "name")) {
            println "Yes, I have a property named 'name'"
        }
    }
}
