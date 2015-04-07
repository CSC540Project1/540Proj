import javax.swing.*;
import java.awt.*;

public class Main{

    static StartFrame start;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    start = new StartFrame("Start");
                    start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    start.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
