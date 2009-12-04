#!/usr/bin/env groovy

/* 
 *  Script: find.groovy
 *   Usage: find.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */

def list = ['Bob', 'Dick', 'Jane' ]
assert list.find {
    it == 'Bob'
}

assert list.find {
    it == 'Dick'
}

assert ! list.find {
    it == 'Fandango'
}
