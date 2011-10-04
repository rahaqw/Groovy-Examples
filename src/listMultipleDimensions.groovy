#!/usr/bin/env groovy

def board = []
9.times {
    def row = [ 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
    board << row
}

board[0][0] = 1
board[2][2] = 2

println board
