import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by neil on 15/3/30.
 */
public class LoginPanel extends JPanel {

    public LoginPanel() {

        JLabel nameLabel = new JLabel("Name");
        JLabel pwdLabel = new JLabel("Password");

        //the length could be modified later
        final JTextField nameField = new JTextField(32);
        final JPasswordField pwdField = new JPasswordField(32);

        JButton submitButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");


        add(nameLabel);
        add(nameField);
        add(pwdLabel);
        add(pwdField);
        add(submitButton);
        add(cancelButton);

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

                    while (rs.next()){
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
            }
        });
    }


}
