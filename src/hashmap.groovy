#!/usr/bin/env groovy

// Show how to join two hashes
def record1 = [
    firstName : 'barn',
    lastName : 'smith',
    zipcode : '22222'
]

def record2 = [
    phone : '976-EVIL',
    zipcode : '11111']

record1 += record2

// Assert that record2's fields were added to record1
// Also assert that zipcode (default) was replaced by record2's zipcode
assert record1.phone == '976-EVIL'
assert record1.zipcode == '11111'
assert record1.firstName == 'barn'

myMap = [freature:'Clusres', version:'1.1']

// Print firstName and zipcode from this record.
def outputFields = [ 'firstName', 'zipcode' ]

println outputFields.collect {
    record1[it]
}.join("\n")


myList = []

// condense
one = [name:'Fred']
myList << one
two = [name:'Wilma']
myList << two

myList.each { thing ->
    println thing.name
	println thing['name']
}


def epList = []

def email = [
    from:'Barney',
    subject:'Drink',
    date:'Boink'
]

// When two args are defined, they're key/value
email.each { key, value ->
    assert ["from", "subject", "date"].find { it == key }
    assert ["Barney", "Drink", 'Boink'].find { it == value }
}


def myparams = [
    assertYourMom : true,
    somethingElse : false
    ]

assert false == myparams.remove('somethingElse')
assert true == myparams.remove('assertYourMom')
assert myparams['assertYourMom'] == null


// Example of hash delete method
def someMap = [ foo:'bar', baz:'quk' ]
def something = someMap.remove('baz')
assert something == 'quk'


def anotherList = someMap.findAll {
    it.key == 'foo'
}

assert anotherList.size() == 1
