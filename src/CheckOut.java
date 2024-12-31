import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class CheckOut extends JFrame implements ActionListener{
    JButton check,back;
    Choice ccustomer;
    JLabel lblroomnumber,lblcheckin;
    
    CheckOut(){

        getContentPane().setBackground(Color.white);
    
        JLabel text=new JLabel("CheckOut");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setForeground(Color.BLUE);
        text.setBounds(100,20,300,25);
        add(text);
    
        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(20,70,100,25);
        add(lblid);

        ccustomer =new Choice();
        
        ccustomer.setBounds(140,70,150,25);
        add(ccustomer);

        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(20,120,100,25);
        add(lblroom);
        
        lblroomnumber=new JLabel();
        lblroomnumber.setBounds(140,120,100,25);
        add(lblroomnumber);

        JLabel lblcheck=new JLabel("Check In");
        lblcheck.setBounds(20,170,100,25);
        add(lblcheck);
        
        JLabel lblcheckin=new JLabel();
        lblcheckin.setBounds(140,170,100,25);
        add(lblcheckin);

        JLabel lblchecko=new JLabel("Check Out");
        lblchecko.setBounds(20,220,100,25);
        add(lblchecko);

        Date date =new Date();
        
        JLabel lblcheckout=new JLabel(""+date);
        lblcheckout.setBounds(140,220,150,25);
        add(lblcheckout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,50,400,250);
        add(image);


        check =new JButton("Check");
        check.setBounds(50,290,100,30);
        check.addActionListener(this);
        check.setBackground(Color.black);
        check.setForeground(Color.black);
        add(check);

        back =new JButton("Back");
        back.setBounds(190,290,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

        try{
            conn cn=new conn();
            String Query="select * from customer";
           ResultSet rs= cn.s.executeQuery(Query);
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckin.setText(rs.getString("checkintime"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        setVisible(true);
        setBounds(300,200,800,400);
    }
    public void actionPerformed(ActionEvent ea){
        if(ea.getSource()==check){
        
            String query="delete from customer where number='"+ccustomer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnumber='"+lblroomnumber.getText()+"' ";
            try{
                conn cn=new conn();
                cn.s.executeUpdate(query);
                cn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Checkout Done");
                
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
