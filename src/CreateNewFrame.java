import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by neil on 15/4/2.
 */
public class CreateNewFrame extends JFrame {
    private JPanel createUserPanel;
    private static final int LOGIN_WIDTH = 400;
    private static final int LOGIN_HEIGHT = 300;

    public CreateNewFrame(String title) {
        super(title);
        setSize(LOGIN_WIDTH, LOGIN_HEIGHT);
        JLabel nameLabel = new JLabel("Name");
        JLabel pwdLabel = new JLabel("Password");

        //the length could be modified later
        final JTextField nameField = new JTextField(32);
        final JPasswordField pwdField = new JPasswordField(32);

        JButton submitButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        createUserPanel = new JPanel();

        createUserPanel.add(nameLabel);
        createUserPanel.add(nameField);
        createUserPanel.add(pwdLabel);
        createUserPanel.add(pwdField);
        createUserPanel.add(submitButton);
        createUserPanel.add(cancelButton);

        add(createUserPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });

    }

}
