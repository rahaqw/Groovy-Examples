#!/usr/bin/env groovy
// This script creates a temp file that has an "export" statement in it,
// followed by the name of a shell script to execute.
// the shell script should be able to see the variable that is 
// exported in the temp file.
def env = System.getenv()
def child_script = File.createTempFile('Tempfile', '.sh')
child_script << "#!/bin/sh\necho environment variable FOO is \$FOO\n"

command = "chmod 755 ${child_script.absolutePath}"
def proc = command.execute()                 // Call *execute* on the string
proc.waitFor()
// Create temp file that sets environment variables, then calls
// child script
temp_script_contents = """
#!/bin/sh
export FOO="BAR BAZ BARBITUATE"
${child_script.absolutePath}
"""

def temp_script = File.createTempFile('Tempfile', '.sh') << temp_script_contents
command = "chmod 755 ${temp_script.absolutePath}"
proc = command.execute()
proc.waitFor()

command = temp_script.absolutePath
proc = command.execute()
proc.waitFor()
println "Output was: ${proc.in.text}"                
println "Environment FOO from the parent script is: " + env['FOO']
println "Environment HOME is: " + env['HOME']
