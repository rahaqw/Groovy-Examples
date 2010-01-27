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
