#!/usr/bin/env groovy
// tags: inject hash keys key each iterator loop create list

def listOfThings = [
    [ name : 'Bob', age: 1 ],
    [ name : 'Doug' , age: 2],
    [ name : 'Joe' , age: 3],
    [ name : 'Dookie' , age: 4]
]

def existingHash = [
    'Snarf' : [ name : 'Snarf', age: 300], 
    'Bloganje' : [ name : 'Bloganje Sr.', age : 12 ]
]

def newHash = listOfThings.inject(existingHash) { hash, thing ->
    hash << [ (thing.name) : thing ]
}

assert newHash.size() == 6
assert newHash['Bob'].age == 1
assert newHash['Bob'].name == 'Bob'

// ensure that our existing stuff is still there
assert newHash['Snarf'].name == 'Snarf'
assert newHash['Snarf'].age == 300
assert newHash['Bloganje'].name == 'Bloganje Sr.'
assert newHash['Bloganje'].age == 12


