#!/usr/bin/env groovy

def newhash = [ firstName:'Nate', lastName:'Crazy' ]

def existingHash = [ address : '123 junk street', zip : '12335' ]

newhash.putAll(existingHash)
assert newhash.address == existingHash.address
println newhash




