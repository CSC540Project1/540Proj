import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by neil on 15/3/31.
 */
public class StudentFrame extends JFrame {
    private static int STUDENT_WIDTH = 400;
    private static int STUDENT_HEIGHT = 400;

    private JPanel stuCards;

    CardLayout stuCardLayout;

    public StudentFrame(String title) {
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
        ViewInvoicesPanel viewInvoicesPanel = new ViewInvoicesPanel();
        ViewLeasesPanel viewLeasesPanel = new ViewLeasesPanel();
        NewRequestPanel newRequestPanel = new NewRequestPanel();
        VorCRequestPanel vorCRequestPanel = new VorCRequestPanel();
        ViewVacancyPanel viewVacancyPanel = new ViewVacancyPanel();

        stuCards.add(viewInvoicesPanel, "viewInvoicesPanel");
        stuCards.add(viewLeasesPanel, "viewLeasePanel");
        stuCards.add(newRequestPanel, "newRequestPanel");
        stuCards.add(vorCRequestPanel, "vorCRequestPanel");
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

        public ViewInvoicesPanel() {
            vInvoLabel = new JLabel("View Invoices");
            vCurInvoButton = new JButton("View current invoice");
            vForInvoButton = new JButton("View former invoices");
            backButton = new JButton("Back");

            vInvoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            vCurInvoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            vForInvoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            vCurInvoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            vForInvoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stuCardLayout.show(stuCards, "housOptionPanel");
                }
            });

            this.add(vInvoLabel);
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

        public ViewLeasesPanel() {
            vLeaseLabel = new JLabel("View Lease");
            vCurLButton = new JButton("View current lease");
            vForLButton = new JButton("View former lease");
            backButton = new JButton("Back");

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

                }
            });

            tLeaReqButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

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

                }
            });

            cReqButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

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
        private JTextField vecType;
        private JLabel handiLabel;
        private JTextField handicapped;
        private JLabel nearSpotLabel;
        private JTextField nearbySpot;
        private JButton submitButton;
        private JButton backButton;

        public ReqNewPanel() {
            panelTitle = new JLabel("Request new parking spot/n Enter following details");
            vecTypeLabel = new JLabel("Vehicle type");
            vecType = new JTextField("Enter the vehicle type here");
            handiLabel = new JLabel("Handicapped?");
            handicapped = new JTextField();
            nearSpotLabel = new JLabel("Nearby Spot?");
            nearbySpot = new JTextField("");
            submitButton = new JButton("Submit");
            backButton = new JButton("Back");

            panelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            vecTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            vecType.setAlignmentX(Component.CENTER_ALIGNMENT);
            handiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            handicapped.setAlignmentX(Component.CENTER_ALIGNMENT);
            nearSpotLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            nearbySpot.setAlignmentX(Component.CENTER_ALIGNMENT);
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
                    stuCardLayout.show(stuCards, "parkOptionPanel");
                }
            });

            this.add(panelTitle);
            this.add(vecTypeLabel);
            this.add(vecType);
            this.add(handiLabel);
            this.add(handicapped);
            this.add(nearSpotLabel);
            this.add(nearbySpot);
            this.add(submitButton);
            this.add(backButton);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
    }

    public class VParkInfoPanel extends JPanel {
        private JLabel panelTitle;
        private JButton backButton;

        public VParkInfoPanel() {
            panelTitle = new JLabel("View parking lot information");
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





