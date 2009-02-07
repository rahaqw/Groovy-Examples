#!/usr/bin/env groovy
println "This is SED running .............."
def procEcho = 'echo Nate'.execute()
def procSed = "sed 's/Nate/IDIOT/'".execute()
procEcho | procSed

procSed.waitFor()
print procSed.text
println "This is GREP running .............."

procEcho = 'echo Nate'.execute()
def procGrep = 'grep Nate'.execute()
procEcho | procGrep

procGrep.waitFor()
print procGrep.text
