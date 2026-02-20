package com.jkm.frame;

import javax.swing.*;
import java.net.URL;

public class DemoFrame {
    public static void main(String[] args) {

        JFrame firstFrame = new JFrame();
        JButton btn0 = new JButton("0");
        JButton btn1 = new JButton("16");
        JLabel title = new JLabel("2048");
        JLabel icon = new JLabel(new ImageIcon(
                "E:\\Projects\\JavaSE\\Game2048\\ExsistedMod\\Source\\2048Sprites\\A_2_100_100.png"
        ));

        firstFrame.setTitle("A JFrames");
        firstFrame.setSize(640,480);
        firstFrame.setLocationRelativeTo(null);
        firstFrame.setLayout(null);// set the normal layout to null
        firstFrame.setAlwaysOnTop(true);
        firstFrame.setDefaultCloseOperation(3);
        firstFrame.setVisible(true);


        title.setBounds(300,5,100,100);
        btn0.setBounds(50,50,100,100);
        btn1.setBounds(150,150,100,100);
        icon.setBounds(250,250,100,100);


        firstFrame.getContentPane().add(title);
        firstFrame.getContentPane().add(btn0);
        firstFrame.getContentPane().add(btn1);
        firstFrame.getContentPane().add(icon);

    }
}
