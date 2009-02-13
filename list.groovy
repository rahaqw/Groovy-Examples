#!/usr/bin/env groovy

/* 
 *  Script: list.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy list.groovy <+usage+> 
 *
 *  Author: <+author+>
 */
def myList = []
myList << "foo"
myList << "bar"

println myList.join(" : ")
