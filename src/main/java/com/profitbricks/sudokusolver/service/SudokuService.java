package com.profitbricks.sudokusolver.service;

public interface SudokuService {
    void setBoard(int[][] board);

    boolean solve();

    void showBoard();

    int[][] getBoard();

    String getBoardString();
}
