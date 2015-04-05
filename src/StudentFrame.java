import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by neil on 15/3/31.
 */
public class StudentFrame extends JFrame {
    private JPanel stuHomePanel;
    private static int STUDENT_WIDTH = 400;
    private static int STUDENT_HEIGHT = 400;

    public StudentFrame(String title) {
        super(title);
        //final BoxLayout layout = new BoxLayout(stuHomePanel, BoxLayout.PAGE_AXIS);
        //setLayout(layout);

        setSize(STUDENT_WIDTH, STUDENT_HEIGHT);

        final JButton hOptionButton = new JButton("Housing Option");
        final JButton lodgeAComplaint = new JButton("Lodge a complaint");
        final JButton latestInvoice = new JButton("Get the latest invoice");
        final JButton requestParking = new JButton("Request a parking");
        final JButton leaseRequest = new JButton("Lease request");

        stuHomePanel = new JPanel();

        TerminateLease terLeasePanel = new TerminateLease();

        stuHomePanel.setLayout(new BoxLayout(stuHomePanel, BoxLayout.Y_AXIS));
        stuHomePanel.add(hOptionButton);
        stuHomePanel.add(lodgeAComplaint);
        stuHomePanel.add(latestInvoice);
        stuHomePanel.add(requestParking);
        stuHomePanel.add(leaseRequest);
        hOptionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        lodgeAComplaint.setAlignmentX(Component.CENTER_ALIGNMENT);
        latestInvoice.setAlignmentX(Component.CENTER_ALIGNMENT);
        requestParking.setAlignmentX(Component.CENTER_ALIGNMENT);
        leaseRequest.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(stuHomePanel);
    }

    public static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setActionCommand("text");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

}



class LodgeCompliant extends JPanel{
    public LodgeCompliant() {
        JTextField enterUID = new JTextField("as");
        JTextField enterCompliant = new JTextField();
        final JButton compSubmit = new JButton("Submit");

    }

}

class LatestInvoice extends JPanel{
    public LatestInvoice() {
        //use jtable
    }

}

class RequestParking extends JPanel{
    public RequestParking() {
        //u

    }

}

class LeaseRequest extends JPanel{
    public LeaseRequest() {

    }
}

class TerminateLease extends  JPanel{
    public TerminateLease() {

    }
}

