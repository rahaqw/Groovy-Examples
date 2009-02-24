#!/usr/bin/env groovy

/* 
 *  Script: date_diff_simple.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy date_diff_simple.groovy <+usage+> 
 *
 *  Author: <+author+>
 */

def startDate = new Date()
println "Sleeping for 3 seconds"
sleep(3000)
def endDate = new Date()

difference = endDate.getTime() - startDate.getTime() 
print "Difference between start and end is: " + (difference / 1000).toLong()
