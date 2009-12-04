#!/usr/bin/env groovy

/* 
 *  Script: xmlParser.groovy
 *   Usage: xmlParser.groovy
 * Purpose: show how to use XmlParser
 *  Author: Crazy Nate
 * History: 
 */
def xml = new XmlParser().parseText("<people><person>Bob</person></people>")
assert xml.person.text() == 'Bob'
