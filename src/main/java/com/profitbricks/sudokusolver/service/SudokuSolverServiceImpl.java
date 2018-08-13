package com.profitbricks.sudokusolver.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuSolverServiceImpl implements SudokuService {

    private int[][] board;

    private static final int EMPTY = 0;

    private static final int SIZE = 9;

    @Override
    public void setBoard(int[][] board) {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public boolean checkInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;

        return false;
    }

    public boolean checkInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[i][col] == number)
                return true;

        return false;
    }

    public boolean checkInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }

    public boolean isSafe(int row, int col, int number) {
        return !checkInRow(row, number) && !checkInCol(col, number) && !checkInBox(row, col, number);
    }

    @Override
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (board[row][col] == EMPTY) {

                    for (int number = 1; number <= SIZE; number++) {
                        if (isSafe(row, col, number)) {

                            board[row][col] = number;

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void showBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }

    @Override
    public int[][] getBoard() {
        return board;
    }

    @Override
    public String getBoardString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                s.append(",").append(board[i][j]);
            }
        }
        s.delete(0, 1);
        return s.toString();
    }
}
