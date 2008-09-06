#!/usr/bin/env groovy
# Purpose of this script is to show how to exclude / include stuff
# from lists
class Person {
    String name
    String address
}
def person = Person.new(name:'Bert', address:'101')
def person2 = Person.new(name:'Ernie', address:'101')

def plist = []
plist << person
plist << person2

plist.


