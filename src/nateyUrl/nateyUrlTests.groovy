#!/usr/bin/env groovy

def s = new NateyUrl()

assert s.base62Numerals[0] == "0"
assert s.base62Numerals.length() == 62
assert s.getUrl(0) == "0"
assert s.getUrl(1) == "1"
assert s.getUrl(63) == "11"
assert s.getUrl(64) == "12"
assert s.getUrl(62 * 2) == "20"
assert s.getUrl(62 * 4) == "40"
assert s.getUrl(62 * 4) == "40"

assert s.getUrl(62 + 61) == "1Z"
assert s.getUrl(62 * 62 + 61) == "10Z"
assert s.getUrl(62 * 63 + 61) == "11Z"
assert s.getUrl(62 * 64 + 61) == "12Z"
assert s.getUrl(62 * 65 + 61) == "13Z"
assert s.getUrl(62 * 66 + 61) == "14Z"
assert s.getUrl(62 * 67 + 61) == "15Z"
assert s.getUrl(62 * 68 + 61) == "16Z"
assert s.getUrl(62 * 69 + 61) == "17Z"
assert s.getUrl(62 * 70 + 61) == "18Z"
assert s.getUrl(62 * 71 + 61) == "19Z"
assert s.getUrl(62 * 72 + 61) == "1aZ"
assert s.getUrl(62 * 73 + 61) == "1bZ"
assert s.getUrl(62 * 74 + 61) == "1cZ"
assert s.getUrl(1000000) [-1]== "2"
assert s.getUrl(1000000) [-2]== "9"
assert s.getUrl(1000000) [-3]== "c"
assert s.getUrl(1000000) [-4]== "4"
assert s.getUrl(1000000) == "4c92"
// one more time.
assert s.getUrl(1234567890) [-1]== "k"
assert s.getUrl(1234567890) [-2] == "v"
assert s.getUrl(1234567890) [-3] == "7"
assert s.getUrl(1234567890) [-4] == "y"
assert s.getUrl(1234567890) == "1ly7vk"
assert s.getUrl(1234567890) == "1ly7vk"
// I lied -- test some upper case stuff
assert s.getUrl(98) == "1A"
assert s.getUrl(98 * 98)[-1] == "U"
assert s.getUrl(98 * 98)[-2] == "u"
assert s.getUrl(98 * 98)[-3] == "2"
assert s.getUrl(98 * 98) == "2uU"