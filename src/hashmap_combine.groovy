#!/usr/bin/env groovy

def newhash = [ firstName:'Nate', lastName:'Crazy' ]

def existingHash = [ address : '123 junk street', zip : '12335' ]

newhash.putAll(existingHash)
assert newhash.address == existingHash.address
println newhash

existingHash = [ something:'whatever' ]

def dataHash = [
'forwardParams' : [
                       param1 : 'value1',
                       param2 : 'value2'
                       ],

'someOtherDataIDontWant' : [ foo : 'bar', baz : 'quk' ]
]

assert existingHash['forwardParams'] == null

existingHash['forwardParams'] = dataHash.remove('forwardParams')

assert existingHash['forwardParams']['param1'] == 'value1'


