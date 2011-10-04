#!/usr/bin/env groovy
def list = "1:2:3"
def b = list.split(':')
b.class
b.pop() // <--- crash! pop() isn't a method of [Ljava.langString]
