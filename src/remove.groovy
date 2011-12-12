#!/usr/bin/env groovy
// YOU NEED TO CALL .toList() after splitting strings
def list = [ 1, 2, 3]
list.remove(0)

assert list[0] == 2

def ls = "W T F".split().toList()
assert ls[0] == 'W'
ls.remove(0)
assert ls[0] == 'T'

def works = [ 'W', 'T', 'F']
works.remove(0)
assert works[0] == 'T'
