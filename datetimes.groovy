#!/usr/bin/env groovy

//----------------------------------------------------------------------------------
// use Date to get the current time
println new Date()
// => Mon Jan 01 07:12:32 EST 2007
// use Calendar to compute year, month, day, hour, minute, and second values
cal = Calendar.instance
println 'Today is day ' + cal.get(Calendar.DAY_OF_YEAR) + ' of the current year.'
// => Today is day 1 of the current year.
// there are other Java Date/Time packages with extended capabilities, e.g.:
//     http://joda-time.sourceforge.net/
// there is a special Grails (grails.codehaus.org) time DSL (see below)
//----------------------------------------------------------------------------------

// Finding Today's Date

//----------------------------------------------------------------------------------
cal = Calendar.instance
Y = cal.get(Calendar.YEAR)
M = cal.get(Calendar.MONTH) + 1
D = cal.get(Calendar.DATE)
println "The current date is $Y $M $D"
// => The current date is 2006 04 28
//----------------------------------------------------------------------------------

// Converting DMYHMS to Epoch Seconds

//----------------------------------------------------------------------------------
// create a calendar with current time and time zone
cal = Calendar.instance
// set time zone using long or short timezone values
cal.timeZone = TimeZone.getTimeZone("America/Los_Angeles")
cal.timeZone = TimeZone.getTimeZone("UTC")
// set date fields one at a time
cal.set(Calendar.MONTH, Calendar.DECEMBER)
// or several together
//calendar.set(year, month - 1, day, hour, minute, second)
// get time in seconds since EPOCH
long time = cal.time.time / 1000
println time
// => 1196522682
//----------------------------------------------------------------------------------

// Converting Epoch Seconds to DMYHMS

//----------------------------------------------------------------------------------
// create a calendar with current time and time zone
cal = Calendar.instance
// set time
cal.time = new Date(time * 1000)
// get date fields
println('Dateline: '
    + cal.get(Calendar.HOUR_OF_DAY) + ':'
    + cal.get(Calendar.MINUTE) + ':'
    + cal.get(Calendar.SECOND) + '-'
    + cal.get(Calendar.YEAR) + '/'
    + (cal.get(Calendar.MONTH) + 1) + '/'
    + cal.get(Calendar.DATE))
// => Dateline: 7:33:16-2007/1/1
//----------------------------------------------------------------------------------

// Adding to or Subtracting from a Date

//----------------------------------------------------------------------------------
import java.text.SimpleDateFormat
long difference = 100
long after = time + difference
long before = time - difference

// any field of a calendar is incrementable via add() and roll() methods
cal = Calendar.instance
df = new SimpleDateFormat()
printCal = {cal -> df.format(cal.time)}
cal.set(2000, 0, 1, 00, 01, 0)
println('printCal(cal) is: ' + printCal(cal))
// assert printCal(cal) == '1/01/00 12:01 AM'
// roll minute back by 2 but don't adjust other fields
cal.roll(Calendar.MINUTE, -2)
// assert printCal(cal) == '1/01/00 00:59'
// adjust hour back 1 and adjust other fields if needed
cal.add(Calendar.HOUR, -1)
// assert printCal(cal) == '31/12/99 23:59'

// larger example
cal.timeZone = TimeZone.getTimeZone("UTC")
cal.set(1973, 0, 18, 3, 45, 50)
cal.add(Calendar.DATE, 55)
cal.add(Calendar.HOUR_OF_DAY, 2)
cal.add(Calendar.MINUTE, 17)
cal.add(Calendar.SECOND, 5)
// assert printCal(cal) == '14/03/73 16:02'

// alternatively, work with epoch times
long birthTime = 96176750359       // 18/Jan/1973, 3:45:50 am
long interval = 5 +                // 5 second
                17 * 60 +          // 17 minute
                2  * 60 * 60 +     // 2 hour
                55 * 60 * 60 * 24  // and 55 day
then = new Date(birthTime + interval * 1000)
//assert df.format(then) == '14/03/73 16:02'

// Alternatively, the Google Data module has a category with DSL-like time support:
// http://docs.codehaus.org/display/GROOVY/Google+Data+Support
// which supports the following syntax
// def interval = 5.seconds + 17.minutes + 2.hours + 55.days
//----------------------------------------------------------------------------------

// Difference of Two Dates

//----------------------------------------------------------------------------------
bree = 361535725  // 16 Jun 1981, 4:35:25
nat  =  96201950  // 18 Jan 1973, 3:45:50
difference = bree - nat
println "There were $difference seconds between Nat and Bree"
// => There were 265333775 seconds between Nat and Bree
seconds    =  difference % 60
difference = (difference - seconds) / 60
minutes    =  difference % 60
difference = (difference - minutes) / 60
hours      =  difference % 24
difference = (difference - hours)   / 24
days       =  difference % 7
weeks      = (difference - days)    /  7
println "($weeks weeks, $days days, $hours:$minutes:$seconds)"
// => (438 weeks, 4 days, 23:49:35)
//----------------------------------------------------------------------------------
early_time = new Date()
// Create a later date that's 13.5 hours different than early_time
late_time = new Date(early_time.getTime() + 1000 * 60 * 60 * 13.5)
difference = late_time.getTime() - early_time.getTime()
assert difference == 1000 * 60 * 60 * 13.5

// seconds    =  difference % 60

cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
cal.set(1981, 5, 16)  // 16 Jun 1981
date1 = cal.time
cal.set(1973, 0, 18)  // 18 Jan 1973
date2 = cal.time
difference = Math.abs(date2.time - date1.time)
days = difference / (1000 * 60 * 60 * 24)
assert days == 3071
