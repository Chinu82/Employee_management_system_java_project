package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;


    Login(){

        //Label for username
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        //Label for Password
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        //Button
        login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        //Button
        back = new JButton("Exit");
        back.setBounds(150,180,150,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        //Image Icon
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);


        //Image Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);


        //Basic Frame
        setSize(600,300);
        setLocation(450,200);
        setLayout(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            try{
                String username = tusername.getText();
                String password = tpassword.getText();

                Conn con = new Conn();

                String q = "select * from login where username = '"+username+"' and password = '"+password+"'";

                ResultSet resultSet = con.statement.executeQuery(q);

                if (resultSet.next()){
                    setVisible(false);
                    new Main_Class();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or, Password");
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else if( e.getSource() == back){
           System.exit(120);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
