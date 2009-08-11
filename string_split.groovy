#!/usr/bin/env groovy

/* 
 *  Script:
 * Purpose:
 *   Usage:
 *  Author:
 * History:
 */
def str = 'foo,   bar,baz    ,    quk'
// strip out spaces and split on commas
def list = str.split("\\s*,\\s*")
// println list
assert list[0] == "foo"
assert list[1] == "bar"
assert list[2] == "baz"
assert list[3] == "quk"
