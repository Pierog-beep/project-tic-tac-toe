/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.board;

import java.util.Arrays;

public class Board {

    public static final int SIZE = 3;
    public static final char EMPTY = ' ', X = 'x', O = 'o';

    private char[][] board;
    private int x_score, o_score;

    public Board() {
        clear();
    }

    public void clear() {
        board = new char[SIZE][SIZE];

        for (char[] row : board) {
            Arrays.fill(row, EMPTY);
        }
    }

    public Boolean isWin() {

        for (int i = 0; i < SIZE; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2])) return true;
        }

        for (int i = 0; i < SIZE; i++) {
            if (checkLine(board[0][i], board[1][i], board[2][i])) return true;
        }

        if (checkLine(board[0][0], board[1][1], board[2][2])) return true;
        if (checkLine(board[2][0], board[1][1], board[0][2])) return true;

        return false;
    }

    public boolean isOccupied(int x, int y) {
        return !(board[y][x] == EMPTY);
    }

    public void placeSign(char znak, int x, int y) throws IllegalStateException{
        if (board[y][x] == EMPTY)  board[y][x] = znak;
        else throw new IllegalStateException("Cell is occupied!");
    }

    public void updateXScore() {
        this.x_score++;
    }

    public void updateOScore() {
        this.o_score++;
    }

    public int getXScore() {
        return x_score;
    }

    public int getOScore() {
        return o_score;
    }

    public char[][] getImage() {
        return board;
    }

    private boolean checkLine(char cell_1, char cell_2, char cell_3) {
        return cell_1 != EMPTY && cell_1 == cell_2 && cell_2 == cell_3;
    }
}
