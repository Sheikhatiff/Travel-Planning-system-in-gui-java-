



/*package semesterproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame{
    JLabel admin,user,label;
    Icon ic2 = new ImageIcon(this.getClass().getResource("User.png"));
    Icon ic = new ImageIcon(this.getClass().getResource("Admin.png"));
    public void Run()
    {
        admin = new JLabel();
        admin.setIcon(ic);
        admin.setText("Admin");
        admin.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,25));
        admin.setForeground(Color.white);
        admin.setHorizontalTextPosition(SwingConstants.CENTER);
        admin.setVerticalTextPosition(SwingConstants.BOTTOM);
        admin.setBounds(120, 240, ic.getIconWidth(), ic.getIconHeight()+35);
        admin.addMouseListener(new EventHandler());
        this.add(admin);
        
        user = new JLabel();
        user.setIcon(ic2);
        user.setText("User");
        user.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,25));
        user.setForeground(Color.WHITE);
        user.setHorizontalTextPosition(SwingConstants.CENTER);
        user.setVerticalTextPosition(SwingConstants.BOTTOM);
        user.setBounds(440, 240, ic.getIconWidth(), ic.getIconHeight()+35);
        user.addMouseListener(new EventHandler());
        this.add(user);
        
        
    }
    
    public void frmVis(Boolean c)
    {
        this.setTitle("Journey");
    this.setSize(700, 800);
    this.getContentPane().setBackground(new Color(135, 206, 235));
    this.setLocation(800, 180);
    this.setLayout(null);
    this.setDefaultCloseOperation(3);
        this.setVisible(c);
    }
    
    public class EventHandler implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            ActionFrame c = new ActionFrame();
            label = new JLabel();
        JLabel click = (JLabel)e.getSource();
            if(click.getText().compareTo("Admin")==0)
       {
                c.frmVisi(true);
                frmVis(false);
          // System.out.println("A");
       }
       else 
            {
                c.frmVisi(true);
                frmVis(false);
           //System.out.println("U");
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
        
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           
        }

        @Override
        public void mouseExited(MouseEvent e) {
          
        }
        
    }
}
*/



/*

package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
  
    
    JLabel admin, user;
    Icon ic2 = new ImageIcon(this.getClass().getResource("User.png"));
    Icon ic = new ImageIcon(this.getClass().getResource("Admin.png"));

    public void run() {
        admin = new JLabel();
        admin.setIcon(ic);
        admin.setText("Admin");
        admin.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 25));
        admin.setForeground(Color.white);
        admin.setHorizontalTextPosition(SwingConstants.CENTER);
        admin.setVerticalTextPosition(SwingConstants.BOTTOM);
        admin.setBounds(120, 240, ic.getIconWidth(), ic.getIconHeight() + 35);
        admin.addMouseListener(new EventHandler());
        this.add(admin);

        user = new JLabel();
        user.setIcon(ic2);
        user.setText("User");
        user.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 25));
        user.setForeground(Color.WHITE);
        user.setHorizontalTextPosition(SwingConstants.CENTER);
        user.setVerticalTextPosition(SwingConstants.BOTTOM);
        user.setBounds(440, 240, ic.getIconWidth(), ic.getIconHeight() + 35);
        user.addMouseListener(new EventHandler());
        this.add(user);
    }

    public void frmVis(boolean c) {
        this.setTitle("Journey");
        this.setSize(700, 800);
        this.getContentPane().setBackground(new Color(135, 206, 235));
        this.setLocation(800, 180);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(c);
    }
    

   public class EventHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            AdminFrame Admin = new AdminFrame();
            UserFrame User = new UserFrame();
            JLabel click = (JLabel) e.getSource();
            String Apass="journey", Upass = "journey",input;
            if (click.getText().compareTo("Admin") == 0) {
                input = JOptionPane.showInputDialog("Enter Admin Password ");
                if(input.equals(Apass))
                {
                    Admin.frmVis(true, MainFrame.this);
                    frmVis(false);
                } 
                else{
                    JOptionPane.showMessageDialog(admin, "Password Incorrect");
                }
            }
            else if(click.getText().compareTo("User") == 0){
                input = JOptionPane.showInputDialog("Enter User Password ");
                if(input.equals(Upass))
                {
                    User.frmVis(true, MainFrame.this);
                    frmVis(false);
                } 
                else{
                    JOptionPane.showMessageDialog(user, "Password Incorrect");
                }
            }
          }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}*/
