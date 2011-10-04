def command = "/Users/nate/Documents/contegix/src/jsam/src/bash/tempJsamScript39825.sh"        
// def command = "/Users/nate/tmp/return_code.sh"
def proc = command.execute()
proc.waitFor()
println proc.exitValue()

