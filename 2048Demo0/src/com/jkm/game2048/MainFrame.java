package com.jkm.game2048;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MainFrame extends JFrame implements KeyListener , ActionListener {
    int[][] gameData = new int[4][4];

    int loseFlag = 0;
    int score = 0;

    //Grand
    JMenuBar labelMenuBar = new JMenuBar();
    //Father
    JMenu settingsMenu = new JMenu("Settings");
    JMenu gameOptionsMenu = new JMenu("GameOptions");
    JMenu aboutMenu = new JMenu("About");
    //Son
    JMenuItem fullScreen = new JMenuItem("FullScreen");
    JMenuItem clearScore = new JMenuItem("ClearScore");
    JMenuItem quit = new JMenuItem("Quit");

    public MainFrame() {
        initMenu();
        initGameData();
        initFrame();

        paintView();

        this.addKeyListener(this);
        setVisible(true);
    }

    //Init Functions
    public void initGameData() {
        generateNum();
        generateNum();
    }

    public void initFrame() {
        setTitle("2048");
        setSize(540, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(3);
    }

    public void initMenu() {

        labelMenuBar.add(settingsMenu);
        labelMenuBar.add(gameOptionsMenu);
        labelMenuBar.add(aboutMenu);

        settingsMenu.add(fullScreen);
        gameOptionsMenu.add(clearScore);
        gameOptionsMenu.add(quit);

        fullScreen.addActionListener(this);
        clearScore.addActionListener(this);
        quit.addActionListener(this);

        super.setJMenuBar(labelMenuBar);
    }

    public void paintView() {
        getContentPane().removeAll();

        if (loseFlag == 1) {
            JLabel loseLabel = new JLabel(
                    new ImageIcon(
                            "D:\\CodeStorge\\Game2048\\2048Demo0\\Source\\2048Sprites\\gameover_300_100.png"
                    )
            );
            loseLabel.setBounds(112, 225, 300, 100);
            getContentPane().add(loseLabel);
        }

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

        JLabel scoreLabel = new JLabel("Score:" + score);
        scoreLabel.setBounds(40, 500, 100, 20);
        getContentPane().add(scoreLabel);

        getContentPane().repaint();//refresh the new frame
    }

    //Events Override Functions
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {//h j k l 37 38 40 39
        int keyCode = e.getKeyCode();
        boolean isGameOver = false;

        if (keyCode == 37) {
            leftMove(true);
            generateNum();
        } else if (keyCode == 38) {
            upMove(true);
            generateNum();
        } else if (keyCode == 39) {
            rightMove(true);
            generateNum();
        } else if (keyCode == 40) {
            downMove(true);
            generateNum();
        } else {
            return;
        }

        isGameOver = checkFailure();
        if (isGameOver) {
            System.out.println("GameOver");
        }

        paintView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fullScreen) {
            System.out.println("FullScreen");
        } else if (e.getSource() == clearScore) {
            System.out.println("ClearScore");
        } else if (e.getSource() == quit) {
            System.out.println("Quit");
        }
    }

    //Game Logic Functions
    public void leftMove(boolean isRealMove) {
        for (int i = 0; i < gameData.length; i++) {
            int[] tempStorgeArr = new int[4];
            int index = 0;
            for (int x = 0; x < gameData[i].length; x++) {//erase "0" and all to LEFT
                if (gameData[i][x] != 0) {
                    tempStorgeArr[index] = gameData[i][x];
                    index++;
                }
            }

            gameData[i] = tempStorgeArr;

            for (int x = 0; x < gameData[i].length - 1; x++) {
                if (gameData[i][x] == gameData[i][x + 1]) {
                    gameData[i][x] *= 2;
                    if (isRealMove) {
                        score += gameData[i][x];
                    }
                    for (int j = x + 1; j < gameData[i].length - 1; j++) {
                        gameData[i][j] = gameData[i][j + 1];
                    }

                    gameData[i][gameData[i].length - 1] = 0;
                }
            }
        }
    }

    public void rightMove(boolean isRealMove) {
        horizonalSwap();
        leftMove(isRealMove);
        horizonalSwap();
    }

    public void upMove(boolean isRealMove) {
        ctClockWise();
        leftMove(isRealMove);
        clockWise();
    }

    public void downMove(boolean isRealMove) {
        ctClockWise();
        rightMove(isRealMove);
        clockWise();
    }

    //Check Game Status Functions
    public boolean checkLeftFailure() {
        int[][] newArray = new int[4][4];
        copyArray(gameData, newArray);
        leftMove(false);
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                if (gameData[i][j] != newArray[i][j]) {
                    copyArray(newArray, gameData);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRightFailure() {
        int[][] newArray = new int[4][4];
        copyArray(gameData, newArray);
        rightMove(false);
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                if (gameData[i][j] != newArray[i][j]) {
                    copyArray(newArray, gameData);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkUpFailure() {
        int[][] newArray = new int[4][4];
        copyArray(gameData, newArray);
        upMove(false);
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                if (gameData[i][j] != newArray[i][j]) {
                    copyArray(newArray, gameData);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkDownFailure() {
        int[][] newArray = new int[4][4];
        copyArray(gameData, newArray);
        downMove(false);
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                if (gameData[i][j] != newArray[i][j]) {
                    copyArray(newArray, gameData);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkFailure() { //true is for move "failure"
        if (checkLeftFailure() && checkRightFailure() && checkUpFailure() && checkDownFailure()) {// Game Over
            loseFlag = 1;
            return true;
        }
        return false;
    }

    public boolean checkReachGoal(){return false;}//TODO 2048 has reached

    //Tools Functions
    public void horizonalSwap() {
        for (int i = 0; i < gameData.length; i++) {
            reverseArray(gameData[i]);
        }
    }

    public void ctClockWise() {
        int[][] newGameData = new int[4][4];
        for (int i = 0; i < newGameData.length; i++) {
            for (int j = 0; j < newGameData.length; j++) {
                newGameData[3 - j][i] = gameData[i][j];
            }
        }
        gameData = newGameData;
    }

    public void clockWise() {
        int[][] newGameData = new int[4][4];
        for (int i = 0; i < newGameData.length; i++) {
            for (int j = 0; j < newGameData.length; j++) {
                newGameData[j][3 - i] = gameData[i][j];
            }
        }
        gameData = newGameData;
    }

    public void copyArray(int[][] srcData, int[][] destData) {
        for (int i = 0; i < srcData.length; i++) {
            for (int j = 0; j < srcData[i].length; j++) {
                destData[i][j] = srcData[i][j];
            }
        }
    }

    public void reverseArray(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public void generateNum() {
        Random randomGenerator = new Random();

        int[] spareBoxI = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,};
        int[] spareBoxJ = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,};

        int spareBoxIndex = 0;

        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                if (gameData[i][j] == 0) {
                    spareBoxI[spareBoxIndex] = i;
                    spareBoxJ[spareBoxIndex] = j;
                    spareBoxIndex++;
                }
            }
        }

        if (spareBoxIndex != 0) {//still got spare box(s)
            int currentSpareBoxIndex = randomGenerator.nextInt(0, spareBoxIndex);
            int x = spareBoxI[currentSpareBoxIndex];
            int y = spareBoxJ[currentSpareBoxIndex];

            gameData[x][y] = randomGenerator.nextBoolean() ? 2 : 4;
        }
    }


}
