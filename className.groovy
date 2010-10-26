#!/usr/bin/env groovy

def myRecord = [  firstName : 'Nate',
                   lastName : 'Neff'
                ]


assert 'Nate' == myRecord['firstName']
assert 'java.util.LinkedHashMap' == myRecord.getClass().getName()

// Added some method
def methodFoo() {
    println "Help"
}
