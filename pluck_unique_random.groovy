#!/usr/bin/env groovy
// tags: random list range unique
def seed = new Random()
def data = [ "a", "b", "c", "d", "e", "f" ]

def randomNums = (0 .. data.size() - 1).toList()

3.times {

    def removeThis = seed.nextInt(randomNums.size())

    assert java.util.ArrayList == randomNums.class

    println randomNums.remove(removeThis)
    
}