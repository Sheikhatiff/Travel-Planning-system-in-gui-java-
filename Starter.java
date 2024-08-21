
package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class Starter extends JFrame{
    
        JLabel admin, user;
        Icon ic2 = new ImageIcon(this.getClass().getResource("User.png"));
        Icon ic = new ImageIcon(this.getClass().getResource("Admin.png"));
        
    Starter()
    {
        this.setTitle("Journey");
        this.setSize(800, 500);
        this.getContentPane().setBackground(new Color(234,255,255));
        this.setLocation(420, 180);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        admin = new JLabel();
        admin.setIcon(ic);
        admin.setText("Admin");
        admin.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 25));
        admin.setHorizontalTextPosition(SwingConstants.CENTER);
        admin.setVerticalTextPosition(SwingConstants.BOTTOM);
        admin.setBounds(160, 180, ic.getIconWidth(), ic.getIconHeight() + 35);
        admin.addMouseListener(new EventHandler());
        this.add(admin);

        user = new JLabel();
        user.setIcon(ic2);
        user.setText("User");
        user.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 25));
        user.setHorizontalTextPosition(SwingConstants.CENTER);
        user.setVerticalTextPosition(SwingConstants.BOTTOM);
        user.setBounds(470, 180, ic.getIconWidth(), ic.getIconHeight() + 35);
        user.addMouseListener(new EventHandler());
        this.add(user);
        
        this.setVisible(true);
    }
    public class EventHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel click = (JLabel) e.getSource();
            String Apass="atifsheikh",input;
            if (click.getText().compareTo("Admin") == 0) {
                input = JOptionPane.showInputDialog("Enter Admin Password ");
                if(input.equals(Apass))
                {
                    new MainAdminFrame();
                    dispose();
                } 
                else{
                    JOptionPane.showMessageDialog(admin, "Password Incorrect");
                }
            }
            else if(click.getText().compareTo("User") == 0){
                new Login();
                dispose();
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
