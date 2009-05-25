#!/usr/bin/env groovy

/* 
 *  Script: string_misc.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy string_misc.groovy <+usage+> 
 *
 *  Author: <+author+>
 */
// How to get your stuff back out of regex,
// at least in a simple match/fetch scenario.
def fullName = "Bart Simpson"
m = fullName =~ /(\w+)/
assert m.getCount() == 2
assert m[0][0] == "Bart"
assert m[1][0] == "Simpson"


def str = " foo "
assert str.trim() == "foo"
