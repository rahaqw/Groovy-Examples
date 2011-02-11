#!/usr/bin/env groovy

def answer
System.in.withReader { reader ->
    answer = reader.readLine()
}
println "You said ${answer}"



