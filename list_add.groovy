#!/usr/bin/env groovy
def parentList = [
    [ 'barney', 'rubble' ],
    [ 'fred',   'flintstone' ]
    ]

parentList.each { cur ->
println cur.class
    cur.add('foo')
}
    
