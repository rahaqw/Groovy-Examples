#!/usr/bin/env groovy
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
