#!/usr/bin/env groovy

/* 
 *  Script: find.groovy
 *   Usage: find.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */

def list = ['Bob', 'Dick', 'Jane' ]
assert list.find {
    it == 'Bob'
}

assert list.find {
    it == 'Dick'
}

assert ! list.find {
    it == 'Fandango'
}


// And

list = [
    [ name : 'Nate',
      employed : false,
      title : 'Best programmer in the world'
    ],
    [ name : 'Bob',
      title : 'Manager', 
      employed : true
    ]
]
assert list.find {
    it.title =~ /Best/ &&
    it.name =~ /Nate/
}

// only the last expression is checked
assert list.find {
    it.title =~ /BillyGoatNonExistantTitle/
    it.name =~ /Nate/
}

assert ! list.find {
    it.title =~ /Best/ &&
    it.employed == true
}

// search for some arbitrary regex using a variable
// should find 'Nate'
def title = 'Best'
assert list.find {
    it.title =~ /${title}/ &&
    it.employed == false
}
