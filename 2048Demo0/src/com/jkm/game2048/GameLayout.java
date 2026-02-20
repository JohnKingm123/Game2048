package com.jkm.game2048;

import javax.swing.*;

public class GameLayout {
    public static void main(String[] args) {
        JFrame gameWindow = new JFrame();
        JLabel backGround = new JLabel(
                new ImageIcon(
                        "E:\\Projects\\JavaSE\\Game2048\\2048Demo0\\Source\\2048Sprites\\background450_450.png"//TODO "Source Way Update"
                )
        );


        gameWindow.setTitle("2048");
        gameWindow.setSize(540, 600);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setLayout(null);
        gameWindow.setAlwaysOnTop(true);
        gameWindow.setDefaultCloseOperation(3);
        gameWindow.setVisible(true);

        backGround.setBounds(40, 40, 450, 450);
        for (int row = 0; row < 4; row++) {//TODO divide"NEW SET ADD" to 3 different Code Bars
            for (int col = 0; col < 4; col++) {
                JLabel numBar0 = new JLabel(
                        new ImageIcon(
                                "E:\\Projects\\JavaSE\\Game2048\\2048Demo0\\Source\\2048Sprites\\A_16_100_100.png"//TODO "Source Way Update"
                        )
                );
                numBar0.setBounds(50 + 110 * row, 50 + 110 * col, 100, 100);
                gameWindow.getContentPane().add(numBar0);

            }
        }
        gameWindow.getContentPane().add(backGround);
    }
}
