#!/usr/bin/env groovy

/* 
 *  Script: hex_codes.groovy
 *   Usage: hex_codes.groovy
 * Purpose: Show hex codes for integers
 *  Author: nathan.neff@gmail.com
 * History: 
 */

1.upto(1024) {
    println "${it} in hex is: " + Integer.toHexString(it)
}
