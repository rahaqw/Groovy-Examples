#!/usr/bin/env groovy
// From 
// http://pleac.sourceforge.net/pleac_groovy/hashes.html
//----------------------------------------------------------------------------------
// java.util.LinkedHashMap "maintains a doubly-linked list running through all of its entries.
// This linked list defines the iteration ordering, which is normally the order in which keys
// were inserted into the map (insertion-order)".
foodColor = new LinkedHashMap()
foodColor['Banana'] = 'Yellow'
foodColor['Apple'] = 'Green'
foodColor['Lemon'] = 'Yellow'
foodColor['0001'] = 'Yellow'
foodColor['Pineapple'] = 'Dark Yellow'

def keys = foodColor.keySet().toArray()

assert "Banana" == keys[0]
assert "Apple" == keys[1]
assert "Lemon" == keys[2]
assert "0001" == keys[3]
assert "Pineapple" == keys[4]
