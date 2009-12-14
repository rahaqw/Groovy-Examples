#!/usr/bin/env groovy

/* 
 *  Script: regex_digits.groovy
 *   Usage: regex_digits.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */

assert (! ("bar" =~ /\d/))
assert ("bar0" =~ /\d/)
assert ("b0ar" =~ /\d/)
assert ("123bar" =~ /\d/)
assert ("1" =~ /\d/)
assert (! ("bar" =~ /\d/))
