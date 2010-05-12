#!/usr/bin/env groovy
// This script doesn't work.
// I'm attempting to override the Calendar.instance to return a 
// calendar that's always at a certiain date
// see also ./mockCurrentTime.groovy

def foofoo = new GregorianCalendar()
println foofoo.timeInMillis

// This is just an example of overriding a static method
java.lang.System.metaClass.static.currentTimeMillis = { 
    return foofoo.timeInMillis
}

def cal = Calendar.instance


println cal.getTimeInMillis()
sleep(50)
println cal.getTimeInMillis()
sleep(50)
println cal.getTimeInMillis()
sleep(50)
