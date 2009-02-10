#!/bin/sh
MYCMD="./clibuilder_command_line_options.groovy -t one -t two -f three -f four"
echo Press ENTER to run $MYCMD
read -s
$MYCMD

# NOTE:  Four.txt is not printed here.
MYCMD="./clibuilder_command_line_options.groovy --times 1 --file one.txt --file two.txt --file three.txt four.txt"
echo Press ENTER to run $MYCMD
read -s
$MYCMD

# Print loonies
MYCMD="./clibuilder_command_line_options.groovy --loonie one -f 1 -t 2"
echo Press ENTER to run $MYCMD
read -s
$MYCMD
