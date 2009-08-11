#!/usr/bin/env groovy

/* 
 *  Script: regex_dates.groovy
 *   Usage: regex_dates.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */
def initialString = 'Received: (qmail 13384 invoked by uid 89); 7 Aug 2009 18:04:08 -0000'
// Parse date
mystr = "03 Aug 2007 02:00:03"
// def m = initialString =~ /Received: \(qmail.*;\s.*\)(\d{2})/
def m = initialString =~ /Received: \(qmail.*\);\s*(.*)/
if (m) {
    println m[0][1]
}
