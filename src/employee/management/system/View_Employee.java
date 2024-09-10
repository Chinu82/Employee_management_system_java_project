package employee.management.system;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import net.proteanit.sql.DbUtils;

import javax.naming.directory.SearchControls;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {

    Choice choiceEmp;
    JTable table;
    JButton searchBtn, print, back, update;

    View_Employee(){
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by employee ID");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEmp = new Choice();
        choiceEmp.setBounds(180,20,150,20);
        add(choiceEmp);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEmp.add(resultSet.getString("empid"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
//            DbUtils is only for Data shows in the table format
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        //Button for Search
        searchBtn = new JButton("search");
        searchBtn.addActionListener(this);
        searchBtn.setBounds(20,70,80,20);
        add(searchBtn);

        print = new JButton("print");
        print.addActionListener(this);
        print.setBounds(120,70,80,20);
        add(print);

        update = new JButton("update");
        update.addActionListener(this);
        update.setBounds(220,70,80,20);
        add(update);

        back = new JButton("back");
        back.addActionListener(this);
        back.setBounds(320,70,80,20);
        add(back);




        //Basic Frame
        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchBtn)){
            String query = "select * from employee where empId = '"+choiceEmp.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource().equals(print)) {
            try{
//                print() is predefined function to print the table
                table.print();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource() == update){
            new UpdateEmployee(choiceEmp.getSelectedItem());
        } else if (e.getSource().equals(back)) {
            setVisible(false);
            new Main_Class();
        }

    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
