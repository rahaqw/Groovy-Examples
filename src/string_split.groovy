#!/usr/bin/env groovy

/* 
 *  Script:
 * Purpose:
 *   Usage:
 *  Author:
 * History:
 */
def str = 'foo,   bar,baz    ,    quk'
// strip out spaces and split on commas
def list = str.split("\\s*,\\s*")
// println list
assert list[0] == "foo"
assert list[1] == "bar"
assert list[2] == "baz"
assert list[3] == "quk"


// Split on CamelCaseWords
// Use the (?=blah) to find the position just
// in *front* of the capital letter
// a.k.a. Zero length border matches.
list = 'birthDate'.split("(?=[A-Z])")
assert list[0] == 'birth'
assert list[1] == 'Date'

// notice that an empty string is pre-pended to the list
list = 'CamelCaseWords'.split("(?=[A-Z])")
assert list[0] == ''
assert list[1] == 'Camel'
assert list[2] == 'Case'
assert list[3] == 'Words'



def packageName = 'org.bworks.bworksdb.Enrollio'
def splitted = packageName.split("\\.")
assert splitted[-1] == 'Enrollio'


// split on lines
def multiLineString = ''' header line
data line
'''
def lines = multiLineString.split(/\n/)
println lines


// lic,nes.remove(0)
// c,assert lines[0] == 'data line'
