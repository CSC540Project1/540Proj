import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by neil on 15/3/28.
 * finished.
 */


public class StartFrame extends JFrame {

    private static int START_WIDTH = 400;
    private static int START_HEIGHT = 400;

    private JPanel startPanel;
    private JButton stuLogin;
    private JButton adminLogin;
    private JButton guestLogin;
    private JButton exit;

    public StartFrame(String title) {
        super(title);

        setSize(START_WIDTH, START_HEIGHT);

        startPanel = new JPanel();

        stuLogin = new JButton("Student Login");
        adminLogin = new JButton("Admin Login");
        guestLogin = new JButton("Guest Login");
        exit = new JButton("Exit");

        startPanel.add(stuLogin);
        startPanel.add(adminLogin);
        startPanel.add(guestLogin);
        startPanel.add(exit);
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));

        stuLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);



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

        add(startPanel);
    }

    private void addActionToButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartFrame.this.dispose();
                LoginFrame loginFrame = new LoginFrame("Login");
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.setVisible(true);
            }
        });
    }
}


