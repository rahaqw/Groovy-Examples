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
sortedDates = dates.sort { date1, date2 ->

    if (date1 == date2) return 0
    if (date1 == today) return -1
    if (date2 == today) return 1

    def date1Factor = today - date1
    date1Factor = date1Factor > 0 ? date1Factor : date1Factor * -100000
    def date2Factor = today - date2
    date2Factor = date2Factor > 0 ? date2Factor : date2Factor * -100000

    def result = date1Factor <=> date2Factor
    return result
}

sortedDates.each {
    println it
}
