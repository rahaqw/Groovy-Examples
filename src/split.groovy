#!/usr/bin/env groovy
def s = "wtf"


def str = "123"

assert str[0] == "1"


def string = "your;mom,is;a,"
def list = string.split(/,|;/)
assert list.size() == 4
assert list[0] == "your"
assert list[1] == "mom"
assert list[2] == "is"
assert list[3] == "a"


