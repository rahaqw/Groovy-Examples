#!/usr/bin/env groovy
// Yet another regex groovy script
// Specializes in OR regexes and minimal matching

def testString = "foo"
// Obvious OR match
assert (testString =~ /(foo|bar)/)
testString = "bar"
assert (testString =~ /(foo|bar)/)


// Use variables as regexes
// You must interpolate, to tell Groovy you're not
// searching for literal 'regex'
def regex = '(foo|bar)'
assert ('foo' =~ /${regex}/)
assert ('fool' =~ /${regex}/)
assert (!('puke' =~ /${regex}/))

// This won't match, because baz is not in foo or bar
testString = "baz"
assert (!(testString =~ /(foo|bar)/))

// Same expression matches anything containing "foo" or "bar"
testString = "fooBarBaz"
assert (testString =~ /(foo|bar)/)
// Test exact matches
assert (!("fooBarBaz" =~ /^(foo|bar)$/))
assert ("foo" =~ /^(foo|bar)$/)
testString = "BigbarBeeBoo"
assert (testString =~ /(foo|bar)/)     

// Match fooBarBaz but not XXXfooBarBaz.
// Only diff from above regexes is caret ^
testString = "fooBarBaz"
assert (testString =~ /^(foo|bar)/)
testString = "XXXfooBarBaz"
assert (!(testString =~ /^(foo|bar)/))
// The ?! means "negative lookahead assertion", which means
// match any foo or bar that isn't preceeded directly with the start
// of the string http://perldoc.perl.org/perlre.html#Extended-Patterns

// The w+$ characters means that characters must follow foo or bar,
// which seems a bit redundant, since we've already limited our search to
// anything with foo or bar that's NOT at the end of the string.
// To show that the \w+$ is useless, I test it below.

assert (!("foo" =~ /^(?!foo|bar)\w+$/))         // with \w+$
assert (!("foo" =~ /^(?!foo|bar)/))
assert (!("fooBarBaz" =~ /^(?!foo|bar)\w+$/))   // with \w+$
assert (!("fooBarBaz" =~ /^(?!foo|bar)/))
assert (!("bar" =~ /^(?!foo|bar)\w+$/))         // with \w+$
assert (!("bar" =~ /^(?!foo|bar)/))
assert (!("barZZZZZ" =~ /^(?!foo|bar)\w+$/))    // with \w+$
assert (!("barZZZZZ" =~ /^(?!foo|bar)/))
// This will match
assert ("ZZZZZbarZZZZZ" =~ /^(?!foo|bar)\w+$/)
assert ("ZZZZZbarZZZZZ" =~ /^(?!foo|bar)/)
assert ("grover" =~ /^(?!foo|bar)\w+$/)
assert ("grover" =~ /^(?!foo|bar)/)
assert ("FOO" =~ /^(?!foo|bar)\w+$/)
assert ("FOO" =~ /^(?!foo|bar)/)

// A simpler way?
assert ("dooBarBaz" =~ /^(?!foo|bar)\w+$/)

// Simpler way is to just not match the start of string + (foo or bar)
assert (!("dooBarBaz" =~ /^(foo|bar)/))


// assert (!("foofooBarBaz" =~ /^(?!foo|bar)\w+$/))
// assert (testString =~ /(foo|bar)\w+$/)
// // This one does NOT match, because
// // baz is in the OR clause
// assert (testString =~ /(?!foo|bar|baz)\w+$/)
// assert (testString =~ /^(?!foo|bar|baz)\w+$/)
// 
// assert (testString =~ /(?!foo)\w+$/)
//

def expectedURL = '/someController/someAction'
def actualURL = '/someController/someAction?someParam=someValue&someOtherParm=someOtherValue'

assert (expectedURL =~ /^\/someController\//)


// Count occurrences of foo in string
def foo = "something\tcolumn1\tcolumn2\tcolumn3"
assert (foo =~ /\t/).count == 3

// Require that password contains at least three digits
def samplePass = "1abc2def3ghi"
assert (samplePass =~ /\d/).count >= 3

// Case IN sensitive
def app = "foo man rock Star wanted for lame job"
assert (app =~ /(?i)rock.*star/)
