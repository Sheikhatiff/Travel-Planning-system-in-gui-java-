
package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MainUserFrame extends JFrame {
    
    JPanel p1,p2;
    JLabel I,profile;
    JButton book,view,about,back;
    Icon ic = new ImageIcon(this.getClass().getResource("introductory.jpg"));
    private static String User;
    MainUserFrame(String title)
    {
        this.setUser(title);
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Welcome "+title);
        this.setLayout(null);
        this.setResizable(false);
        
        p1= new JPanel();
        p1.setBounds(0, 0,480, 1080);
        p1.setBackground(Color.BLACK);
        p1.setLayout(null);
        
        profile = new JLabel();
        profile.setText("\n "+title);
        profile.setFont(new Font("High Tower Text",Font.BOLD+Font.ITALIC,36));
        profile.setBounds(20,20,440,180);
        profile.setForeground(Color.red);
        profile.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        p1.add(profile);

        book = new JButton("  Book Package");
        book.setBounds(30,300,380,80);
        book.setBackground(Color.darkGray);
        book.setForeground(Color.lightGray);
        book.setFont(new Font("Courier",Font.ITALIC,30));
        book.addActionListener(new EventHandler());
        p1.add(book);
        
        view = new JButton("View Booked Package");
        view.setBounds(30,430,380,80);
        view.setBackground(Color.darkGray);
        view.setForeground(Color.lightGray);
        view.setFont(new Font("Courier",Font.ITALIC,28));
        view.addActionListener(new EventHandler());
        p1.add(view);
        
        about = new JButton(" About");
        about.setBounds(30,560,380,80);
        about.setBackground(Color.darkGray);
        about.setForeground(Color.lightGray);
        about.setFont(new Font("Courier",Font.ITALIC,30));
        about.addActionListener(new EventHandler());
        p1.add(about);
        
        back = new JButton("Back");
        back.setBounds(30,690,380,80);
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

    public String getUser() {
        return MainUserFrame.User;
    }

    public void setUser(String User) {
       MainUserFrame.User=User;
    }
    
    
    public class EventHandler extends JFrame implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().compareTo("  Book Package")==0)
            {
                new BookPack(MainUserFrame.User);
            }
            
            else if(e.getActionCommand().compareTo("View Booked Package")==0)
            {
             String z="\n";
             this.setSize(800,500);
             this.setTitle("Detail");
             this.setLayout(null);
             this.setResizable(false);
             this.setLocation(500, 300);
             p1 = new JPanel();
             p1.setBounds(20,20,750,420);
             p1.setBackground(Color.lightGray);
             p1.setLayout(null);
             JTextArea t = new JTextArea();
             String fn = MainUserFrame.User+".txt";
             try{
             File f = new File(fn);
             if(f.exists())
             {
                 FileReader fr = new FileReader(fn);
                 Scanner in = new Scanner(fr);
                 while(in.hasNext())
                 { 
                    String s = in.nextLine();
                    z = z+s+"\n";
                 }
                 t.setText(z);
                 t.setEditable(false);
                 fr.close();
                 t.setBounds(50,50,650,300);
             t.setFont(new Font("Courier",Font.ITALIC,32));
             p1.add(t);
            JButton deleteButton = new JButton("Delete");
            deleteButton.setBounds(300, 360, 150, 50);
            deleteButton.setBackground(Color.darkGray);
            deleteButton.setForeground(Color.lightGray);
            deleteButton.setFont(new Font("Courier", Font.ITALIC, 25));
            deleteButton.addActionListener(this);
            p1.add(deleteButton);

            this.add(p1);
            this.setVisible(true);
             this.add(p1);
             this.setVisible(true);
             }
             else
             {
                 JOptionPane.showMessageDialog(p1, "there is no package booked !", "Error", JOptionPane.ERROR_MESSAGE);
                 dispose();
             }
                 
                }catch(Exception ex)
                 {}  
             
            }
            
            else if(e.getActionCommand().compareTo(" About")==0)
            {
             new About();
            }
            
            else if (e.getActionCommand().compareTo("Delete") == 0) {
            int response = JOptionPane.showConfirmDialog(p1,
                    "Are you sure you want to delete the booked package?", "Confirm Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(p1, "Package deleted successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                File ff = new File(MainUserFrame.User+".txt");
                ff.delete();
            }
            }
            
            else if(e.getActionCommand().compareTo("Back")==0)
            {
                dispose();
                new Starter();
            }
            
        }
        
    }
}
