#!/usr/bin/env groovy

/* 
 *  Script: parser.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy parser.groovy <+usage+> 
 *
 *  Author: <+author+>
 */
def mystring = "param=value:param2=I hate you!"

def myparams = mystring.split(/:/)

def myhash = [:]
myparams.each {
  def mylist = it.split(/=/)
  myhash[mylist[0]] = mylist[1]

}
println "hash is: " + myhash
