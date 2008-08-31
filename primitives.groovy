#!/usr/bin/env groovy
age = 99
// Java integer
println age.class
// Java Long
age = 99.999999999999999
println age.class
// Java BigInteger
//
age = 99.999999999999999
println age.class

// Should be 0.9 -- Java effs this up without
// screwy BigDecimal("2.0").subtract("1.1")
println(2.0 - 1.1)

// BUG!
println(2.0f - 1.1f)


