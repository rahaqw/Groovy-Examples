#!/usr/bin/env groovy

def myList = []
myList << "foo"
myList << "bar"
myList.add('baz')

assert myList[2] == 'baz'

println myList.join(" : ")

println myList.collect { it != "foo" }

// ====== Filtering ======

class Student {
    String name
        Float average
}

def students = []
students <<  new Student(name:"Bob", average:3.0)
students <<  new Student(name:"Doug", average:2.0)
students <<  new Student(name:"Derirer", average:4.0)

// Filters list for students w/average >= 4
def aStudents = students.findAll { it.average >= 4.0 }
println "A students are: " + aStudents.collect { it.name }

// Gets names of all students w/average >= 3
println "B or better students are: " + students.findAll { it.average >= 3.0 }.collect { it.name }

// Add / Remove

students = []
students = ["Bob", "Doug", "Derirer"]
def d_students = students - [ "Bob" ]
students = ["Weezie", "Bob", "Doug", "Derirer"]
def first_student = students.remove(0)
assert first_student == "Weezie"
assert students[0] == "Bob"

println "Students w/o bob is: " + d_students


def another_list = [ 'foo' ]
another_list = [ 'bar', 'baz' ] + another_list
assert another_list == [ 'bar', 'baz', 'foo' ]
