#!/usr/bin/env groovy
def listOfThings = [
    [ name : 'Bob', age: 1 ],
    [ name : 'Doug' , age: 2],
    [ name : 'Joe' , age: 3],
    [ name : 'Dookie' , age: 4]
]


def hashOfThings = listOfThings.inject([:]) { hash, thing ->
    hash << [ (thing.name) : thing ]
}


assert hashOfThings.size() == 4
assert hashOfThings['Bob'].age == 1
assert hashOfThings['Bob'].name == 'Bob'


