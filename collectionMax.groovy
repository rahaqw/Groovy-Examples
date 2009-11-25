#!/usr/bin/env groovy
# THIS DOESN"T WORK
def list = ['foo', 'bar', 'baz', 'quk']

list.max(3).each {
    println it
}
