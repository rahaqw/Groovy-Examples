#!/usr/bin/env groovy

/* 
 *  Script: sudokuTests.groovy
 *   Usage: sudokuTests.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */

// Parse command line arguments
def cli = new CliBuilder(usage: 'groovy sudokuTests.groovy [-h|--help] [ -t "times" ] [[ -f "file1" ]..]',
                         parser: new org.apache.commons.cli.GnuParser ())

// cli.h(argName:'help', longOpt:'help', 'show usage information and quit')
// cli.t(argName:'times', args:1, required:false, 'Number of X to create')
// cli.f(argName:'file', longOpt:'file', args:1, required:false, 'File name(s)')

// To actually parse the command line options, use the following command.
// def opt = cli.parse(args)

// cli.parse will have already printed the usage if a required param is missing.
// All we have to do is exit if !opt
// if (!opt) return
// if (opt.h) {
    // cli.usage() 
    // return 0
// }

def s = new Sudoku(new File("sudokuPuzzle4.txt"))
assert s.getSquare(0,0).val == "-"
assert s.getSquare(0,8).val == "8"


def board = '''
---74--16
--5--6--8
-7----5--
4------2-
7---3---5
-2------1
--8----6-
3--6--1--
51--94---'''

def strSudo = new Sudoku(board)
assert strSudo.getSquare(0,0).val == "-"
assert strSudo.getSquare(8,0).val == "5"
assert strSudo.getSquare(8,4).val == "9"
assert strSudo.getSquare(8,8).val == "-"
