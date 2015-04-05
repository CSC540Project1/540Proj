import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by neil on 15/3/28.
 * finished.
 */


public class StartFrame extends JFrame {

    private static int START_WIDTH = 400;
    private static int START_HEIGHT = 400;

    public StartFrame(String title) {
        super(title);

        setSize(START_WIDTH, START_HEIGHT);
        StartPanel startPanel = new StartPanel();
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));


        add(startPanel);
        //pack();
        setVisible(true);
    }

    private class StartPanel extends JPanel {

        private JButton stuLogin;
        private JButton adminLogin;
        private JButton guestLogin;
        private JButton exit;

        public StartPanel() {
            stuLogin = new JButton("Student Login");
            adminLogin = new JButton("Admin Login");
            guestLogin = new JButton("Guest Login");
            exit = new JButton("Exit");

            stuLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
            adminLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
            guestLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
            exit.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(stuLogin);
            add(adminLogin);
            add(guestLogin);
            add(exit);

            addActionToButton(stuLogin);
            addActionToButton(adminLogin);
            addActionToButton(guestLogin);

            //exit the program
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }

        //redirect to the username and password input panel
        private void addActionToButton(JButton button) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StartPanel.this.setVisible(false);
                    LoginPanel loginPanel = new LoginPanel();
                    StartFrame.this.add(loginPanel);
                    loginPanel.setVisible(true);
                }
            });
        }
    }


}


