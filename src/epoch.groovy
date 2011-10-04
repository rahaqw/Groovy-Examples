#!/usr/bin/env groovy
now = Calendar.instance
println 'now is a ' + now.class.name
date = now.time
epoch1 = date.time

println "epoch " + date.time

assert epoch1 == now.time.time

