#!/usr/bin/env groovy
// Add Unique

def list = [ "Wisconsin", "Montana", "New York" ]
def newList = [ "Illinois" ]
newList.addAll(list)
assert [ "Illinois", "Wisconsin", "Montana", "New York" ] == newList
