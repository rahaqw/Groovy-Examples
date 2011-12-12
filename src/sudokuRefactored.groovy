#!/usr/bin/env groovy

/* 
 *  Script: sudoku.groovy
 *   Usage: sudoku.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 *    TODO: Equal spacing for html printout
 *          Shade alternating squares differently in HTML printout
 */

// Parse command line arguments
def cli = new CliBuilder(usage: 'groovy sudoku.groovy [-h|--help] [ -t "times" ] [[ -f "file1" ]..]',
                         parser: new org.apache.commons.cli.GnuParser ())

cli.h(argName:'help', longOpt:'help', 'show usage information and quit')
cli.f(argName:'file', longOpt:'file', args:1, required:true, 'File name')
cli.H(argName:'html', longOpt:'html', args:0, required:false, 'Output in HTML')

// To actually parse the command line options, use the following command.
def opt = cli.parse(args)

// cli.parse will have already printed the usage if a required param is missing.
// All we have to do is exit if !opt
if (!opt) return
if (opt.h) {
    cli.usage() 
    return 0
}

def optFile = opt.f
def board = loadFile(optFile)

structures << createRows()
structures << createCols()
structures << createSquares()

def progress = true
if (opt.H) {
    print "<html>"
    print "<head>"
    print '<link rel="Stylesheet" type="text/css" href="style.css" />'
    print "</head>"
    print "<body>"
}
else {
    printBoard(board)
}

def structures = []

while (progress) {
    attemptSolve(board)
    progress = evaluateBoard(board)
    if (opt.H) {
        // printBoardHtml(board, -1, -1)
    }
    else {
        printBoard(board)
    }
}
if (opt.H) {
    print "</body"
    print "</html>"
}
print "done"
// ------------------ Functions ----------------
def loadFile(file) {
    def board = []
    9.times {
        def row = [ 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
        board << row
    }
    def row = 0
    new File(file).eachLine { 
        def lineSquares = it.split('')
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
}

// Returns an array of all the rows on this board
def createRows(board) {
    def rows = []
    0.upto(8) { row ->
        def row = []
        0.upto(8) { col ->
            row << board[row, col]
        }
        rows << row
    }
    rows
}
            
// Returns an array of all the cols on this board
def createCols(board) {
    def cols = []
    0.upto(8) { col ->
        def col = []
        0.upto(8) { row ->
            col << board[row, col]
        }
        cols << col
    }
    cols
}

// Returns an array of all the squares on this board
def createSquares(board) {
    def squares = []
    def startPoints = [ [ 0, 0 ], [ 0, 3 ], [ 0, 6 ],
                        [ 3, 0 ], [ 3, 3 ], [ 3, 6 ],
                        [ 6, 0 ], [ 6, 3 ], [ 6, 6 ] ]
    startPoints.each { row, col ->
        def square = []
        row.upto(row + 2) { thisRow ->
            col.upto(col + 2) { thisCol ->
                square << board[thisRow][thisCol]
            }
        }
        squares << square 
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
        def prev = square.possibleNums.clone()
        square.possibleNums = square.possibleNums.minus(invalidNums)
        if (prev != square.possibleNums) {
            printBoardHtml(board, row, colNum)
        }
    }
    return board
    
}
def eliminateNumsBySquare(board, rootRow, rootCol, print = false) {
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
            if (print) println "removing" + invalidNums + " from " + square.possibleNums
            square.possibleNums = square.possibleNums.minus(invalidNums)
            if (print) println "possible nums for " + row + "," + col + " are now: " + square.possibleNums
            if (print) println "square is: " + square.val
        }
    }
    return board
    
}

def evaluateBoard(board) {
    def progress = false
    0.upto(8) { row ->
        0.upto(8) { col ->
            def square = board[row][col]
            // println "Evaluating " + row + ", " + col
            // println square.possibleNums
            // println square.possibleNums.size()
            if (square.possibleNums.size() == 1) {
                if (square.val == "-") {
                    square.val = square.possibleNums[0]
                    printBoardHtml(board, row, col)
                    // println "progress = true"
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
                // println square.possibleNums
                squareSquares << square
                allPossibleVals = allPossibleVals + square.possibleNums
            }
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
            def square = squareSquares.find { den ->
                den.possibleNums.find { foo ->
                    foo == matches[0]
                }
            }
            // println "setting value to " + matches[0]
            // square.val = matches[0]
            square.possibleNums = [matches[0]]
            // println "Jar"
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

def printBoardHtml(board, changedRow, changedCol) {
    println '<table class="sudoku">'
    0.upto(8) { row ->
    println "<tr>"
        0.upto(8) { col ->
            def square = board[row][col]
            if (row == changedRow && col == changedCol) {
                println "<td class='sudokuChanged'>"
            }
            else {
                println "<td class='sudoku'>"
            }
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
}
def printBoard(board) {
    0.upto(8) { row ->
        0.upto(8) { col ->
            print board[row][col].val
        }
        println ""
    }
    println ""
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
            // square.val = matches[0]
            square.possibleNums = [matches[0]]
        }
    }
}

def attemptSolve(board) {
    
    0.upto(8) {
        board = eliminateNumsByRow(board, it)
    }
    printBoardHtml(board, -1, -1)

    0.upto(8) {
        board = eliminateNumsByColumn(board, it)
    }
    printBoardHtml(board, -1, -1)

    board = eliminateNumsBySquare(board, 0, 0)
    printBoardHtml(board, -1, -1)
    
    board = eliminateNumsBySquare(board, 0, 3)
    printBoardHtml(board, -1, -1)
    board = eliminateNumsBySquare(board, 0, 6)
    printBoardHtml(board, -1, -1)
    board = eliminateNumsBySquare(board, 3, 0)
    printBoardHtml(board, -1, -1)
    board = eliminateNumsBySquare(board, 3, 3)
    printBoardHtml(board, -1, -1)
    board = eliminateNumsBySquare(board, 3, 6)
    printBoardHtml(board, -1, -1)
    board = eliminateNumsBySquare(board, 6, 0)
    printBoardHtml(board, -1, -1)
    board = eliminateNumsBySquare(board, 6, 3)
    printBoardHtml(board, -1, -1)
    board = eliminateNumsBySquare(board, 6, 6)
    printBoardHtml(board, -1, -1)


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
