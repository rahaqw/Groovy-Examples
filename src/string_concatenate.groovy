#!/usr/bin/env groovy

/* 
 *  Script: string_concatenate.groovy
 *   Usage: string_concatenate.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */

def firstName = null
def middleName = null
def lastName = 'Van Helsing'

def fullName = lastName

// Is this really the best we can do?
fullName = lastName
if (firstName) {
    fullName += ', ' + firstName
}
if (middleName) {
    fullName += ', ' + middleName
}

println fullName

