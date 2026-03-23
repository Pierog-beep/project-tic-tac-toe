/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example.app;

import org.example.board.Board;
import org.example.bot.TicTacToeBot;
import org.example.gui.GUI;

import java.util.Arrays;

public class TicTacToe implements Runnable {

    private final GUI gui;
    private final Board board;
    private final TicTacToeBot ticTacToeBot;

    public TicTacToe(Board board) {
        this.gui = new GUI(this, board);
        this.board = board;
        this.ticTacToeBot = new TicTacToeBot(board);
    }

    static void main(String[] args) {
        new TicTacToe(new Board());
    }

    @Override
    public void run() {

        try{
            board.placeSign(Board.X, gui.getRow(), gui.getColumn());
            if (board.isWin()) {
                board.updateXScore();
                board.clear();
            }
            gui.update();

            ticTacToeBot.generateMove();
            board.placeSign(Board.O, ticTacToeBot.getRow(),  ticTacToeBot.getColumn());
            if (board.isWin()) {
                board.updateOScore();
                board.clear();
            }
            gui.update();

        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}
