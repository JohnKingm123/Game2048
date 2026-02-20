package com.jkm.game2048;

import javax.swing.*;

public class GameLayout {
    public static void main(String[] args) {
        JFrame gameWindow = new JFrame();

        gameWindow.setTitle("2048");
        gameWindow.setSize(640,480);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setLayout(null);
        gameWindow.setAlwaysOnTop(true);
        gameWindow.setDefaultCloseOperation(3);
        gameWindow.setVisible(true);


    }
}
