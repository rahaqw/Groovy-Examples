#!/usr/bin/env groovy

/* 
 *  Script: expando.groovy
 *
 * Purpose: <>
 *
 *   Usage: groovy expando.groovy <+usage+> 
 *
 *  Author: <+author+>
 */

def inci = new Expando([status : "Foo", name : "My name"])
// Add a 'setStatus' method, mmk?
inci.setStatus = { st -> 
    delegate.setProperty('status', st)
    assert delegate.getProperty('status') == st
}
inci.name = "Set outside of closure."
assert inci.name == "Set outside of closure."

inci.setStatus("Set by closure")
assert inci.status == "Set by closure"
