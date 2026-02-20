import javax.swing.JFrame;

public class JavaFrameTest {
    public static void main(String[] args) {
        JFrame firstFrame = new JFrame();
        firstFrame.setSize(640,540);
        firstFrame.setVisible(true);//窗体可见
        firstFrame.setDefaultCloseOperation(3);//关闭模式
        /*
            0 DO_NOTHING_ON_CLOSE &&
            1 HIDE_ON_CLOSE &&
            2 DISPOSE_ON_CLOSE &&
            3 EXIT_ON_CLOSE
        */
        firstFrame.setTitle("2048");//窗体标题 左上

        firstFrame.setLocationRelativeTo(null);//窗体居中
        firstFrame.setAlwaysOnTop(true);//窗体永远在顶层

    }
}
