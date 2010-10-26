#!/usr/bin/env groovy
// how to unshift onto a list
def lst = [ 'foo', 'bar', 'baz' ]
lst = [ 'quk' ] + lst
assert lst[0] == 'quk'

// use 'add' method to add items at a certain
// point in the array
lst.add(0, 'byzantine')
assert lst[0] == 'byzantine'
assert lst[1] == 'quk'

lst.add('last item')
assert lst[-1] == 'last item'
assert lst[-2] == 'baz'


def l = [ 1, 2, 3]
assert l.pop() == 3
assert l.pop() == 2, 'second pop should be 2'
assert l.pop() == 1, 'Only 1 should be left'


def s = "doodie/bird/blather"
l = s.split("/").toList()

assert l.pop() == 'blather'
assert l.pop() == 'bird'
assert l.pop() == 'doodie'


def searchTerms = []
searchTerms.add([fieldName:'foo', fieldValue:'bar'])
assert searchTerms.size() == 1

def something = searchTerms.find { it.fieldName == 'foo' }
println something.getClass().getName()
println something

searchTerms = []
