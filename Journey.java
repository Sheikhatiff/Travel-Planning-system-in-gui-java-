
package journey;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Atif Sheikh
 */
public class Journey extends JFrame implements Runnable{
     Thread t;
     JLabel I;
     Icon ic = new ImageIcon(this.getClass().getResource("introd.jpg"));
    Journey()
    {
        //this.setSize(1500, 1000);
        this.setLocation(200, 20);
        this.setVisible(true);
        this.setTitle("Thumbnail");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        I= new JLabel();
        I.setIcon(ic);
        I.setBounds(0, 0, ic.getIconWidth(), ic.getIconHeight());
        this.add(I);
       t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        try{
            t.sleep(3000);
            
            new Starter();
            this.dispose();
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }    
    public static void main(String[] args) {
           Journey frm = new Journey(); 
           int x=1;
           for(int i =1; i<=500; x+=8,i++)
           {
               i+=3;
               frm.setLocation(520-(x+1)/2,250-(i/2));
               frm.setSize(x+i,(i+x*3)/4);
               
           }
           try{
               Thread.sleep(4000);
           }catch(Exception ex){}
    }

    
}
