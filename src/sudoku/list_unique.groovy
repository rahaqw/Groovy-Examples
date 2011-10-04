#!/usr/bin/env groovy
# TODO: This ain't done!

/* 
 *  Script: list_unique.groovy
 *   Usage: list_unique.groovy
 * Purpose: Show examples of finding unique values in lists
 *  Author: Crazy Nate
 * History: 
 */

def list = [ 0, 0, 1, 2, 3, 4, 4, 3 ]
println list.collect {
    def f = findUn
    if (list.findAll {
          it.size() == 1 {
        it
    }
}
