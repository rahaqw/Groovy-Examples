#!/usr/bin/env groovy

def map = [ nate : 1,
            jeff : 2,
            phil : 3
            ]

// remove nate (1) and add it back as 'foo'
def nate = map.remove('nate')

assert ! map['nate']
map['foo'] = nate

assert map['foo'] == 1

