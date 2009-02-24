#!/usr/bin/env groovy

/* 
 *  Script: switch.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy switch.groovy <+usage+> 
 *
 *  Author: <+author+>
 */
def x = "foo"
def result = ""

switch ( x ) {
    case "foo":
        result = "found foo"
        // lets fall through

    case "foo":
result = "your mom"
    case [4, 5, 6, 'inList']:
        result = "list"
        break

    case 12..30:
        result = "range"
        break

    case Integer:
        result = "integer"
        break

    case Number:
        result = "number"
        break

    default:
        result = "default"
}

assert result == "number"
