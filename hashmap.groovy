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



// record2.each { key, value ->
//     record1[key] = value
// }

record1 += record2

// Print firstName and zipcode from this record.
def outputFields = [ 'firstName', 'zipcode' ]

println outputFields.collect {
    record1[it]
}.join("\n")

// Assert that record2's fields were added to record1
assert record1.phone == '976-EVIL'
assert record1.zipcode == '11111'
assert record1.firstName == 'barn'

myMap = [freature:'Clusres', version:'1.1']


myList = []

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
    from:'Fred',
    subject:'Eat',
    date:'Yo'
]

email = [
    from:'Barney',
    subject:'Drink',
    date:''
]

// When two args are defined, they're key/value
email.each { key, value ->
    println "${key}, ${value}"
}


def myparams = [
    assertYourMom : true,
    somethingElse : false
    ]

assert false == myparams.remove('somethingElse')
assert true == myparams.remove('assertYourMom')
assert myparams['assertYourMom'] == null
