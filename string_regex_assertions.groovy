// The matcher.matches() only is true unless the ENTIRE string
// matches the regex.  LAME!

// NOTE: getCount, etc. DO NOT have to match the entire 
// string.  Confusing!!!!!!
matcher = "ABC" =~ /AB/
// This is confusing.  matches() returns false, but
// getCount returns 1
assert matcher.matches() == false
assert matcher.getCount() == 1

// http://notesmine.com/groovy_regex
// http://naleid.com/blog/2008/05/19/dont-fear-the-regexp/
def shoutedWord = ~/\b[A-Z]+\b/
matcher = ("EUREKA" =~ shoutedWord)  
assert matcher.matches()         // TRUE

// Use getCount to avoid having to trap for exceptions
// when accessing matcher[0]
m = "foobar" =~ /(foo)/
assert m.getCount() == 1

// Use getCount for sanity.
m = "foobar" =~ /foo.*/
assert m.getCount() == 1

// How to get your stuff back out of regex,
// at least in a simple match/fetch scenario.
m = "foobar" =~ /(\w+)/
assert m.getCount() == 1
assert m[0][0] == "foobar"

// Match some numbers.
m = "2.8GB" =~ /^([0-9.]+)/
assert m.getCount() == 1
assert m[0][0] == "2.8"
