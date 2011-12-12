#!/usr/bin/env groovy -w
// Will find items in array 'fields' that are missing
// from the Person object
def fields = ['firstName', 'lastName', 'missingField', 'tailLength', 'age']

def person = [firstName:'Bob', lastName:'Diddley', age:4]
// Will print missingField and taillength
fields.findAll { person[it] == null }.each { println it}

def missingFields = fields.findAll { person[it] == null }

println missingFields.join(',')

def myList = [ '', 'this', 'is', 'a', 'Test' ]

def newList = myList.findAll({ it.length()})
assert newList[0] == 'this'
assert newList[1] == 'is'
assert newList[2] == 'a'
assert newList[3] == 'Test'


def bobsgroups = [ 1, 2, 3, 4, 5]
def billsAnswers = [ 4, 5, 6 ]

assert bobsgroups.findAll { it in billsAnswers } == [ 4, 5 ]
