package com.jkm.game2048;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener {
    int gameData[][] = new int[][]{
            {8, 0, 2, 2},
            {4, 2, 16, 32},
            {64, 64, 2, 64},
            {2048, 2, 0, 2}
    };

    public MainFrame() {
        initFrame();
        paintView();

        //bind KeyboardListener
        this.addKeyListener(this);

        setVisible(true);
    }

    public void initFrame() {
        setTitle("2048");
        setSize(540, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(3);
    }

    public void paintView() {
        getContentPane().removeAll();

        for (int col = 0; col < 4; col++) {//TODO divide"NEW SET ADD" to 3 different Code Bars
            for (int row = 0; row < 4; row++) {
                JLabel numBar0 = new JLabel(
                        new ImageIcon(
                                "D:\\CodeStorge\\Game2048\\2048Demo0\\Source\\2048Sprites\\A_" + gameData[col][row] + "_100_100.png"
                                //TODO "Source Way Update" and "safe file address append"
                        )
                );
                numBar0.setBounds(50 + 110 * row, 50 + 110 * col, 100, 100);
                super.getContentPane().add(numBar0);
            }
        }

        JLabel backGround = new JLabel(
                new ImageIcon(
                        "D:\\CodeStorge\\Game2048\\2048Demo0\\Source\\2048Sprites\\background450_450.png"
                        //TODO "Source Way Update"
                )
        );
        backGround.setBounds(40, 40, 450, 450);
        super.getContentPane().add(backGround);

        getContentPane().repaint();//refresh the new frame
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {//h j k l 37 38 40 39
        int keyCode = e.getKeyCode();

        if (keyCode == 37) {
            leftMove();
        } else if (keyCode == 38) {
            upMove();
        } else if (keyCode == 39) {
            rightMove();
        } else if (keyCode == 40) {
            downMove();
        }

        paintView();
    }

    public void leftMove(){
        for(int i=0;i<gameData.length;i++){
            int[] tempStorgeArr = new int[4];
            int index = 0;
            for(int x = 0;x<gameData[i].length;x++){//erase "0" and all to LEFT
                if(gameData[i][x]!=0){
                    tempStorgeArr[index] = gameData[i][x];
                    index++;
                }
            }

            gameData[i] = tempStorgeArr;

            for(int x = 0;x<gameData[i].length-1;x++){
                if(gameData[i][x]==gameData[i][x+1]){
                    gameData[i][x]*=2;
                    for(int j = x+1;j<gameData[i].length-1;j++){
                        gameData[i][j]=gameData[i][j+1];
                    }

                    gameData[i][gameData[i].length-1]=0;
                }
            }
        }
    }

    public void rightMove(){
        horizonalSwap();
        leftMove();
        horizonalSwap();
    }

    public void upMove(){
        ctClockWise();
        leftMove();
        clockWise();
    }

    public void downMove(){
        ctClockWise();
        rightMove();
        clockWise();
    }

    public void horizonalSwap(){
        for(int i = 0;i<gameData.length;i++){
            reverseArray(gameData[i]);
        }
    }

    public void reverseArray(int[] arr){
        for(int start = 0,end = arr.length-1;start<end;start++,end--){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
        }
    }

    public void ctClockWise(){
        int [][] newGameData = new int[4][4];
        for(int i =0;i<newGameData.length;i++){
            for(int j = 0;j< newGameData.length;j++){
                newGameData[3-j][i] = gameData[i][j];
            }
        }
        gameData = newGameData;
    }

    public void clockWise(){
        int [][] newGameData = new int[4][4];
        for(int i =0;i<newGameData.length;i++){
            for(int j = 0;j< newGameData.length;j++){
                newGameData[j][3-i] = gameData[i][j];
            }
        }
        gameData = newGameData;
    }

}
