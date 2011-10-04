#!/usr/bin/env groovy
// http://java.sun.com/j2se/1.5.0/docs/api/java/util/Formatter.html
//
def cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
cal.set(1981, 5, 16, 0, 43)  // 16 Jun 1981
date1 = cal.time
assert date1.year == 81
assert date1.month == 5 // yeah, 5 is June in idiotic Java
println date1

println String.format("%tc",date1)
println String.format("%tk",date1)
println String.format("%tl",date1)
println String.format("%tH",date1)
println String.format("%tI",date1)
// assert String.format("%tl",date1) == '2'
// difference betweeen %l and %I
assert String.format('%tl', date1) == '7'
assert String.format('%tI', date1) == '07'
assert date1.format('yyyy_MM_dd') == '1981_06_15'
