#!/usr/bin/env groovy
200.times {
    println greaterThan15(16)
}
def greaterThan15(val) {
    return val > 15 ? 'yes' : 'no'
}
