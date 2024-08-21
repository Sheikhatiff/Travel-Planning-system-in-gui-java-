
package journey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

 public class AddPack extends JFrame
        {
         JTable table;
         DefaultTableModel tmod;
         JScrollPane sc;
         JLabel name,ppl,price,descr;
         JTextField Name, Ppl, Price;
         JTextArea Descr;
         JPanel p1,p2;
         JButton add,back,del;
         AddPack()
         {
            this.setSize(800,500);
            this.setTitle("Add Package");
            this.setLayout(null);
            this.setResizable(false);
            this.setLocation(500, 300);
            p1 = new JPanel();
            p1.setBounds(10,10,290,480);
            p1.setBackground(Color.lightGray);
            p1.setLayout(null);
         
            name = new JLabel("Package Name");
            name.setBounds(30, 30, 200, 30);
            name.setFont(new Font("Courier",Font.BOLD,15));
            p1.add(name);
            Name = new JTextField();
            Name.setBounds(30,65,200,30);
            Name.setFont(new Font("Courier",Font.PLAIN,15));
            p1.add(Name);
            
            descr = new JLabel("Description");
            descr.setBounds(30, 95, 200, 30);
            descr.setFont(new Font("Courier",Font.BOLD,15));
            p1.add(descr);
            Descr = new JTextArea();
            Descr.setBounds(30,130,200,50);
            Descr.setFont(new Font("Courier",Font.PLAIN,15));
            p1.add(Descr);
            
            price = new JLabel("Price");
            price.setBounds(30, 185, 200, 30);
            price.setFont(new Font("Courier",Font.BOLD,15));
            p1.add(price);
            Price = new JTextField();
            Price.setBounds(30,220,200,30);
            Price.setFont(new Font("Courier",Font.PLAIN,15));
            p1.add(Price);
            
            add = new JButton("Add");
            add.setBounds(30,280,200,40);
            add.setBackground(Color.darkGray);
            add.setForeground(Color.lightGray);
            add.setFont(new Font("Courier",Font.ITALIC,22));
            add.addActionListener(new EventHandler());
            p1.add(add);
            
            back = new JButton("Back");
            back.setBounds(30,380,200,40);
            back.setBackground(Color.darkGray);
            back.setForeground(Color.lightGray);
            back.setFont(new Font("Courier",Font.ITALIC,22));
            back.addActionListener(new EventHandler());
            p1.add(back);
            
            del = new JButton("Delete");
            del.setBounds(30,330,200,40);
            del.setBackground(Color.darkGray);
            del.setForeground(Color.lightGray);
            del.setFont(new Font("Courier",Font.ITALIC,22));
            del.addActionListener(new EventHandler());
            p1.add(del);
            
            this.add(p1);
            
            p2 = new JPanel();
            p2.setBounds(300,10,500,480);
            p2.setBackground(Color.black);
            p2.setLayout(null);
            
            String[][] data = {};
            String[] col = {"Package Name","Description","Expense"};
            tmod = new DefaultTableModel(data,col);
            readAndPopulateData();
            table = new JTable(tmod);
            sc = new JScrollPane(table);
            sc.setBounds(40,60,420,300);
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

public class EventHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            String packageName = Name.getText().trim();
            String description = Descr.getText().trim();
            String priceText = Price.getText().trim();

            // Check if any field is empty
            if (packageName.isEmpty() || description.isEmpty() || priceText.isEmpty()) {
                JOptionPane.showMessageDialog(sc, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Check if price contains non-numeric characters
                try {
                    double priceValue = Double.parseDouble(priceText);

                    // Add data to JTable
                    Object[] rowData = {packageName, description, priceValue};
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(rowData);

                    // Save data to the file
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("package.txt", true));
                        writer.write(packageName + "," + description + "," + priceValue);
                        writer.newLine();
                        writer.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    // Clear input fields
                    Name.setText("");
                    Descr.setText("");
                    Price.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(sc, "Please enter a valid price (numeric value).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getActionCommand().equals("Back")) {
            dispose();
        }
        else if (e.getActionCommand().equals("Delete")) {
    if (table.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(table, "Invalid Selection", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        int selectedRowIndex = table.getSelectedRow();
        tmod.removeRow(selectedRowIndex);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("package.txt"))) {
            for (int i = 0; i < tmod.getRowCount(); i++) {
                String packageName = (String) tmod.getValueAt(i, 0);
                String description = (String) tmod.getValueAt(i, 1);
                Object rawValue = tmod.getValueAt(i, 2);
                double priceValue = 0.0;  // Default value or some appropriate default for your application

if (rawValue instanceof Double) 
    priceValue = (Double) rawValue;

                writer.write(packageName + "," + description + "," + priceValue);
                writer.newLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


           
        }
    }
}

