cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
cal.set(1981, 5, 16)  // 16 Jun 1981
date1 = cal.time
cal.set(1973, 0, 18)  // 18 Jan 1973
date2 = cal.time
difference = Math.abs(date2.time - date1.time)
days = difference / (1000 * 60 * 60 * 24)
assert days == 3071


// Construct a date that's 10 years ago to the day
// This crap doesn't work -- gives some stupid integer compile error or something.
// Who cares -- use the example below -- much simpler
// def tenYearsAgo = Calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) - 10)
// println tenYearsAgo

// def tenYearsAgoDate = new Date(tenYearsAgo)
// println tenYearsAgoDate


def myFormat = 'MM/dd/yyyy'
def myDate = Date.parse(myFormat, '11/12/2009')
println "my date is: ${myDate}"
