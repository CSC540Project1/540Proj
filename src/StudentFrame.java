import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by neil on 15/3/31.
 */
public class StudentFrame extends JFrame {
    private static int STUDENT_WIDTH = 600;
    private static int STUDENT_HEIGHT = 600;

    private JPanel stuCards;

    CardLayout stuCardLayout;

    public StudentFrame(String title, String userid) {
        super(title);
        this.setSize(STUDENT_WIDTH, STUDENT_HEIGHT);

        stuCards = new JPanel(new CardLayout());

        //StuMainPanel
        StuMainPanel stuMainPanel = new StuMainPanel();
        HousOptionPanel housOptionPanel = new HousOptionPanel();
        ParkOptionPanel parkOptionPanel = new ParkOptionPanel();
        MaintPanel maintPanel = new MaintPanel();
        ProfPanel profPanel = new ProfPanel();

        stuCards.add(stuMainPanel, "stuMainPanel");
        stuCards.add(housOptionPanel, "housOptionPanel");
        stuCards.add(parkOptionPanel, "parkOptionPanel");
        stuCards.add(maintPanel, "maintPanel");
        stuCards.add(profPanel, "profPanel");


        //Under the Housing Option Panel
        ViewInvoicesPanel viewInvoicesPanel = new ViewInvoicesPanel(userid);
        ViewLeasesPanel viewLeasesPanel = new ViewLeasesPanel();
        NewRequestPanel newRequestPanel = new NewRequestPanel();
        NLeaReqPanel nLeaReqPanel = new NLeaReqPanel();
        TerLeaReqPanel terLeaReqPanel = new TerLeaReqPanel();
        VorCRequestPanel vorCRequestPanel = new VorCRequestPanel();
        LViewReqPanel lViewReqPanel = new LViewReqPanel();
        LCancReqPanel lCancReqPanel = new LCancReqPanel();
        ViewVacancyPanel viewVacancyPanel = new ViewVacancyPanel();

        stuCards.add(viewInvoicesPanel, "viewInvoicesPanel");
        stuCards.add(viewLeasesPanel, "viewLeasePanel");
        stuCards.add(newRequestPanel, "newRequestPanel");
        stuCards.add(nLeaReqPanel, "nLeaReqPanel");
        stuCards.add(terLeaReqPanel, "terLeaReqPanel");
        stuCards.add(vorCRequestPanel, "vorCRequestPanel");
        stuCards.add(lViewReqPanel, "lViewReqPanel");
        stuCards.add(lCancReqPanel, "lCancReqPanel");
        stuCards.add(viewVacancyPanel, "viewVacancyPanel");

        //Under the Parking Option Panel
        ReqNewPanel reqNewPanel = new ReqNewPanel();
        VParkInfoPanel vParkInfoPanel = new VParkInfoPanel();
        VCurParkPanel vCurParkPanel = new VCurParkPanel();
        ReParkPanel reParkPanel = new ReParkPanel();
        VReqPanel vReqPanel = new VReqPanel();

        stuCards.add(reqNewPanel, "reqNewPanel");
        stuCards.add(vParkInfoPanel, "vParkInfoPanel");
        stuCards.add(vCurParkPanel, "vCurParkPanel");
        stuCards.add(reParkPanel, "reParkPanel");
        stuCards.add(vReqPanel, "vReqPanel");


        stuCardLayout = (CardLayout) stuCards.getLayout();
        getContentPane().add(stuCards);
        setVisible(true);

    }

    public class StuMainPanel extends JPanel {
        private JButton housingOptButton;
        private JButton parkingOptButton;
        private JButton maintButton;
        private JButton profileButton;
        private JButton backButton;

