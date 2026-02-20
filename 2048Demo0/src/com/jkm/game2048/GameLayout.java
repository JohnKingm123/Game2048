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

        int gameData[][]=new int[][]{
            {0,2,2,2},
            {4,8,16,32},
            {64,64,64,64},
            {2048,0,0,0}
        };

        gameWindow.setTitle("2048");
        gameWindow.setSize(540, 600);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setLayout(null);
        gameWindow.setAlwaysOnTop(true);
        gameWindow.setDefaultCloseOperation(3);
        gameWindow.setVisible(true);

        backGround.setBounds(40, 40, 450, 450);
        for (int col = 0; col < 4; col++) {//TODO divide"NEW SET ADD" to 3 different Code Bars
            for (int row = 0; row < 4; row++) {
                if(gameData[col][row]==0){
                    break;
                }

                JLabel numBar0 = new JLabel(
                        new ImageIcon(
                                "E:\\Projects\\JavaSE\\Game2048\\2048Demo0\\Source\\2048Sprites\\A_"+ gameData[col][row] +"_100_100.png"
                                //TODO "Source Way Update" and "safe file address append"
                        )
                );
                numBar0.setBounds(50 + 110 * row, 50 + 110 * col, 100, 100);
                gameWindow.getContentPane().add(numBar0);

            }
        }
        gameWindow.getContentPane().add(backGround);
    }
}
