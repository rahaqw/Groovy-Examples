#!/usr/bin/env groovy
def list = ['foo', 'bar', 'baz', 'quk']
assert list instanceof ArrayList

// max and min return the last/first
// item in a list when the list is sorted
assert list.max() == 'quk'
assert list.min() == 'bar'

def newlist = list.sort()
assert newlist[0] == list.min()
assert newlist[-1] == list.max()

assert newlist instanceof ArrayList
