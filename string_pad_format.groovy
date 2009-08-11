#!/usr/bin/env groovy

/* 
 *  Script: string_pad_format.groovy
 * Purpose: Demonstrate padding / formatting of strings in Groovy
 *   Usage: groovy string_pad_format.groovy
 *  Author: Nate
 */

def string = "1"
println string.padLeft(5, "0")


(90000 .. 99999).each {
    println it.toString().padLeft(5, "0")
}

