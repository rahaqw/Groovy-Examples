#!/usr/bin/env groovy

/* 
 *  Script: list_copying.groovy
 *   Usage: list_copying.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */


def list1 = ['foo', 'bar', 'baz']
def list2 = list1

// Removing / changing things in list2 also does it to list1
assert list2.remove(0) == 'foo'
assert list1[0] == 'bar'

// Use clone method to create two distinct lists
list1 = ['foo', 'bar', 'baz']
list2 = list1.clone()
list3 = list1.clone()

// Clone / copy list -- compare lists using == or .equals
// == will delegate to the .equals method -- DGG chapter "The Groovy Language"
assert list2.equals(list3)
assert list2 == list3
assert !(list2 == list3.reverse())
assert !(list2.is(list3))
def list4 = list2
assert (list2.is(list4))

assert list2.remove(0) == 'foo'
assert list1[0] == 'foo'
