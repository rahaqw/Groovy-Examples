#!/usr/bin/env groovy
import static groovy.util.GroovyTestCase.*

def i = "5"
assertEquals 5, i.toInteger()


def bob
try {
    bob = "bob".toInteger()
}
catch (NumberFormatException e) {
}

assertNull bob

