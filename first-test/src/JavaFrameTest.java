import javax.swing.*;
import java.awt.event.*;
import java.util.Random;


public class JavaFrameTest extends JFrame implements  MouseListener,ActionListener, KeyListener {
    private JButton btn0 = new JButton();

    public JavaFrameTest(){
        initFrame();
        setVisible(true);
    }

    private void initFrame(){
        setSize(540, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(3);
        setTitle("2048");//窗体标题 左上
        setLocationRelativeTo(null);//窗体居中
        setAlwaysOnTop(true);//窗体永远在顶层
        btn0.setBounds(0,0,50,50);

        super.getContentPane().add(btn0);
        btn0.addActionListener(this);
        btn0.addMouseListener(this);

        this.setFocusable(true);//Focus on Frame , not "btn0"
        this.addKeyListener(this);
    }

    public static void main(String[] args) {
        new JavaFrameTest();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        Random rd = new Random();
//        btn0.setBounds(rd.nextInt(0,300),rd.nextInt(0,300),100,100);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
    }
}

//class ActionListenerImpl implements ActionListener {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("DING~");
//    }
//}
//class MouseListenerImpl implements MouseListener{
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("clicked");
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        System.out.println("pressed");
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        System.out.println("released");
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        System.out.println("enter");
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        System.out.println("exit");
//    }
//}