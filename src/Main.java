import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartFrame start = new StartFrame("Start");
                    start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
