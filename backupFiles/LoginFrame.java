import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by neil on 15/3/30.
 */
public class LoginFrame extends JFrame {

    //private static int LOGIN_WIDTH = 400;
    //private static int LOGIN_HEIGHT = 400;

    private JPanel loginPanel;
    private JLabel nameLabel;
    private JLabel pwdLabel;
    private final JTextField nameField;
    private final JPasswordField pwdField;
    private JButton submitButton;
    private JButton cancelButton;

    public LoginFrame(String title) {
        //super(title);

        //setSize(LOGIN_WIDTH,LOGIN_HEIGHT);
        loginPanel = new JPanel();
        nameLabel = new JLabel("Name");
        pwdLabel = new JLabel("Password");

        //the length could be modified later
        nameField = new JTextField(32);
        pwdField = new JPasswordField(32);

        submitButton = new JButton("Login");
        cancelButton = new JButton("Cancel");


        loginPanel.add(nameLabel);
        loginPanel.add(nameField);
        loginPanel.add(pwdLabel);
        loginPanel.add(pwdField);
        loginPanel.add(submitButton);
        loginPanel.add(cancelButton);

        add(loginPanel);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // String name = nameField.getText();
                // String password = pwdField.getText();
                String sql = "select fName from Person";

                //for monitoring the input password
                // System.out.println(password);

                //add logic for matching the name and password
                SqlConnector matchUser = new SqlConnector();
                try {
                    ResultSet rs = matchUser.getStmt().executeQuery(sql);

                    while (rs.next()) {
                        String first = rs.getString("fName");
                        System.out.println("First: " + first);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


                //open the student main frame
                StudentFrame studentFrame = new StudentFrame("Student");
                studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                studentFrame.setVisible(true);

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LoginFrame.this.setVisible(false);
                LoginFrame.this.dispose();
                StartFrame startFrame = new StartFrame("Start");
                startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                startFrame.setVisible(true);

            }
        });
    }


}
