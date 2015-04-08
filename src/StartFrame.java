import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by neil on 15/3/28.
 * finished.
 */


public class StartFrame extends JFrame {

    private static int START_WIDTH = 400;
    private static int START_HEIGHT = 400;

    private JPanel cards;
    CardLayout cardLayout;

    public StartFrame(String title) {
        super(title);
        setSize(START_WIDTH, START_HEIGHT);

        StartPanel startPanel = new StartPanel();
        LoginPanel loginPanel = new LoginPanel();

        cards = new JPanel(new CardLayout());
        cards.add(startPanel, "startPanel");
        cards.add(loginPanel, "loginPanel");
        cardLayout = (CardLayout) cards.getLayout();

        getContentPane().add(cards);
        setVisible(true);

    }


    public class StartPanel extends JPanel {
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

            addActionToButton(stuLogin);
            addActionToButton(adminLogin);
            addActionToButton(guestLogin);

            this.add(stuLogin);
            this.add(adminLogin);
            this.add(guestLogin);
            this.add(exit);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }

        private void addActionToButton(JButton button) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cards, "loginPanel");
                }
            });
        }



    }

    public class LoginPanel extends JPanel {
        private JLabel nameLabel;
        private JLabel pwdLabel;
        private final JTextField nameField;
        private final JPasswordField pwdField;
        private JButton loginButton;
        private JButton cancelButton;


        public LoginPanel() {
            nameLabel = new JLabel("Name");
            pwdLabel = new JLabel("Password");

            nameField = new JTextField(32);
            pwdField = new JPasswordField(32);

            loginButton = new JButton("Login");
            cancelButton = new JButton("Cancel");

            this.add(nameLabel);
            this.add(nameField);
            this.add(pwdLabel);
            this.add(pwdField);
            this.add(loginButton);
            this.add(cancelButton);
            //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cards, "startPanel");
                }
            });

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username;
                    char[] password;
                    username = nameField.getText();
                    password = pwdField.getPassword();

                    //for test
                    System.out.println(username.toCharArray());
                    System.out.println(password);

                    SqlConnector matchUser = new SqlConnector();

                    String sql = "select * from Student_Auth";
                    try {

                        ResultSet rs = matchUser.getStmt().executeQuery(sql);

                        while (rs.next()) {
                            String uname = rs.getString("USERNAME").trim();
                            //for test
                            System.out.println(uname + "$$$$$");

                            String userid = rs.getString("ID").trim();
                            //for test
                            System.out.println(userid + "$$$$$");

                            String pwd = rs.getString("PASSWORD").trim();
                            //for test
                            System.out.println(pwd + "$$$$$");

                            //----------------------------------------------------------------------
                            //the following comparison needs to romove the blanks following the data
                            //----------------------------------------------------------------------
                            if (uname.equals(username) && Arrays.equals(password, pwd.toCharArray())){
                                System.out.println("Verified!");
                                StartFrame.this.setVisible(false);
                                StudentFrame studentFrame = new StudentFrame("Student", userid);
                                System.out.println("The Student ID is: " + userid);
                                studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                studentFrame.setVisible(true);

                            }
                        }
                        matchUser.getConn().close();

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            

        }

    }

}


