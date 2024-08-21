
package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Signup extends JFrame {
    JPanel p1,p2;
    JLabel un,n,q,a,p,x,I;
    JTextField Un,N,Q,A;
    JPasswordField P;
    JButton c,b;
    Icon ic = new ImageIcon(this.getClass().getResource("sign.png"));
    Icon ic2 = new ImageIcon(this.getClass().getResource("forg.jpeg"));
    Signup()
    {
        this.setSize(800,500);
        this.setTitle("Signup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 200);
        this.setLayout(null);
        
        p1 = new JPanel();
        p1.setBackground(new Color(244,255,255));
        p1.setBounds(0, 0, 415, 500);
        p1.setLayout(null);
        un = new JLabel("Username");
        un.setFont(new Font("Courier",Font.BOLD,18));
        un.setBounds(10,40,140,50);
        p1.add(un);
        n = new JLabel("Name");
        n.setFont(new Font("Courier",Font.BOLD,18));
        n.setBounds(10,100,160,50);
        p1.add(n);
        p = new JLabel("Password");
        p.setFont(new Font("Courier",Font.BOLD,18));
        p.setBounds(10,160,160,50);
        p1.add(p);
        q = new JLabel("Security Question");
        q.setFont(new Font("Courier",Font.BOLD,15));
        q.setBounds(10,220,170,50);
        p1.add(q);
        a = new JLabel("Answer");
        a.setFont(new Font("Courier",Font.BOLD,18));
        a.setBounds(10,280,160,50);
        p1.add(a);
        Un = new JTextField();
        Un.setFont(new Font("Courier",Font.PLAIN,16));
        Un.setBounds(200,45,200,40);
        p1.add(Un);
        N = new JTextField();
        N.setFont(new Font("Courier",Font.PLAIN,16));
        N.setBounds(200,105,200,40);
        p1.add(N);
        P = new JPasswordField();
        P.setFont(new Font("Courier",Font.PLAIN,16));
        P.setBounds(200,165,200,40);
        p1.add(P);
        Q = new JTextField("Which year do you miss most?");
        Q.setFont(new Font("Courier",Font.PLAIN,12));
        Q.setBounds(200,225,200,40);
        Q.setEditable(false);
        p1.add(Q);
        A = new JTextField();
        A.setFont(new Font("Courier",Font.PLAIN,16));
        A.setBounds(200,285,200,40);
        p1.add(A);
        
        c = new JButton("Create");
        c.setBounds(60,350,140,40);
        c.setFont(new Font("Courier",Font.BOLD,18));
        c.setForeground(Color.BLUE);
        c.setBackground(new Color(194,255,255));
        c.addActionListener(new EventHandler());
        p1.add(c);
        b = new JButton("Back");
        b.setBounds(240,350,140,40);
        b.setFont(new Font("Courier",Font.BOLD,18));
        b.setForeground(Color.BLUE);
        b.setBackground(new Color(194,255,255));
        b.addActionListener(new EventHandler());
        p1.add(b);
        this.add(p1);
        
        p2 = new JPanel();
        p2.setBackground(Color.white);
        p2.setBounds(415, 20, 385, 410);
        p2.setLayout(null);
        I= new JLabel();
        I.setIcon(ic);
        I.setBounds(20, 50, ic.getIconWidth(), ic.getIconHeight());
        p2.add(I);
        
        this.add(p2);

        
        this.setVisible(true);
    }
    
     Signup(String username,String name)
       {
        this.setSize(800,500);
        this.setTitle("Signup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 200);
        this.setLayout(null);
        this.setResizable(false);
        
        p1 = new JPanel();
        p1.setBackground(new Color(244,255,255));
        p1.setBounds(0, 0, 415, 500);
        p1.setLayout(null);
        x= new JLabel("");
        x.setForeground(Color.red);
        x.setText("*fist give correct answer of security question,then set Password.");
        x.setBounds(35,10,350,40);
        p1.add(x);
        un = new JLabel("Username");
        un.setFont(new Font("Courier",Font.BOLD,18));
        un.setBounds(10,40,140,50);
        p1.add(un);
        n = new JLabel("Name");
        n.setFont(new Font("Courier",Font.BOLD,18));
        n.setBounds(10,100,160,50);
        p1.add(n);
        p = new JLabel("Password");
        p.setFont(new Font("Courier",Font.BOLD,18));
        p.setBounds(10,160,160,50);
        p1.add(p);
        q = new JLabel("Security Question");
        q.setFont(new Font("Courier",Font.BOLD,15));
        q.setBounds(10,220,170,50);
        p1.add(q);
        a = new JLabel("Answer");
        a.setFont(new Font("Courier",Font.BOLD,18));
        a.setBounds(10,280,160,50);
        p1.add(a);
        Un = new JTextField();
        Un.setText(username);
        Un.setFont(new Font("Courier",Font.PLAIN,16));
        Un.setBounds(200,45,200,40);
        Un.setEditable(false);
        p1.add(Un);
        N = new JTextField();
        N.setText(name);
        N.setFont(new Font("Courier",Font.PLAIN,16));
        N.setBounds(200,105,200,40);
        N.setEditable(false);
        p1.add(N);
        P = new JPasswordField();
        P.setFont(new Font("Courier",Font.PLAIN,16));
        P.setBounds(200,165,200,40);
        p1.add(P);
        Q = new JTextField("Which year do you miss most?");
        Q.setFont(new Font("Courier",Font.PLAIN,12));
        Q.setBounds(200,225,200,40);
        Q.setEditable(false);
        p1.add(Q);
        A = new JTextField();
        A.setFont(new Font("Courier",Font.PLAIN,16));
        A.setBounds(200,285,200,40);
        p1.add(A);
        c = new JButton("Update Pass");
        c.setBounds(40,350,165,40);
        c.setFont(new Font("Courier",Font.BOLD,18));
        c.setForeground(Color.darkGray);
        c.setBackground(new Color(194,255,255));
        c.addActionListener(new EventHandler());
        p1.add(c);
        b = new JButton("Back");
        b.setBounds(240,350,140,40);
        b.setFont(new Font("Courier",Font.BOLD,18));
        b.setForeground(Color.darkGray);
        b.setBackground(new Color(194,255,255));
        b.addActionListener(new EventHandler());
        p1.add(b);
        this.add(p1);
        
        p2 = new JPanel();
        p2.setBackground(Color.white);
        p2.setBounds(415, 20, 385, 410);
        p2.setLayout(null);
        I= new JLabel();
        I.setIcon(ic2);
        I.setBounds(20, 50, ic.getIconWidth(), ic.getIconHeight());
        p2.add(I);
        
        this.add(p2);

        
        this.setVisible(true);
       }


    public class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<UserData> data = new ArrayList<UserData>();
                if(e.getActionCommand().compareTo("Create")==0)
            {
                //char[] pc = P.getPassword();
                String Password = new String(P.getPassword());
                UserData d = new UserData(Un.getText(),N.getText(),Password,A.getText());
                data.add(d);
                if (Un.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(p1, "Username can't be empty!");
                    return;}
                else if (N.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(p1, "Name can't be empty!");
                    return;}
                else if (Password.isEmpty()) {
                    JOptionPane.showMessageDialog(p1, "Password cannot be empty!");
                    return;}
                else if (A.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(p1, "Answer of Security Question can't be empty!");
                    return;}
                FileWriter fr = new FileWriter("Data.txt",true);
                FileReader f = new FileReader("Data.txt");
                Scanner in = new Scanner(f);
                while(in.hasNext())
                {
                    String s = in.nextLine();
                    String[] y = s.split(",");
                    if(Un.getText().compareTo(y[0])==0)
                    {
                        JOptionPane.showMessageDialog(p1, "this Username already regisered");
                        return;
                    }
                }
                fr.write(d.getUsername()+","+d.getName()+","+d.getPassword()+","+d.getAnswer()+"\n");
                JOptionPane.showMessageDialog(p1, "Account Registered");
                Un.setText("");
                N.setText("");
                A.setText("");
                P.setText("");
                fr.close();
                new Login();
                dispose();
            }
            else if(e.getActionCommand().compareTo("Back")==0)
            {
               
                new Login();
                dispose();
            }
            else if (e.getActionCommand().equals("Update Pass")) {
                    // First, check if the answer to the security question is correct

                    if (!isSecurityQuestionAnswerCorrect(A.getText())) {
                        JOptionPane.showMessageDialog(p1, "Incorrect Answer to the Security Question!");
                        return; // Don't proceed further if the answer is incorrect
                    }

                    // Next, check if the password field is empty
                    char[] newPasswordChars = P.getPassword();
                    String newPassword = new String(newPasswordChars).trim(); // Remove leading/trailing spaces
                    if (newPassword.isEmpty()) {
                        JOptionPane.showMessageDialog(p1, "Password cannot be empty!");
                        return; // Don't proceed further if the password is empty
                    }

                    // Read from Data.txt, update the password, and write to temp.txt
                    File inputFile = new File("Data.txt");
                    File tempFile = new File("temp.txt");

                    FileReader fr = new FileReader(inputFile);
                    BufferedReader br = new BufferedReader(fr);

                    FileWriter fw = new FileWriter(tempFile);
                    BufferedWriter bw = new BufferedWriter(fw);

                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] d = line.split(",");
                        if (Un.getText().equals(d[0])) {
                            bw.write(Un.getText() + "," + N.getText() + "," + newPassword + "," + A.getText());
                        } else {
                            bw.write(line);
                        }
                        bw.newLine();
                    }

                    br.close();
                    bw.close();

                    inputFile.delete();
                    tempFile.renameTo(new File("Data.txt"));

                    JOptionPane.showMessageDialog(p1, "Password Updated Successfully!");
                    new Login();
                    dispose();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage()); 
            }
        }

        private boolean isSecurityQuestionAnswerCorrect(String answer) throws Exception {
            FileReader fr = new FileReader("Data.txt");
            Scanner in = new Scanner(fr);
            while (in.hasNext()) {
                String st = in.nextLine();
                String[] unm = st.split(",");
                if (Un.getText().equals(unm[0])) {
                    if (answer.equals(unm[3])) {
                        fr.close();
                        return true;
                    }
                    break; 
                }
            }
            fr.close();
            return false;
        }
    }
}




