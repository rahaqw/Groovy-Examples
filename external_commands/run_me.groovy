#!/usr/bin/env groovy
// Create the String
def env = System.getenv()
// env['MYENVBAR2'] = 'BOOZIE';
// env['MYENVBAR1'] = 'foo';
// sh -c \"export MYENVVAR2=BOOZIE;
def command = """sh -c \"export MYENVVAR1=BOO;./call_me.sh\""""
println "command is: ${command}";
def proc = command.execute()                 // Call *execute* on the string
proc.waitFor()                               // Wait for the command to finish

// Obtain status and output
println "return code: ${ proc.exitValue()}"
println "stderr: ${proc.err.text}"
println "stdout: ${proc.in.text}" 
