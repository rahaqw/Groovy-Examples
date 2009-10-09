#!/usr/bin/env groovy

/* 
 *  Script: sudoku.groovy
 *   Usage: sudoku.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */

// Parse command line arguments
def cli = new CliBuilder(usage: 'groovy sudoku.groovy [-h|--help] [ -t "times" ] [[ -f "file1" ]..]',
                         parser: new org.apache.commons.cli.GnuParser ())

cli.h(argName:'help', longOpt:'help', 'show usage information and quit')
cli.f(argName:'file', longOpt:'file', args:1, required:true, 'File name')

// To actually parse the command line options, use the following command.
def opt = cli.parse(args)

// cli.parse will have already printed the usage if a required param is missing.
// All we have to do is exit if !opt
if (!opt) return
if (opt.h) {
    cli.usage() 
    return 0
}

def board = []
9.times {
    def row = [ 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
    board << row
}
def optFile = opt.f
def row = 0
new File(optFile).eachLine { 
    def lineSquares = it.split('')
    // println lineSquares


    def col = 0
    if (lineSquares) {
        lineSquares.each { squareValue ->
        // TODO find out where null or blank value is coming from
            if (squareValue) {
                board[row][col] = [ val:squareValue, 
                           possibleNums: squareValue == "-" ? [ "1", 
                                          "2", 
                                          "3", 
                                          "4" ,
                                          "5", 
                                          "6", 
                                          "7", 
                                          "8", 
                                          "9" ] : []
                           ]
                col++
            }
        }
        row++
    }
}

def eliminateNumsByRow(board, rowNum) {
    def invalidNums = []
    // TODO Find groovier way to collect all values
    // of each square, meow
    0.upto(8) { col ->
        def square = board[rowNum][col]
        invalidNums << square.val
    }

    // println "smith" + invalidNums

    // TODO Find groovier way to do this
    0.upto(8) { col ->
        def square = board[rowNum][col]
        // println "removing" + invalidNums + " from " + square.possibleNums
        square.possibleNums = square.possibleNums.minus(invalidNums)
    }
    return board
    
}
def eliminateNumsByColumn(board, colNum) {
    def invalidNums = []
    // TODO Find groovier way to collect all values
    // of each square, meow
    0.upto(8) { row ->
        def square = board[row][colNum]
        invalidNums << square.val
    }

    // TODO Find groovier way to do this
    0.upto(8) { row ->
        def square = board[row][colNum]
        // println "removing" + invalidNums + " from " + square.possibleNums
        square.possibleNums = square.possibleNums.minus(invalidNums)
    }
    return board
    
}
def eliminateNumsBySquare(board, rootRow, rootCol) {
    def invalidNums = []
    // TODO Find groovier way to collect all values
    // of each square, meow
    rootRow.upto(rootRow + 2) { row ->
        rootCol.upto(rootCol + 2) { col ->
            def square = board[row][col]
            invalidNums << square.val
        }
    }

    // TODO Find groovier way to do this
    rootRow.upto(rootRow + 2) { row ->
        rootCol.upto(rootCol + 2) { col ->
            def square = board[row][col]
            // println "removing" + invalidNums + " from " + square.possibleNums
            square.possibleNums = square.possibleNums.minus(invalidNums)
        }
    }
    return board
    
}

def evaluateBoard(board) {
    def progress = false
    0.upto(8) { row ->
        0.upto(8) { col ->
            def square = board[row][col]
            if (square.possibleNums.size() == 1) {
                if (square.val == "-") {
                    square.val = square.possibleNums[0]
                    progress = true
                }
            }
        }
        }

    return progress
}


def findUniqueInSquare(board, rootRow, rootCol) {

    def allPossibleVals = []
    def rowSquares = []
    def squareSquares = []

    rootRow.upto(rootRow + 2) { row ->
            rootCol.upto(rootCol + 2) { col ->
                def square = board[row][col]
                println square.possibleNums
                squareSquares << square
                allPossibleVals = allPossibleVals + square.possibleNums
            }
        }
        println allPossibleVals

    ["1", "2", "3", "4", "5",
     "6", "7", "8", "9"].each { meow ->
        def matches = allPossibleVals.findAll { foo ->
            foo == meow
        }
        // println matches
        if (matches.size() == 1) {
            // find square with this value in it, meth mouth
            def square = squareSquares.find { den ->
                den.possibleNums.find { foo ->
                    foo == matches[0]
                }
            }
            // println "setting value to " + matches[0]
            square.val = matches[0]
            square.possibleNums = [matches[0]]
            println "Jar"
        }
    }
}

// Go through row, and find squares that have a unique 
// possible value.

def findUniqueInRow(board, rowNum) {

    def allPossibleVals = []
    def rowSquares = []

    // println "Row + ${rowNum}"
    // TODO Find groovier way to collect all values
    // of each square, meow
    0.upto(8) { col ->
        curSquare = board[rowNum][col]
        rowSquares << curSquare
        allPossibleVals = allPossibleVals + curSquare.possibleNums
    }


    // println allPossibleVals

    ["1", "2", "3", "4", "5",
     "6", "7", "8", "9"].each { meow ->
        def matches = allPossibleVals.findAll { foo ->
            foo == meow
        }
        // println matches
        if (matches.size() == 1) {
            // find square with this value in it, meth mouth
            //
            // println "found something"
            // println "rowSquares is: " + rowSquares
            def square = rowSquares.find { den ->
                den.possibleNums.find { foo ->
                    foo == matches[0]
                }
            }
            // println "setting value to " + matches[0]
            square.val = matches[0]
            square.possibleNums = [matches[0]]
        }
    }
}

def printBoardHtml(board) {
    println "<html>"
    println "<body>"
    println "<table>"
    0.upto(8) { row ->
    println "<tr>"
        0.upto(8) { col ->
            println "<td>"
            if (board[row][col].val == "-") {
                println board[row][col].possibleNums.join(',')
            }
            else {
                println board[row][col].val
            }
            println "</td>"
        }
        println "</tr>"
    }
    println "</table>"
    println "</body>"
    println "</html>"
}
def printBoard(board) {
    0.upto(8) { row ->
        0.upto(8) { col ->
            println board[row][col].val
        }
    }
}
def findUniqueInColumn(board, colNum) {

    def allPossibleVals = []
    def colSquares = []

    // TODO Find groovier way to collect all values
    // of each square, meow
    0.upto(8) { row ->
        curSquare = board[row][colNum]
        allPossibleVals = allPossibleVals + curSquare.possibleNums
        colSquares << curSquare
    }

    // println allPossibleVals

    ["1", "2", "3", "4", "5",
     "6", "7", "8", "9"].each { meow ->
        def matches = allPossibleVals.findAll { foo ->
            foo == meow
        }
        // println matches
        if (matches.size() == 1) {
            // find square with this value in it, meth mouth
            // println "Found unique, asshole!"
            def square = colSquares.find { den ->
                den.possibleNums.find { foo ->
                    foo == matches[0]
                }
            }
            // println "setting value to " + matches[0]
            square.val = matches[0]
            square.possibleNums = [matches[0]]
        }
    }
}

def attemptSolve(board) {
    
    0.upto(8) {
        board = eliminateNumsByRow(board, it)
    }
    // println "oba" + board[0][0]

    0.upto(8) {
        board = eliminateNumsByColumn(board, it)
    }
    // println "oba" + board[0][0]

    board = eliminateNumsBySquare(board, 0, 0)
    board = eliminateNumsBySquare(board, 0, 3)
    board = eliminateNumsBySquare(board, 0, 6)
    board = eliminateNumsBySquare(board, 3, 0)
    board = eliminateNumsBySquare(board, 3, 3)
    board = eliminateNumsBySquare(board, 3, 6)
    board = eliminateNumsBySquare(board, 6, 0)
    board = eliminateNumsBySquare(board, 6, 3)
    board = eliminateNumsBySquare(board, 6, 6)


    // println "oba" + board[0][0]
    0.upto(8) {
        findUniqueInRow(board, it)
    }
    0.upto(8) {
        findUniqueInColumn(board, it)
    }

    findUniqueInSquare(board, 0,0)
    findUniqueInSquare(board, 0,3)
    findUniqueInSquare(board, 0,6)
    findUniqueInSquare(board, 3,0)
    findUniqueInSquare(board, 3,3)
    findUniqueInSquare(board, 3,6)
    findUniqueInSquare(board, 6,0)
    findUniqueInSquare(board, 6,3)
    findUniqueInSquare(board, 6,6)

}

def progress = true
while (progress) {
    attemptSolve(board)
    progress = evaluateBoard(board)
    printBoard(board)
    println board[6][1].possibleNums
    println board[7][1].possibleNums
}
print "done"
