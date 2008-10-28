#!/usr/bin/env groovy
d = new Date() + 1
late_time = new Date(d.getTime() + 1000 * 60 * 60 * 24)

oprintln late_time

println d
// Groovy flakes out if you try to construct with a decimal
another_time = new Date(d.getTime() + (1000 * 60 * 2.5).toInteger())
