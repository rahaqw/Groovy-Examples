#!/usr/bin/env groovy

// Get timeInMillis, and record it.
def foofoo = new GregorianCalendar(2010, Calendar.JULY, 22, 1, 59, 21)
println "I'm time stamping this date: " + new Date(foofoo.timeInMillis)

// override constructor for Date()!!!
java.util.Date.metaClass.constructor = { -> new Date(foofoo.timeInMillis) }

1.upto(10) {
    def d = new Date()
    sleep(1000)
    println "Date is: " + d
}


// This is just an example of overriding a static method
// in java.lang.System!
// Override System.currentTimeMillis()
java.lang.System.metaClass.static.currentTimeMillis = { 
    return foofoo.timeInMillis
}

println System.currentTimeMillis()
sleep(50)
println System.currentTimeMillis()
sleep(50)
println System.currentTimeMillis()
sleep(50)
println System.currentTimeMillis()
sleep(50)
println System.currentTimeMillis()
