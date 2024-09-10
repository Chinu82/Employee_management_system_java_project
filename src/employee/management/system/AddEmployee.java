package employee.management.system;

import com.sun.tools.javac.Main;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    //Random Number Generator
    Random ran = new Random();
    int number = ran.nextInt(999999);


    JButton add,back;

    JTextField tname,tfname,tadd,taddress,tphone,temail,tsalary,tdesignation,taadhar;
    JLabel empid;
    JDateChooser tdob;
    JComboBox BoxEducation;

    AddEmployee(){
        getContentPane().setBackground(new Color(163,255,183));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
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

        //DOB
        JLabel dateofbirth = new JLabel("Date Of Birth");
        dateofbirth.setBounds(50,200,150,30);
        dateofbirth.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dateofbirth);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
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
        education.setBounds(400,300,150,30);
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

        taadhar = new JTextField();
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

        //Button Add
        add = new JButton("ADD");
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
        if (e.getSource()==add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            double salary = Double.parseDouble(tsalary.getText());
            String address = taddress.getText();
            Long phone = Long.parseLong(tphone.getText());
            String email = temail.getText();
            String education = (String) BoxEducation.getSelectedItem();
            String designation = tdesignation.getText();
            String eId = empid.getText();
            Long adhar =Long.parseLong(taadhar.getText());

            // Database operation
            try{
//              Connection
                Conn con = new Conn();
//              store the value with write query in code
                String q = "insert into employee values ('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+adhar+"','"+eId+"')";
                con.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Added Sucessfully");
                setVisible(false);
                new Main_Class();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Main_Class();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
