package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About extends JFrame {
    JTextArea txt;
    JPanel p1;
    JScrollPane sc;
    JButton backButton;

    About() {
        this.setSize(800, 500);
        this.setTitle("ABOUT");
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(500, 300);
        p1 = new JPanel();
        p1.setBounds(20, 20, 750, 450);
        p1.setBackground(Color.lightGray);
        p1.setLayout(null);

        txt = new JTextArea();
        txt.setEditable(false);
        txt.setFont(new Font("Arial", Font.PLAIN, 18));
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        txt.setText("\n\n\tJourney Travel Planner System\n\n" +
                "The Journey Travel Planner System is a user-friendly Java-based application developed by Atif Sheikh . The purpose of this application is to facilitate users with a convenient platform to manage / plan their travel packages. It offers two main classes: \"MainAdminFrame\" and \"MainUserFrame,\" each designed to serve specific functionalities.\n\n" +

                " Functionalities:\n\n" +

                " Login and Signup: The application features a secure login and signup system that allows users to create new accounts or log in with existing credentials.\n\n" +

                " Admin Dashboard: The \"MainAdminFrame\" class serves as the admin dashboard. It allows the admin to add and delete travel packages. The admin can effortlessly manage the package offerings through a user-friendly interface.\n\n" +

                " User Dashboard: The \"MainUserFrame\" class provides the user dashboard. Users can log in using their registered credentials and access the following functionalities:\n\n" +
                "  a. Book Package: Users can browse and book travel packages from a list of available options. The application ensures a smooth booking experience.\n" +
                "  b. View Booked Package: Users can view the details of their booked packages, including the package name, itinerary, and other relevant information.\n" +
                "  c. Delete Booked Package: Users have the option to delete their booked packages. The application prompts a confirmation dialogue to prevent accidental deletions.\n\n" +

                " Contact Information:\n\n" +

                " For any inquiries or assistance related to the Journey Travel Planner System, you can reach out to the developer, Atif Sheikh:\n\n" +
                "\tName: Atif Sheikh\n" +
                "\tEmail: atif55sheikh@gmail.com\n" +
                "\tPhone: +92 3163094030\n\n");

        sc = new JScrollPane(txt);
        sc.setBounds(20, 20, 700, 360);
        p1.add(sc);

        backButton = new JButton("Back");
        backButton.setBounds(300, 390, 150, 50);
        backButton.setBackground(Color.darkGray);
        backButton.setForeground(Color.lightGray);
        backButton.setFont(new Font("Courier", Font.ITALIC, 25));
        backButton.addActionListener(new EventHandler());
        p1.add(backButton);

        this.add(p1);
        this.setVisible(true);

    }

    public class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().compareTo("Back") == 0) {
                dispose();
            }
        }

    }
}
