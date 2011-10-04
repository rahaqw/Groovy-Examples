#!/usr/bin/env groovy

def i = 100
i += 100
i += 100
assert i == 300
def j = i += 100
assert i == 400
assert j == 400
def k = i += 100
assert i == 500
assert k == 500

