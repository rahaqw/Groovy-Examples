#!/usr/bin/env groovy
// Purpose of this script is to show how to exclude / include stuff
// from lists

// def person for later use
class Person {
    String name
    String address
}

lst = [ 1 .. 4, 2 ]
// Result is 2.  find gets you the first occurrence
println lst.find { it == 2 }

def plist = []


def person = new Person(name:'Bert', address:'101')
assert person.name == 'Bert'
plist << person

def person2 = new Person(name:'Ernie', address:'101')
plist << person2

def person3 = new Person(name:'Cookie Monster', address:'Kitchen')
plist << person3 

// Just a sanity check to print each address
println "Here's all the people's addresses:"
plist.each { println it.address }
println "Here's the first person's address that matches 101"
println plist.find { it.address == '101' }.name

println "Here's all the people's addresses that match 101"
// nobody is a list, one-for-one that matches or doesn't match the 
// address we're looking for.  In other words, it returns a list of
// objects for each person in plist.  The first two objects are Person
// objects, because they match what we're looking for.  The third object
// is [], because cookie monster doesn't match what we're looking for.
def nobody = plist*.findAll { it.address == '101' }
println nobody?.name

println "Again, here's all the people's addresses that match 101,\n just a different way."
println plist.findAll { it.address == '101' }.name


println "Done."
