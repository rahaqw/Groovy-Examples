#!/usr/bin/env groovy
//we can add to and subtract from a date...
def today = new Date();

def dates = [ 
    today + 1,
    today + 7,
    today - 1,
    today - 7,
    today - 14,
    today - 21
]

// normal sort
def sortedDates = dates.sort {
    it
}

sortedDates.each {
    println it
}


// sort closest to today
sortedDates = dates.sort {
    (today - it).abs()
}

println "Closest to today"
sortedDates.each {
    println it
}


// sort closest PAST date, unless date is 
// exactly today.
println "Closest PAST date, unless today"
// NOTE:  clearTime is only present on Calendar instance as of groovy 1.6.7
// def noTime = today.clone()
// today.clearTime()
// noTime.clearTime()
sortedDates = dates.sort { foo, bar ->

        def fooScore = today - foo
        if (fooScore < 0) fooScore *= -100000
        def barScore = today - bar
        if (barScore < 0) barScore *= -100000

        return fooScore <=> barScore
}

sortedDates.each {
    println it
}
