#!/usr/bin/env groovy
import static groovy.util.GroovyTestCase.*

assertEquals "Boo", "ooB".reverse()
assertFalse "Foo should not equal Boo", "Foo" == "ooB".reverse()

