#!/usr/bin/env groovy

// You have to explicitly clone hashes.  If you set one == to the
// other, they just point to each other, and andy changes to one 
// wil affect the other
def origHash = [
    name:'FRED'
]

// Use clone method.
newHash = origHash.clone()
// Change name as before
newHash.name = "WILMA"
// Assertions don't work for some weird reason
// assert ! newHash['name'] == origHash['name']
println newHash.name
println origHash.name


def cloneHash = origHash
cloneHash.name = "BETTY IS SAME ON BOTH HASHES"
// orighash will now also be betty
println cloneHash.name
println origHash.name

