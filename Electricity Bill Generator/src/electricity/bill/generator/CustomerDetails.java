
package electricity.bill.generator;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
//net.proteanit.sql - this is pkg name.
//DbUtils - this is class name.
// All about pkg is creating a Table

public class CustomerDetails extends JFrame implements ActionListener{
    
    Choice meternumber, cmonth;
    JTable table;
    JButton print;
    
    CustomerDetails(){
        super("Customer Details");
        
        setSize(1200, 640);
        setLocation(120, 50);
       
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        print = new JButton("Print");     
        print.addActionListener(this);
        add(print, "South");
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new CustomerDetails();
    }
}