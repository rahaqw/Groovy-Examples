#!/usr/bin/env groovy

def myList = []
myList << "foo"
myList << "bar"

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

  println "Students w/o bob is: " + d_students

