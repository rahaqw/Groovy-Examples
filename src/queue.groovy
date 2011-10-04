#!/usr/bin/env groovy
def queue = [ 1,2,3 ]
queue << 4
assert queue[3] == 4
queue.push(5)
assert queue[-1] == 5