        public StuMainPanel() {
            housingOptButton = new JButton("Housing Option");
            parkingOptButton = new JButton("Parking Option");
            maintButton = new JButton("Maintenance");
            profileButton = new JButton("Profile");
            backButton = new JButton("Back");

            housingOptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            parkingOptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            maintButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            housingOptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "housOptionPanel");
                }
            });

            parkingOptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "parkOptionPanel");
                }
            });

            maintButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "maintPanel");
                }
            });

            profileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "profPanel");
                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StudentFrame.this.dispose();
                    Main.start.setVisible(true);
                }
            });

            this.add(housingOptButton);
            this.add(parkingOptButton);
            this.add(maintButton);
            this.add(profileButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }

    }


    //HousOptionPanel and subpanels
    public class HousOptionPanel extends JPanel {
        private JLabel hOptLabel;
        private JButton viewInvoButton;
        private JButton viewleasButton;
        private JButton newRequButton;
        private JButton vcRequButton;
        private JButton viewVacaButton;
        private JButton backButton;

        public HousOptionPanel() {
            hOptLabel = new JLabel("Housing Options");
            viewInvoButton = new JButton("View Invoices");
            viewleasButton = new JButton("View Leases");
            newRequButton = new JButton("New Request");
            vcRequButton = new JButton("View/Cancel Requests");
            viewVacaButton = new JButton("View Vacancy");
            backButton = new JButton("Back");

            hOptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            viewInvoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            viewleasButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            newRequButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vcRequButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            viewVacaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            viewInvoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "viewInvoicesPanel");
                }
            });

            viewleasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "viewLeasePanel");
                }
            });

            newRequButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "newRequestPanel");
                }
            });

            vcRequButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "vorCRequestPanel");
                }
            });

            viewVacaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "viewVacancyPanel");
                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "stuMainPanel");
                }
            });

            this.add(hOptLabel);
            this.add(viewInvoButton);
            this.add(viewleasButton);
            this.add(newRequButton);
            this.add(vcRequButton);
            this.add(viewVacaButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class ViewInvoicesPanel extends JPanel {
        private JLabel vInvoLabel;
        private JButton vCurInvoButton;
        private JButton vForInvoButton;
        private JButton backButton;

        private JTable vInvoTable;
        private Vector<String> vInvo;
        private Vector<Vector<String>> data;

        public ViewInvoicesPanel(final String userid) {
            vInvoLabel = new JLabel("View Invoices");
            vCurInvoButton = new JButton("View current invoice");
            vForInvoButton = new JButton("View former invoices");
            backButton = new JButton("Back");

            vInvoTable = new JTable();
            vInvo = new Vector<String>();
            data = new Vector<Vector<String>>();

            vInvo.add("StudentID");
            vInvo.add("HouseRent");
            vInvo.add("ParkingFee");
            vInvo.add("MaintenanceFee");
            vInvo.add("DamageCharges");
            vInvo.add("Total");

            vInvoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            vCurInvoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vForInvoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            vCurInvoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultTableModel model = new DefaultTableModel(data, vInvo);
                    model.setRowCount(0);

                    try {
                        SqlConnector viewCur = new SqlConnector();

                        // String vCurQuery = "select R.studentID, R.HouseRent, PF.parkfee, M315.MaintainMar15, TR.DamageChrgs, (R.HouseRent+PF.parkfee+M315.MaintainMar15+TR.DamageChrgs) AS Total_due FROM ResidentialRent R LEFT OUTER JOIN ParkingFee PF ON R.studentID=PF.StudentID LEFT OUTER JOIN MaintainChrg_Mar2015 M315 ON PF.StudentID = M315.StIDMaintainMar15 LEFT OUTER JOIN TerminateReq TR ON M315.StIDMaintainMar15= TR.ID AND TR.InvoiceMnth=03 WHERE R.StudentID like ?";

                        String sql = "select R.studentID, R.HouseRent, PF.parkfee, M315.MaintainMar15, TR.DamageChrgs, (R.HouseRent+PF.parkfee+M315.MaintainMar15+TR.DamageChrgs) AS Total_due FROM ResidentialRent R LEFT OUTER JOIN ParkingFee PF ON R.studentID=PF.StudentID LEFT OUTER JOIN MaintainChrg_Mar2015 M315 ON PF.StudentID = M315.StIDMaintainMar15 LEFT OUTER JOIN TerminateReq TR ON M315.StIDMaintainMar15= TR.ID AND TR.InvoiceMnth=03";

                        //PreparedStatement vCQ = viewCur.getConn().prepareStatement(vCurQuery);
                        //vCQ.setString(1, "%"+userid+"%");
                        // vCQ.executeUpdate();


                        //ResultSet rs = vCQ.executeQuery();
                        ResultSet rs = viewCur.getStmt().executeQuery(sql);

                        while (rs.next()) {

                            Vector<String> bufString = new Vector<String>();

                            bufString.add(rs.getString("studentID"));

                            bufString.add(rs.getString("HouseRent"));

                            //real
                            bufString.add(rs.getString("parkfee"));

                            //real
                            bufString.add(rs.getString("MaintainMar15"));

                            //real
                            bufString.add(rs.getString("DamageChrgs"));

                            //real
                            bufString.add(bufString.elementAt(0)+bufString+);

                            bufString.add("\n");
                            //System.out.println(bufString.elementAt(6));
                            data.add(bufString);
                        }

                        viewCur.getStmt().close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    model = new DefaultTableModel(data, vInvo);
                    vInvoTable.setModel(model);
                    vInvoTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
                    vInvoTable.setFillsViewportHeight(true);
                }
            });

            vForInvoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        SqlConnector viewCur = new SqlConnector();

                        String vCurQuery = "select R.studentID, R.HouseRent, PF.parkfee, M315.MaintainMar15, TR.DamageChrgs, (R.HouseRent+PF.parkfee+M315.MaintainMar15+TR.DamageChrgs) AS Total_due FROM ResidentialRent R LEFT OUTER JOIN ParkingFee PF ON R.studentID=PF.StudentID LEFT OUTER JOIN MaintainChrg_Mar2015 M315 ON PF.StudentID = M315.StIDMaintainMar15 LEFT OUTER JOIN TerminateReq TR ON M315.StIDMaintainMar15= TR.ID AND TR.InvoiceMnth=03 WHERE R.StudentID like ?";

                        PreparedStatement vCQ = viewCur.getConn().prepareStatement(vCurQuery);
                        vCQ.setString(1, "%" + userid + "%");
                        vCQ.executeUpdate();

                        Vector<String> bufString = new Vector<String>();


                        ResultSet rs = vCQ.executeQuery();

                        while (rs.next()) {
                            bufString.add(rs.getString("studentID").trim());
                            bufString.add(rs.getString("HouseRent").trim());
                            bufString.add(rs.getString("parkfee").trim());
                            bufString.add(rs.getString("MaintainMar15").trim());
                            bufString.add(rs.getString("DamageChrgs").trim());
                            bufString.add(rs.getString("Total_due").trim());
                            bufString.add("\n");
                            //System.out.println(bufString.elementAt(6));


                            data.add(bufString);
                        }

                        viewCur.getStmt().close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    DefaultTableModel model = new DefaultTableModel(data, vInvo);
                    vInvoTable.setModel(model);
                    vInvoTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
                    vInvoTable.setFillsViewportHeight(true);

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "housOptionPanel");
                }
            });

            this.add(vInvoLabel);
            this.add(new JScrollPane(vInvoTable));
            this.add(vCurInvoButton);
            this.add(vForInvoButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

    }


    public class ViewLeasesPanel extends JPanel {
        private JLabel vLeaseLabel;
        private JButton vCurLButton;
        private JButton vForLButton;
        private JButton backButton;


        private JTable vleaTable;
        private Vector<String> vlea;
        private Vector<Vector<String>> data;

        public ViewLeasesPanel() {
            vLeaseLabel = new JLabel("View Lease");
            vCurLButton = new JButton("View current lease");
            vForLButton = new JButton("View former lease");
            backButton = new JButton("Back");

            vleaTable = new JTable();
            vlea = new Vector<String>();
            data = new Vector<Vector<String>>();

            vlea.add("leaseNumber");
            vlea.add("");


            vLeaseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            vCurLButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vForLButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            vCurLButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "");
                }
            });

            vForLButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "");
                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "housOptionPanel");
                }
            });

            this.add(vLeaseLabel);
            this.add(vleaTable);
            this.add(vCurLButton);
            this.add(vForLButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }
    }

    public class NewRequestPanel extends JPanel {
        private JLabel nReqLabel;
        private JButton nLeaReqButton;
        private JButton tLeaReqButton;
        private JButton backButton;

        public NewRequestPanel() {
            nReqLabel = new JLabel("New Request");
            nLeaReqButton = new JButton("New lease request");
            tLeaReqButton = new JButton("Terminate lease request");
            backButton = new JButton("Back");

            nReqLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            nLeaReqButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            tLeaReqButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            nLeaReqButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "nLeaReqPanel");
                }
            });

            tLeaReqButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "terLeaReqPanel");
                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "housOptionPanel");

                }
            });

            this.add(nReqLabel);
            this.add(nLeaReqButton);
            this.add(tLeaReqButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class NLeaReqPanel extends JPanel {
        private JLabel panelTitle = new JLabel("New Lease Request");
        private JLabel enterLabel = new JLabel("Enter following details: ");
        private JLabel perForLeaLabel = new JLabel("Period for leasing");
        private JTextField perForLea = new JTextField();
        private JLabel houPrefLabel = new JLabel("Housing Preference");
        private JTextField houOpt1 = new JTextField("Preference 1");
        private JTextField houOpt2 = new JTextField("Preference 2");
        private JTextField houOpt3 = new JTextField("Preference 3");

        private JLabel entDateLabel = new JLabel("The date you want to enter the room");
        private JTextField entDate = new JTextField();
        private JLabel payOptLabel = new JLabel("Payments options, monthly or once semester");
        private JTextField payOpt = new JTextField();
        private JButton submitButton = new JButton("Submit");
        private JButton backButton = new JButton("Back");

        public NLeaReqPanel() {
            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            enterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            perForLeaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            perForLea.setAlignmentX(Component.CENTER_ALIGNMENT);
            houPrefLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            houOpt1.setAlignmentX(Component.CENTER_ALIGNMENT);
            houOpt2.setAlignmentX(Component.CENTER_ALIGNMENT);
            houOpt3.setAlignmentX(Component.CENTER_ALIGNMENT);
            entDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            entDate.setAlignmentX(Component.CENTER_ALIGNMENT);
            payOptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            payOpt.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "newRequestPanel");
                }
            });

            this.add(panelTitle);
            this.add(enterLabel);
            this.add(perForLeaLabel);
            this.add(perForLea);
            this.add(houPrefLabel);
            this.add(houOpt1);
            this.add(houOpt2);
            this.add(houOpt3);
            this.add(entDateLabel);
            this.add(entDate);
            this.add(payOptLabel);
            this.add(payOpt);
            this.add(submitButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class TerLeaReqPanel extends JPanel {
        private JLabel panelTitle = new JLabel("Terminate lease request");
        private JLabel enterLabel = new JLabel("Enter following details:");
        private JLabel leavDateLabel = new JLabel("The date you want to leave");
        private JTextField leavDate = new JTextField();
        private JLabel terReasLabel = new JLabel("Reason for termination");
        private JTextField terReas = new JTextField();
        private JButton submitButton = new JButton("Submit");
        private JButton backButton = new JButton("Back");

        public TerLeaReqPanel() {
            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            enterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            leavDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            leavDate.setAlignmentX(Component.CENTER_ALIGNMENT);
            terReasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            terReas.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "newRequestPanel");
                }
            });

            this.add(panelTitle);
            this.add(enterLabel);
            this.add(leavDateLabel);
            this.add(leavDate);
            this.add(terReasLabel);
            this.add(terReas);
            this.add(submitButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class VorCRequestPanel extends JPanel {
        private JLabel vcReqLabel;
        private JButton vReqButton;
        private JButton cReqButton;
        private JButton backButton;

        public VorCRequestPanel() {
            vcReqLabel = new JLabel("View/Cancel request");
            vReqButton = new JButton("View request");
            cReqButton = new JButton("Cancel request");
            backButton = new JButton("Back");

            vcReqLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            vReqButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cReqButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            vReqButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "lViewReqPanel");

                }
            });

            cReqButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "lCancReqPanel");
                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "housOptionPanel");
                }
            });

            this.add(vcReqLabel);
            this.add(vReqButton);
            this.add(cReqButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class LViewReqPanel extends JPanel {
        private JLabel panelTitle = new JLabel("View Request");
        private JButton backButton = new JButton("Back");

        public LViewReqPanel() {
            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "vorCRequestPanel");
                }
            });

            this.add(panelTitle);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class LCancReqPanel extends JPanel {
        private JLabel panelTitle = new JLabel("Cancel Request");
        private JLabel reqNumLabel = new JLabel("Enter the request number to cancle");
        private JTextField reqNum = new JTextField();
        private JButton submitButton = new JButton("Submit");
        private JButton backButton = new JButton("Back");

        public LCancReqPanel() {
            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            reqNumLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            reqNum.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "vorCRequestPanel");
                }
            });

            this.add(panelTitle);
            this.add(reqNumLabel);
            this.add(reqNum);
            this.add(submitButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class ViewVacancyPanel extends JPanel {
        private JLabel vVacaLabel;
        private JButton backButton;

        public ViewVacancyPanel() {
            vVacaLabel = new JLabel("View Vacancy");
            backButton = new JButton("Back");

            vVacaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "housOptionPanel");
                }
            });

            this.add(vVacaLabel);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

    }


    //ParkOptionPanel and subpanels
    public class ParkOptionPanel extends JPanel {
        private JLabel parkOptLabel;
        private JButton reqNewParkSpotButton;
        private JButton vParkInfoButton;
        private JButton vCurParkSpotButton;
        private JButton renParkSpotButton;
        private JButton retParkSpotButton;
        private JButton vReqStatusButton;
        private JButton backButton;

        public ParkOptionPanel() {
            parkOptLabel = new JLabel("Parking Option");
            reqNewParkSpotButton = new JButton("Request new parking spot");
            vParkInfoButton = new JButton("View parking lot information");
            vCurParkSpotButton = new JButton("View current parking spot");
            renParkSpotButton = new JButton("Renew parking spot");
            retParkSpotButton = new JButton("Return parking spot");
            vReqStatusButton = new JButton("View request status");
            backButton = new JButton("Back");

            parkOptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            reqNewParkSpotButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vParkInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vCurParkSpotButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            renParkSpotButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            retParkSpotButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vReqStatusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            reqNewParkSpotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "reqNewPanel");

                }
            });

            vParkInfoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "vParkInfoPanel");

                }
            });

            vCurParkSpotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "vCurParkPanel");

                }
            });

            renParkSpotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "reParkPanel");

                }
            });

            retParkSpotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "reParkPanel");

                }
            });

            vReqStatusButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "vReqPanel");

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "stuMainPanel");
                }
            });

            this.add(parkOptLabel);
            this.add(reqNewParkSpotButton);
            this.add(vParkInfoButton);
            this.add(vCurParkSpotButton);
            this.add(reqNewParkSpotButton);
            this.add(retParkSpotButton);
            this.add(vReqStatusButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        }

    }

    public class ReqNewPanel extends JPanel {
        private JLabel panelTitle;
        private JLabel vecTypeLabel;
        private JRadioButton bike = new JRadioButton("Bike");
        private JRadioButton handicapped = new JRadioButton("Handicapped");
        private JRadioButton compactCar = new JRadioButton("CompactCar");
        private JRadioButton lrgCar = new JRadioButton("LargeCar");
        private ButtonGroup vecType = new ButtonGroup();
        private JLabel nearSpotLabel;
        private ButtonGroup nearbySpot = new ButtonGroup();
        private JRadioButton yesButton = new JRadioButton("yes");
        private JRadioButton noButton = new JRadioButton("no");
        private JButton submitButton;
        private JButton backButton;

        public ReqNewPanel() {
            panelTitle = new JLabel("Request new parking spot, enter following details");
            vecTypeLabel = new JLabel("Vehicle type");
            nearSpotLabel = new JLabel("Nearby Spot?");
            submitButton = new JButton("Submit");
            backButton = new JButton("Back");

            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            vecTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            nearSpotLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String type = "";
                    String nearby = "";
                    for (Enumeration<AbstractButton> buttons = vecType.getElements(); buttons.hasMoreElements(); ) {
                        AbstractButton button = buttons.nextElement();
                        if (button.isSelected()) {
                            type = button.getText();
                            System.out.println("The type selected is: " + type);
                        }
                    }

                    for (Enumeration<AbstractButton> buttons = nearbySpot.getElements(); buttons.hasMoreElements(); ) {
                        AbstractButton button = buttons.nextElement();
                        if (button.isSelected()) {
                            type = button.getText();
                            System.out.println("The nearbySpot selected is: " + type);
                        }
                    }
                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "parkOptionPanel");
                }
            });

            vecType.add(bike);
            vecType.add(compactCar);
            vecType.add(lrgCar);
            vecType.add(handicapped);
            bike.setSelected(true);
            nearbySpot.add(yesButton);
            nearbySpot.add(noButton);
            yesButton.setSelected(true);
            this.add(panelTitle);
            this.add(vecTypeLabel);
            this.add(bike);
            this.add(compactCar);
            this.add(lrgCar);
            this.add(handicapped);
            this.add(nearSpotLabel);
            this.add(yesButton);
            this.add(noButton);
            this.add(submitButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class VParkInfoPanel extends JPanel {
        private JLabel panelTitle = new JLabel("View parking lot information");
        private JButton viewButton = new JButton("View");
        private JButton backButton = new JButton("Back");

        private JTable parkInfoTable = new JTable();
        private Vector<String> parkInfo = new Vector<String>();
        private Vector<Vector<String>> data = new Vector<Vector<String>>();


        public VParkInfoPanel() {
            parkInfo.add("Spot#");
            parkInfo.add("Lot#");
            parkInfo.add("MonthlyFees");
            parkInfo.add("Type");


            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            viewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    DefaultTableModel model = new DefaultTableModel(data, parkInfo);
                    model.setRowCount(0);

                    try {
                        SqlConnector vparinfo = new SqlConnector();

                        String vParkSql = "SELECT SpotNo, LotNo, MonthlyFees, Type FROM ParkingOpt WHERE Occupant is NULL ";

                        ResultSet rs = vparinfo.getStmt().executeQuery(vParkSql);

                        float mFee = 0;

                        while (rs.next()) {
                            Vector<String> bufString = new Vector<String>();

                            bufString.add(rs.getString("SpotNo"));

                            bufString.add(rs.getString("LotNo"));

                            mFee = rs.getFloat("MonthlyFees");
                            bufString.add(Float.toString(mFee));

                            bufString.add(rs.getString("Type"));

                            data.add(bufString);
                        }

                        vparinfo.getStmt().close();

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    model = new DefaultTableModel(data, parkInfo);
                    parkInfoTable.setModel(model);
                    parkInfoTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
                    parkInfoTable.setFillsViewportHeight(true);
                }
            });


            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "parkOptionPanel");
                }
            });

            this.add(panelTitle);
            this.add(new JScrollPane(parkInfoTable));
            this.add(viewButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }
    }

    public class VCurParkPanel extends JPanel {
        private JLabel panelTitle;
        private JButton backButton;

        public VCurParkPanel() {
            panelTitle = new JLabel("View current parking spot");
            backButton = new JButton("Back");

            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "parkOptionPanel");
                }
            });

            this.add(panelTitle);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }
    }

    ////Renew or Returen parking spot
    public class ReParkPanel extends JPanel {
        private JLabel panelTitle;
        private JLabel entPIDLabel;
        private JTextField enterParkID;
        private JButton renewButton;
        private JButton returnButton;
        private JButton backButton;

        public ReParkPanel() {
            panelTitle = new JLabel("Return/Renew parking spot");
            entPIDLabel = new JLabel("1. Enter parking spot ID");
            enterParkID = new JTextField();
            renewButton = new JButton("Renew");
            returnButton = new JButton("Return");
            backButton = new JButton("Back");

            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            entPIDLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            enterParkID.setAlignmentX(Component.CENTER_ALIGNMENT);
            renewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            renewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            returnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "parkOptionPanel");
                }
            });

            this.add(panelTitle);
            this.add(entPIDLabel);
            this.add(enterParkID);
            this.add(renewButton);
            this.add(returnButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }
    }

    public class VReqPanel extends JPanel {
        private JLabel panelTitle;
        private JButton backButton;

        public VReqPanel() {
            panelTitle = new JLabel("View request status");
            backButton = new JButton("Back");

            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "parkOptionPanel");
                }
            });

            this.add(panelTitle);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        }

    }

    //maintPanel series
    public class MaintPanel extends JPanel {
        private JLabel maintLabel;
        private JButton newTicketButton;
        private JButton vTicketStatusButton;
        private JButton backButton;

        public MaintPanel() {
            maintLabel = new JLabel("Maintenance");
            newTicketButton = new JButton("New Ticket");
            vTicketStatusButton = new JButton("View Ticket Status");
            backButton = new JButton("Back");

            maintLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            newTicketButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vTicketStatusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            newTicketButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            vTicketStatusButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "stuMainPanel");

                }
            });

            this.add(maintLabel);
            this.add(newTicketButton);
            this.add(vTicketStatusButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

    }

    public class NTickPanel extends JPanel {
        private JLabel panelTitle;
    }

    public class VTickStatPanel extends JPanel {
        private JLabel panelTitle;
    }


    //profile series
    public class ProfPanel extends JPanel {
        private JLabel profLabel;
        private JButton viewProfButton;
        private JButton updateProfButton;
        private JButton backButton;

        public ProfPanel() {
            profLabel = new JLabel("Profile");
            viewProfButton = new JButton("View Profile");
            updateProfButton = new JButton("Update Profile");
            backButton = new JButton("Back");

            profLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            viewProfButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            updateProfButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            viewProfButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            updateProfButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "stuMainPanel");
                }
            });

            this.add(profLabel);
            this.add(viewProfButton);
            this.add(updateProfButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class VProfPanel extends JPanel {

    }

    public class UProfPanel extends JPanel {

    }

}





