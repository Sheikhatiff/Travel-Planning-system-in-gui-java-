
package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class MainAdminFrame extends JFrame {
    
    JPanel p1,p2;
    JLabel I,profile;
    JButton add,del,back;
    Icon ic = new ImageIcon(this.getClass().getResource("introductory.jpg"));
    MainAdminFrame()
    {
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Admin");
        this.setLayout(null);
        this.setResizable(false);
        
        p1= new JPanel();
        p1.setBounds(0, 0,480, 1080);
        p1.setBackground(Color.BLACK);
        p1.setLayout(null);
        
        profile = new JLabel();
        profile.setText("\n\n   ADMIN");
        profile.setFont(new Font("High Tower Text",Font.BOLD+Font.ITALIC,70));
        profile.setBounds(20,20,440,200);
        profile.setForeground(Color.red);
        profile.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        p1.add(profile);
        
        add = new JButton("Add & Del Package");
        add.setBounds(30,300,380,80);
        add.setBackground(Color.darkGray);
        add.setForeground(Color.lightGray);
        add.setFont(new Font("Courier",Font.ITALIC,30));
        add.addActionListener(new EventHandler());
        p1.add(add);
        
        back = new JButton("Back");
        back.setBounds(30,430,380,80);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.lightGray);
        back.setFont(new Font("Courier",Font.ITALIC,30));
        back.addActionListener(new EventHandler());
        p1.add(back);
            
        this.add(p1);
        
        p2 = new JPanel();
        p2.setBackground(new Color(134,251,187));
        p2.setBounds(480, 0,1440, 1080);
        p2.setLayout(null);
        I= new JLabel();
        I.setIcon(ic);
        I.setBounds(0, 0, ic.getIconWidth(), ic.getIconHeight());
        p2.add(I);
        this.add(p2);
        
        this.setVisible(true);
    }
    
    public class EventHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().compareTo("Add & Del Package")==0)
            {
                new AddPack();
            }
            
            else if(e.getActionCommand().compareTo("Back")==0)
            {
                dispose();
                new Starter();
            }
        }
        
    }
}
