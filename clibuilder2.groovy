#!/usr/bin/env groovy
def cli = new CliBuilder(usage: 'groovy clibuilder2.groovy -t "times" -f "file" -delay "delay"', 
                         parser: new org.apache.commons.cli.GnuParser ())

cli.h(longOpt:'help', 'show usage information and quit')
cli.t(argName:'times', args:1, required:false, 'Number of Incidents to create')
cli.d(argName:'delay', args:1, required:false, 'Delay between Incident requests (milliseconds)')
cli.f(argName:'file', args:1, required:false, 'File name(s) of e-mail templates to use for Incidents')
// The argName property specifies the name of the argument to the option in the usage information. Both of these options have on argument, which is specified with the args property. The required property is used to tell the command line parser if the option is required or not. Finally, we provide a description for the option for use in display usage information.

// That is all we need to do for setup. To actually parse the command line options, use the following command.
def opt = cli.parse(args)
if (!opt) return
if (opt.h) cli.usage() 

// Default to 1 Incident
def numberOfIncidents = (opt.t) ? opt.t : 1

def delayMilliseconds = (opt.d) ? opt.d.toInteger() : 0

def sampleEmailFile  = 'simpleEmailExample'
// Default to simpleEmailExample if no -f args specified.
def emailFiles = opt.f ? opt.fs : 'simpleEmailExample'

emailFiles.each {
    println it
}
