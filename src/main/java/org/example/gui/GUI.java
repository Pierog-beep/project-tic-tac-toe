/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.gui;

import org.example.app.TicTacToe;
import org.example.board.Board;
import org.example.bot.TicTacToeBot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private final JLabel score_label;
    private final JButton resetButton;
    private final GameButton[][] ticTacToeButtons;

    private final Board board;
    private final TicTacToe ticTacToe;
    int row, column;

    static class GameButton extends JButton {
        public final int row, column;

        GameButton(int row, int column, GUI gui, TicTacToe ticTacToe) {

            this.row = row;
            this.column = column;

            super.addActionListener(e -> {
                gui.row = row;
                gui.column = column;
                ticTacToe.run();
            });
        }
    }

    public GUI(TicTacToe ticTacToe, Board board) {

        this.board = board;
        this.ticTacToe = ticTacToe;
        this.ticTacToeButtons = new GameButton[Board.SIZE][Board.SIZE];

        // Setting up a window
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("TicTacToe");
        this.setLayout(null);

        // Setting up score label
        score_label = new JLabel();
        score_label.setText("0:0");
        score_label.setBounds(190, 30, 100, 20);
        score_label.setHorizontalAlignment(JLabel.CENTER);
        this.add(score_label);

        // Setting up a reset button
        resetButton = new JButton();
        resetButton.setBounds(190, 400, 100, 50);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.clear();
                update();
            }
        });
        resetButton.setText("Reset");
        this.add(resetButton);

        // Setting up the buttons 
        int cor_x = 80, cor_y = 70, space_x = 10, space_y = 10;
        int gameBtnSize = 100;

        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                ticTacToeButtons[row][col] = new GameButton(row, col, this, this.ticTacToe);
                ticTacToeButtons[row][col].setBounds(cor_x, cor_y, gameBtnSize, gameBtnSize);
                this.add(ticTacToeButtons[row][col]);
                cor_x += gameBtnSize + space_x;
            }
            cor_y += gameBtnSize + space_y;
            cor_x = 80;
        }
        this.setVisible(true);
    }

    public void update() {

        char[][] boardCharList = board.getImage();

        for (GameButton[] button_row : ticTacToeButtons) {
            for (GameButton button : button_row) {

                char buttonChar = boardCharList[button.column][button.row];
                button.setText(Character.toString(buttonChar));
                button.setEnabled(buttonChar == Board.EMPTY);
            }
        }

        score_label.setText(board.getXScore() + ":" + board.getOScore());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
