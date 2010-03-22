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

def doodie = Date.parse("yyy-MM-dd HH:mm", "2008-05-06 13:29")
// Year is real year - 1900
assert doodie.year == 108
assert doodie.getAt(Calendar.HOUR_OF_DAY) == 13
assert doodie.getAt(Calendar.HOUR) == 1
assert doodie.getAt(Calendar.MINUTE) == 29


// http://java.sun.com/j2se/1.5.0/docs/api/java/text/SimpleDateFormat.html
def pmFormat = 'MM/dd/yyyy h:mm a'
doodie = Date.parse(pmFormat, '11/12/2009 4:20 pm')
assert doodie.getAt(Calendar.HOUR_OF_DAY) == 16
assert doodie.getAt(Calendar.HOUR) == 4
assert doodie.getAt(Calendar.MINUTE) == 20


doodie = Date.parse(pmFormat, '11/12/2009 4:20 am')
assert doodie.getAt(Calendar.HOUR_OF_DAY) == 4
assert doodie.getAt(Calendar.HOUR) == 4
assert doodie.getAt(Calendar.MINUTE) == 20

// Another pm one, with two-digit hour
doodie = Date.parse(pmFormat, '11/12/2009 10:20 PM')
assert doodie.year == 109
assert doodie.getAt(Calendar.HOUR_OF_DAY) == 22
assert doodie.getAt(Calendar.HOUR) == 10
assert doodie.getAt(Calendar.MINUTE) == 20


doodie = Date.parse( 'MM-dd-yyyy h:mm', '3-5-2010 21:20')
assert doodie.year == 110
assert doodie.getAt(Calendar.HOUR_OF_DAY) == 21
assert doodie.getAt(Calendar.HOUR) == 9
assert doodie.getAt(Calendar.MINUTE) == 20

