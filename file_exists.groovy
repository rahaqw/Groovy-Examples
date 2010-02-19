#!/usr/bin/env groovy
def f = new File('bar.txt')
assert !f.exists( )

f = new File('file_exists.groovy')
assert f.exists( )
