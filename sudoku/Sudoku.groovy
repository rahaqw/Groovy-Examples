class Sudoku {
    def board = []

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
                board << line
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
}
