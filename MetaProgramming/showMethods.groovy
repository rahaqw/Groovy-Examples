#!/usr/bin/env groovy
// From http://naleid.com/blog/2008/05/07/what-methods-does-my-groovygrails-class-have/
println "foo".metaClass.methods*.name
