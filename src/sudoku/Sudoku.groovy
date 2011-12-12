class Sudoku {
    def board
    // data structures to represent cells
    // that are grouped together in rows, columns, and 
    // squares.  Makes object access easier for testing
    def rows = []
    def cols = []
    def regions = []

    public getSquare(row, col) {
        board[row][col]
    }

    def Sudoku(String str) {
        board = loadString(str)
    }

    def Sudoku(File inputFile) {
        def s = inputFile.getText()
        board = loadString(inputFile)
    }

    def getBoard() {
        return board
    }

    // Load board using a String
    def loadString(str) {
        board = []
        str.eachLine { 
            def lineSquares = it.split('')
            def col = 0
            if (lineSquares) {
                // TODO Use collect method to make more readable
                def line = []
                lineSquares.each { 
                    // TODO find out where blank "" vals are coming from
                    if (it) {
                        line << [ val:it,
                                  possibleNums: it == "-" ? [ "1", "2", "3", "4" ,
                                                      "5", "6", "7", "8", "9" ] : [] ]
                    }
                }
                // TODO without this if (line), board gets an empty
                // array at the beginning of the array
                if (line) board << line
            }
        }
        return board
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

    def tidyPossibleNums(cells) {
        def existingNums = []
        // TODO Find groovier way to collect all values
        // of each square, meow
        existingNums = cells.collect {
            it.val
        }

        // TODO Find groovier way to do this
        cells.each {
            // def prev = square.possibleNums.clone()
            it.possibleNums = it.possibleNums.minus(existingNums)
            // if (prev != square.possibleNums) {
                // printBoardHtml(board, row, colNum)
            // }
        }

    }

    // Find cells that have a possible Num that is unique to
    // that cell.  Set the .val of that cell = to the unique val
    def tidyUniquePossibles(cells) {
        
        def rowSquares = []
        def allPossibleNums = cells.collect {
            it.possibleNums
        }
        allPossibleNums = allPossibleNums.flatten()
        
        // TODO: find groovier way to do this
        ["1", "2", "3", "4", "5",
         "6", "7", "8", "9"].each { meow ->
            def matches = allPossibleNums.findAll { foo ->
                foo == meow
            }
            // println matches
            if (matches.size() == 1) {
                // find square with this value in it, meth mouth
                def square = cells.find { cell ->
                    cell.possibleNums.find { it == matches [0] }
                }
                // println "setting value to " + matches[0]
                // square.val = matches[0]
                square.possibleNums = [matches[0]]
                // println "Jar"
            }
        }
    }

    // trimPossiblesByRegion will filter possible numbers from
    // a row or column IF there are squares in that row or column
    // that belong to the same region which MUST have the possible numbers.
    // Example:  Squares 1 and 2 MUST have either 2 or 3, because all
    // other numbers in that region are taken.  We can eliminate
    // 2 and 3 from other squares in the same row as Squares 1 and 2, if
    // Squares 1 and 2 are in the same row.
    def trimPossiblesByRegion() {
        // Go through each region
        // Go through all possible numbers
        // If 2 or 3 squares have the same possible number, and no other
        // square has that number possible, then see if the squares share
        // the same row or column.
        // If so, elminate that possible number from all other squares in the
        // row or column
    }

    def findExclusivePossibles(region) {
        def results = []
        ["1", "2", "3", "4", "5",
         "6", "7", "8", "9"].each { possibleNum ->
            def squares = region.findAll { square ->
                square.possibleNums.findAll { it == possibleNum }
            }

            if (squares.size == 2 || squares.size == 3) {
                results << [ possibleNum:possibleNum, squares:squares ]
            }

        }
        return results

    }
}
