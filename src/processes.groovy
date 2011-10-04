#!/usr/bin/env groovy

/* 
 *  Script: processes.groovy
 *
 * Purpose: Demonstrates how to run processes, and check
 * whether they're done.
 *
 *   Usage: groovy processes.groovy <+usage+> 
 *
 *  Author: <+author+>
 */

// Run command 10 times
def seed = new Random()
def procs = []
10.times {
    def seconds = seed.nextInt(5) + 1 
    def cmd = "sleep ${seconds}; echo slept for ${seconds}"

    def proc = '' //cmd.execute()
    procs << ['proc':proc, 'finished':false, 'cmd':cmd]
}

def runningProcs = procs.findAll({ it['finished'] == false })

while (runningProcs) {

    runningProcs.each {

        println it
        //     try {
        //         if (it['proc'].exitValue()) {
        it['finished'] == true
        //             println "Output from ${it.cmd} was: "
        //         }
        //     } catch (IllegalThreadStateException e) {
        //             println "Thread ${it.cmd} not done yet!"
        //     }
        
    }
    runningProcs = runningProcs.findAll({ it['finished'] == false })
}

print "Done!"
