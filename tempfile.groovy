#!/usr/bin/env groovy
// this script creates a temp file
// that begins with 'Tempfile' in ~/tmp directory
def env = System.getenv()
def tempFile = File.createTempFile('Tempfile', '.sh', new File('/Users/nate/tmp'))
tempFile << "#!/bin/sh\necho hello world\n"
println tempFile.name + ' was created'
command = "chmod 755 /Users/nate/tmp/${tempFile.name}"
def proc = command.execute()                 // Call *execute* on the string
proc.waitFor()
// This doesn't work
// tempFile.setExecutable()
command = "/Users/nate/tmp/${tempFile.name}"
proc = command.execute()
proc.waitFor()

println "Output was: ${proc.in.text}"

