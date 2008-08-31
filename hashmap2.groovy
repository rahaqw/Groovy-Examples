#!/usr/bin/env groovy
// Empty square brackets w/a colon make an empty Hash Map
// Empty square brackets w/o a colon make an empty List
def myMap = [:]
def myList = []

// If you want to use a variable for the key name, use parentheses
def someFieldName = "firstName"
def yourList = [(someFieldName):"Nate"]
assert yourList
