#!/usr/bin/env groovy

def s = new String("boo")
if (s.metaClass.respondsTo(String, "reverse")) {
    println "Yes"
}
else {
    println "No"
}

if (s.metaClass.respondsTo(String, "snoogins")) {
    println "Yes snoogins"
}
else {
    println "No snoogins"
}

println s.class
