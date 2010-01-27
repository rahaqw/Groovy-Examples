#!/usr/bin/env groovy

/* 
 *  Script: join.groovy
 *
 * Purpose: Examples of joins
 * 
 *
 *   Usage: groovy join.groovy <+usage+> 
 *
 *  Author: <+author+>
 */
assert [1, 2, 3].join('-') == '1-2-3'


// filter out nulls
assert [1, 2, 3, null, 4, null, 5, 69].findAll {
    it != null
}.join('-') == '1-2-3-4-5-69'

def cc = 'CamelCaseWord'
def newList = cc.split("(?=[A-Z])").findAll({ it.length()}).collect {
    it[0].toUpperCase() + it[1 .. -1].toLowerCase()
}
assert newList[0] == 'Camel'
assert newList[1] == 'Case'
assert newList[2] == 'Word'

assert 'Camel Case Word' == newList.join(' ')
