#!/usr/bin/env groovy
// Create the String
def env = System.getenv()
// This doesn't work.
// env['MYVAR'] = 'BOOZIE';
// def command = 'sh -c "export FOO=BAR;./call_me.sh"'
// def command = 'sh -c "\"export FOO=BAR;./call_me.sh\""'
System.setProperty('FOO', 'BAR')
def command = './call_me.sh'
println "command is: ${command}";
def proc = command.execute()                 // Call *execute* on the string
proc.waitFor()                               // Wait for the command to finish

// Obtain status and output
println "return code: ${ proc.exitValue()}"
println "stderr: ${proc.err.text}"
println "stdout: ${proc.in.text}" 
