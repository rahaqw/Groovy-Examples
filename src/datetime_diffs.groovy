#!/usr/bin/env groovy
// Difference of Two Dates
import java.text.NumberFormat
import java.text.DecimalFormat
//----------------------------------------------------------------------------------
// => There were 265333775 seconds between Nat and Bree
// => (438 weeks, 4 days, 23:49:35)
//----------------------------------------------------------------------------------
// See if we can get the difference of 13.5 hours (aka 13h, 30 minutes)
// Difference is in milliseconds
target_hours = 13
target_seconds = 56
target_minutes = 9

time_diff = (target_hours * 60 * 60 * 1000 +
             target_minutes * 60 * 1000 + 
             target_seconds * 1000).toLong()
early_time = new Date()
// Create a later date that's 13.5 hours different than early_time
late_time = new Date(early_time.getTime() + time_diff)
difference = late_time.getTime() - early_time.getTime()
difference = difference.toLong()
assert difference == time_diff

// Reduce the difference to seconds, to make things easier
// println "Difference is: ${difference}"
difference = difference / 1000
// println "Difference is: ${difference}"
seconds = difference.toLong() % 60
// Assert that the difference between the two dates is
// 13 hours, 30 minutes 0 seconds.
assert seconds == target_seconds
// Remove seconds from the equation
difference = (difference - seconds) / 60
minutes    =  difference.toLong() % 60
assert minutes == target_minutes
difference = (difference - minutes) / 60
hours      =  difference.toLong() % 24
assert hours == target_hours
// difference = (difference - hours)   / 24
// days       =  difference % 7
// weeks      = (difference - days)    /  7
// println "($weeks weeks, $days days, $hours:$minutes:$seconds)"

NumberFormat nf = NumberFormat.getInstance();
// say we need 3 digits
nf.setMinimumIntegerDigits(3);
System.out.println("Number 1:"+ nf.format(1)); 

df = new DecimalFormat("00")
println df.format(minutes)
