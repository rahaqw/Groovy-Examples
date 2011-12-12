#!/usr/bin/env groovy
def l = ["Illinois", "Missouri", "Illinois", "New York"]
assert ["Illinois", "Missouri", "New York"] == l.unique()
