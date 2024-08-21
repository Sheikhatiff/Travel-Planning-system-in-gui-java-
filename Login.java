
package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
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


public class Login extends JFrame{
   Icon ic = new ImageIcon(this.getClass().getResource("log (1).jpg"));
   JPanel p1,p2;
   JLabel I,U,P,E;
   JTextField tx;
   JPasswordField ps;
   JButton login,signup,fpass;
    Login()
    {
        this.setSize(800,500);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 200);
        this.setLayout(null);
        this.setResizable(false);
        
        p1 = new JPanel();
        p1.setBackground(new Color(134,251,187));
        p1.setBounds(400, 0, 399, 500);
        p1.setLayout(null);
        I= new JLabel();
        I.setIcon(ic);
        I.setBounds(0, 0, ic.getIconWidth(), ic.getIconHeight());
        p1.add(I);
        this.add(p1);
        
        p2 = new JPanel();
        p2.setBackground(new Color(244,255,255));
        p2.setBounds(0, 10, 400, 410);
        p2.setLayout(null);
        U = new JLabel("User name");
        U.setFont(new Font("Courier",Font.BOLD,20));
        U.setBounds(140,60,110,40);
        U.setForeground(Color.black);
        p2.add(U);
        P = new JLabel("Password");
        P.setFont(new Font("Courier",Font.BOLD,20));
        P.setBounds(140,160,110,40);
        P.setForeground(Color.black);
        p2.add(P);
        E = new JLabel("");
        E.setForeground(Color.red);
        p2.add(E);
        tx = new JTextField();
        tx.setBounds(70,110,240,40);
        tx.setFont(new Font("Courier",Font.PLAIN,15));
        p2.add(tx);
        ps = new JPasswordField();
        ps.setBounds(70,210,240,40);
        ps.setFont(new Font("Courier",Font.PLAIN,15));
        p2.add(ps);
        login = new JButton();
        login.setText("Log In");
        login.setBounds(70,280,240,40);
        login.setFont(new Font("Courier",Font.BOLD,18));
        login.setForeground(Color.darkGray);
        login.setBackground(new Color(194,255,255));
        login.addActionListener(new EventHandler());
        p2.add(login);
        signup = new JButton();
        signup.setText("Sign up");
        signup.setBounds(40,340,130,40);
        signup.setFont(new Font("Courier",Font.BOLD,18));
        signup.setForeground(Color.darkGray);
        signup.setBackground(new Color(194,255,255));
        signup.addActionListener(new EventHandler());
        p2.add(signup);
        fpass = new JButton();
        fpass.setText("Forget Pass");
        fpass.setBounds(180,340,170,40);
        fpass.setFont(new Font("Courier",Font.BOLD,16));
        fpass.setForeground(Color.darkGray);
        fpass.setBackground(new Color(194,255,255));
        fpass.addActionListener(new EventHandler());
        p2.add(fpass);
        this.add(p2);
        
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }
    
    /*public static void main(String[] args)
    {
     new Login(); 
        
    }*/
    
    public class EventHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            if(e.getActionCommand().compareTo("Sign up")==0)
            {
                E.setText("");
                new Signup();
                dispose();
            }
            else
              if(e.getActionCommand().compareTo("Log In")==0)
            {
               if (tx.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(p2, "Username can't be empty!");
                    return;}
                FileReader f = new FileReader("Data.txt");
                Scanner in = new Scanner(f);
                while(in.hasNext())
                {
                    String st = in.nextLine();
                    String[] unm = st.split(",");
                    if (tx.getText().compareTo(unm[0])==0)
                    {
                        E.setText("");
                        String Password = new String(ps.getPassword());
                        if(Password.compareTo(unm[2])==0)
                        {
                            
                            new MainUserFrame(unm[1] + "!");
                            f.close();
                            dispose(); 
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(ps, "Invalid Password ");
                            return;
                        }
                    }
                    /*else
                    {
                        //E.setText("Invalid Username");
                        //E.setBounds(120,55,200,40);
                        JOptionPane.showMessageDialog(ps, "Invalid username ");
                      
                      return;
                    }*/
                    f.close();
                }   
            }
            else
               if(e.getActionCommand().compareTo("Forget Pass")==0)
                {
                FileReader f = new FileReader("Data.txt");
                Scanner in = new Scanner(f);
                while(in.hasNext())
                {
                    String st = in.nextLine();
                    String[] unm = st.split(",");
                    if (tx.getText().compareTo(unm[0])==0)
                    {
                        new Signup(unm[0],unm[1]);
                        dispose();
                    }
                    else
                    {
                        E.setText("This user is not registered ");
                        E.setBounds(120,35,200,40);
                    }
                    f.close();
                }
            }
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
      
    }
  } 
}
