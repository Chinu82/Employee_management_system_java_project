package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField tfname,tadd,taddress,tphone,temail,tsalary,tdesignation,taadhar;
    JLabel empid;
    JComboBox BoxEducation;
    JButton add,back;
    String number;

    UpdateEmployee(String number){
        getContentPane().setBackground(new Color(163,255,183));
        this.number = number;
        JLabel heading = new JLabel("Update Employee Details for : "+number);
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        //Father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel tdob = new JLabel();
        tdob.setBounds(50,20,150,30);
//        tdob.setBackground(new Color(177,252,197));
        tdob.setFont(new Font("Tahoma", Font.BOLD,20));

        add(tdob);

        //Salary
        JLabel sal = new JLabel("Salary");
        sal.setBounds(400,200,150,30);
        sal.setFont( new Font("SAN_SERIF",Font.BOLD,20));
        add(sal);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        //Address
        JLabel addre = new JLabel("Address");
        addre.setBounds(50,250,150,30);
        addre.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(addre);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        //Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        //Email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        //Education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,250,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        //Education Dropdown
        String items[] = {"BBA","BTech CS","BCA","BSC","BA","MCA","MBA","B COM","PHD"};
        BoxEducation = new JComboBox(items);
        BoxEducation.setBounds(600,300,150,30);
        BoxEducation.setBackground(new Color(177,252,197));
        add(BoxEducation);

        //AADhar
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(50,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(200,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        //Emp id
        JLabel eid = new JLabel("Employee Id");
        eid.setBounds(400,400,150,30);
        eid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(eid);

        empid = new JLabel(""+number);
        empid.setBounds(600,400,150,30);
        empid.setBackground(Color.BLACK);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        add(empid);

        //Designation
        JLabel des = new JLabel("Designation");
        des.setBounds(400,350,150,30);
        des.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(des);

        tdesignation = new JTextField();
        tdesignation.setBounds(600,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        //methode
        try {
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                BoxEducation.setSelectedItem(resultSet.getString("email"));
                taadhar.setText(resultSet.getString("addhar"));
                empid.setText(resultSet.getString("empid"));
                tdesignation.setText(resultSet.getString("designation"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Button Add
        add = new JButton("UPDATE");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        //Button Back
        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //Basic Frame
        setSize(900,700);
        setLocation(300,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back)){
            setVisible(false);
            new View_Employee();
        }
        else if (e.getSource().equals(add)){
            String fname = tfname.getText();
            double salary = Double.parseDouble(tsalary.getText());
            String address = taddress.getText();
            long phoneno = Long.parseLong(tphone.getText());
            String email = temail.getText();
            String education = BoxEducation.getSelectedItem().toString();
            String designation = tdesignation.getText();

            //store to database
            try{
                Conn c = new Conn();
                String q = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"',phone = '"+phoneno+"',email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empid = '"+number+"'";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Update Sucessfully");
                setVisible(false);
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}