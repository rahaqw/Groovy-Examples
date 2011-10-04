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


def row = [
            [ val:'1', possibleNums:[]],
            [ val:'2', possibleNums:[]],
            [ val:'-', possibleNums:['1', '2', '3', '4', '5']]]

strSudo.tidyPossibleNums(row)
assert row[2].possibleNums == ['3', '4', '5']

row = [
            [ val:'1', possibleNums:[]],
            [ val:'2', possibleNums:[]],
            [ val:'-', possibleNums:['1', '2', '3', '4', '5']],
            [ val:'-', possibleNums:['1', '2', '3', '4', '5']],
            [ val:'-', possibleNums:['1', '2', '3', '4', '5']],
            [ val:'-', possibleNums:['1', '2', '6', '3', '4', '5']],
            [ val:'-', possibleNums:['1', '2', '3', '7', '4', '5']]
]

strSudo.tidyUniquePossibles(row)
assert row[-2].possibleNums == ['6']
assert row[-1].possibleNums == ['7']

// Test data from ../sudokuExcludeFromOtherRegions.html
def region = [
            [ val:'9', possibleNums:[]],
            [ name:'buddy', val:'-', possibleNums:['3', '5', '8']],
            [ val:'-', possibleNums:['3', '6']],
            [ val:'1', possibleNums:[]],
            [ name:'holly', val:'-', possibleNums:['2', '3', '5', '8']],
            [ val:'-', possibleNums:['2', '3']],
            [ val:'4', possibleNums:[]],
            [ val:'7', possibleNums:[]],
            [ val:'-', possibleNums:['2', '3', '6']]
]

def results = strSudo.findExclusivePossibles(region)
println results

// The two is available in three of the squares
assert results[0].possibleNum == "2"
assert results[0].squares.size == 3
// The five is available in only two squares
assert results[1].possibleNum == "5"
assert results[1].squares.size == 2
// The six is available in only two squares
assert results[2].possibleNum == "6"
assert results[2].squares.size == 2
// The eight is available in only two squares
assert results[3].possibleNum == "8"
assert results[3].squares.size == 2

