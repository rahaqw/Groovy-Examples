#!/usr/bin/env groovy

/* 
 *  Script: collect.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy collect.groovy <+usage+> 
 *
 *  Author: <+author+>
 */

def myList = ['5', '6', '7']

println myList.collect {
    "albumId=${it}"
}.join('&nbsp;')
