#!/usr/bin/env groovy
// associativity is how/when operators of the same
// precedence are evalutated
// For example, does 4 ** 3 ** 2 == ( 4 ** 9 ) or
//              does 4 ** 3 ** 2 == ( 64 ** 2)
// for groovy, associativity is left, at least for the exponential operator
assert 64 == 4 ** 3
assert 4096 == 64 ** 2
assert 4096 == 4 ** 3 ** 2
