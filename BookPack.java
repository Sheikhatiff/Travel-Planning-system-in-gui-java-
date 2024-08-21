
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
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

 public class BookPack extends JFrame
        {
         JTable table;
         DefaultTableModel tmod;
         JScrollPane sc;
         JLabel name,ppl,fare;
         JTextField Name, Ppl,Fare;
         JPanel p1,p2;
         JButton book,back,calfare;
         BookPack(String UName )
         {
            this.setSize(800,500);
            this.setTitle("Book Package");
            this.setLayout(null);
            this.setResizable(false);
            this.setLocation(500, 300);
            p1 = new JPanel();
            p1.setBounds(10,330,750,110);
            p1.setBackground(Color.lightGray);
            p1.setLayout(null);
         
            name = new JLabel("Username");
            name.setBounds(10, 15, 80, 30);
            name.setFont(new Font("Courier",Font.BOLD,15));
            p1.add(name);
            Name = new JTextField(UName);
            Name.setBounds(100,17,140,25);
            Name.setEditable(false);
            Name.setFont(new Font("Courier",Font.PLAIN,15));
            p1.add(Name);
            
            ppl = new JLabel("No of People");
            ppl.setBounds(250,15,110,30);
            ppl.setFont(new Font("Courier",Font.BOLD,15));
            p1.add(ppl);
            Ppl = new JTextField();
            Ppl.setBounds(370,17,80,25);
            Ppl.setHorizontalAlignment(SwingConstants.RIGHT);
            Ppl.setFont(new Font("Courier",Font.PLAIN,15));
            p1.add(Ppl);
            
            fare = new JLabel("Total Fare");
            fare.setBounds(460,15,110,30);
            fare.setFont(new Font("Courier",Font.BOLD,15));
            p1.add(fare);
            Fare = new JTextField();
            Fare.setBounds(580,17,150,25);
            Fare.setHorizontalAlignment(SwingConstants.RIGHT);
            Fare.setEditable(false);
            Fare.setFont(new Font("Courier",Font.PLAIN,18));
            Fare.setForeground(Color.red);
            p1.add(Fare);
            
            book = new JButton("Book");
            book.setBounds(340,60,130,35);
            book.setBackground(Color.darkGray);
            book.setForeground(Color.lightGray);
            book.setFont(new Font("Courier",Font.ITALIC,20));
            book.addActionListener(new EventHandler());
            p1.add(book);
            
            back = new JButton("Back");
            back.setBounds(520,60,130,35);
            back.setBackground(Color.darkGray);
            back.setForeground(Color.lightGray);
            back.setFont(new Font("Courier",Font.ITALIC,20));
            back.addActionListener(new EventHandler());
            p1.add(back);
            
            calfare = new JButton("Calculate Fare");
            calfare.setBounds(50,60,230,35);
            calfare.setBackground(Color.darkGray);
            calfare.setForeground(Color.lightGray);
            calfare.setFont(new Font("Courier",Font.ITALIC,20));
            calfare.addActionListener(new EventHandler());
            p1.add(calfare);
            
            this.add(p1);
            
            p2 = new JPanel();
            p2.setBounds(10,10,750,320);
            p2.setBackground(Color.black);
            p2.setLayout(null);
            
            String[][] data = {};
            String[] col = {"Package Name","Description","Expense"};
            tmod = new DefaultTableModel(data,col);
            readAndPopulateData();
            table = new JTable(tmod);
            sc = new JScrollPane(table);
            sc.setBounds(30,50,700,220);
            table.getTableHeader().setFont(new Font("Courier",Font.BOLD+Font.ITALIC,18));
            table.getTableHeader().setForeground(new Color(214,214,214));
            table.getTableHeader().setBackground(new Color(69,69,69));
            table.getTableHeader().setSize(420, 40);
            table.getTableHeader().setResizingAllowed(false);
            table.getTableHeader().setReorderingAllowed(false);
            table.setBackground(new Color (76,76,76));
            table.setFont(new Font("Courier",Font.ITALIC,15));
            table.setForeground(Color.white);
           
            p2.add(sc);
            
            this.add(p2);
            this.setVisible(true);
         }
        private void readAndPopulateData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("package.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                if (rowData.length == 3) {
                    tmod.addRow(rowData);
                }
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
        private void calculateFare() {
        try {
            int numberOfPeople = Integer.parseInt(Ppl.getText());
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {
                String expenseStr = (String) table.getValueAt(selectedRow, 2);
                double expense = Double.parseDouble(expenseStr);
                double totalFare = expense * numberOfPeople;
                Fare.setText(String.format("%.2f", totalFare));
            } else {
                JOptionPane.showMessageDialog(table, "Please select a package from the table.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(table, "Please enter a valid number of people.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bookPackage() {
        String userName = Name.getText();
        int numberOfPeople = Integer.parseInt(Ppl.getText());
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            String packageName = (String) table.getValueAt(selectedRow, 0);
            String packageDescription = (String) table.getValueAt(selectedRow, 1);
            String expenseStr = (String) table.getValueAt(selectedRow, 2);
            double expense = Double.parseDouble(expenseStr);
            double totalFare = expense * numberOfPeople;

            String fileName = userName + ".txt";
            File file = new File(fileName);

            if (file.exists()) {
                JOptionPane.showMessageDialog(table, "You can't book two packages at a time.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write("Username: " + userName + "\n");
                    writer.write("Package Name: " + packageName + "\n");
                    writer.write("Package Description: " + packageDescription + "\n");
                    writer.write("Number of People: " + numberOfPeople + "\n");
                    writer.write("Total Fare: " + String.format("%.2f", totalFare) + "\n");
                    writer.close();
                    JOptionPane.showMessageDialog(table, "Package booked successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(table, "Error while booking the package.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(table, "Please select a package from the table.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


public class EventHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().compareTo("Calculate Fare")==0)
            {
                calculateFare();
            }
            
            else if(e.getActionCommand().compareTo("Book")==0)
            {
               bookPackage(); 
            }
            
            else if(e.getActionCommand().compareTo("Back")==0)
            {
                dispose();
            }
    }
}

 }
