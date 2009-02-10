#!/usr/bin/env groovy
/*
 * clibuilder_command_line_options.groovy
 * See also clibuilder_command_line_options.sh
 * Try this script with the following options:
 *
 * -t one -f two -t three -f four -t five
 *  --file this --times 1 --file that
 *  <no options>
 *
 * Uses
 */
def cli = new CliBuilder(usage: 'groovy clibuilder_command_line_options.groovy --times "times" --file "file" --loonie "loonie"', 
                         parser: new org.apache.commons.cli.GnuParser ())

// Define -t option (note cli.t <---)
cli.f(argName:'file', longOpt:'file', args:1, required:true, 'Number of Incidents to send per file')

// Define -f option (note cli.f <---)
cli.t(argName:'times', longOpt:'times', args:1, required:true, 'File(s) to use as templates when sending Incidents')

// Define -l option (note cli.loonies <---)
cli.l(argName:'loonie', longOpt:'loonie', args:1, required:false , 'Number of loony people that work here.')

opt = cli.parse(args)
if (!opt) return

println "Each -f or --file option that you passed was: "
opt.fs.each { 
    println it
}

println "Each t option that you passed was: "
opt.ts.each { 
    println it
}

println "Here are the loonies (if any): "
if (!opt.ls) {
    print "Default Loonie"
}
opt.loonies.each {
    println it
}
