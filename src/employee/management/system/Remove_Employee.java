package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove_Employee extends JFrame implements ActionListener {

    Choice choiceEMPID;

    JButton delete,back;
    Remove_Employee(){

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        add(label);

        choiceEMPID  = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empid"));
            }
        }
        catch(Exception E){

        }
        //name
        JLabel labelname = new JLabel("Name ");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelname);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,150,15);
        textName.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textName);
        //Phone
        JLabel labelphone = new JLabel("Phone ");
        labelphone.setBounds(50,150,100,15);
        labelphone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelphone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,150,15);
        textPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textPhone);
        //Email
        JLabel labelemail = new JLabel("Phone ");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelemail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,150,15);
        textEmail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textEmail);

        //Db    In this stage we can't change our text while select another response so, we use addItemListener
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empid = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //For changing with options
        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empid = '"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Button
        delete = new JButton("DELTE");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        //Button
        back = new JButton("BACK");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        add(back);

        //Image Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        //Image Icon
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(0,0,1120,630);
        add(imgg);

        //Basic Frame
        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back)){
            setVisible(false);
        }
        else if (e.getSource().equals(delete)) {
            try{
                Conn c = new Conn();
                String q = "delete from employee where empid = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee Deleted Sucessfully");
                setVisible(false);
                new Main_Class();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Remove_Employee();
    }
}
