import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Pickup  extends JFrame implements ActionListener{
    JTable t1;
    JButton back ,submit;
    Choice typeofcar;
    JComboBox bedtype;
    JCheckBox available;
    Pickup(){


        getContentPane().setBackground(Color.white);

        JLabel text=new JLabel("Pick Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed=new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        typeofcar =new Choice();
        try{
            conn cn=new conn();
            String Query="select * from Driver";
           ResultSet rs= cn.s.executeQuery(Query);
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        typeofcar.setBounds(150,100,150,25);
        add(typeofcar);


        t1 =new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);

        JLabel lb1 =new JLabel("Name");
        lb1.setBounds(30,160,100,20);
        add(lb1);
        
        JLabel lb2 =new JLabel("Age");
        lb2.setBounds(180,160,100,20);
        add(lb2);

        
        JLabel lb3=new JLabel("Gender");
        lb3.setBounds(330,160,100,20);
        add(lb3);


        
        JLabel lb4=new JLabel("Company");
        lb4.setBounds(480,160,100,20);
        add(lb4);

        
        JLabel lb5 =new JLabel("Model");
        lb5.setBounds(630,160,100,20);
        add(lb5);

        JLabel lb6 =new JLabel("Availability");
        lb6.setBounds(750,160,100,20);
        add(lb6);


        JLabel lb7 =new JLabel("Location");
        lb7.setBounds(900,160,100,20);
        add(lb7);


        submit = new JButton("Submit");
        submit.setBounds(300,500,120,30);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.black);
        add(submit);

        back = new JButton("Back");
        back.setBounds(500,500,120,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.black);
        add(back);

         try{
            conn cn =new conn();
            ResultSet rs =cn.s.executeQuery("select * from Drivers");
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }




        setBounds(300,200,1000,600);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query="select * from Driver where brand='"+typeofcar.getSelectedItem()+"'";
                
                conn cn = new conn();
                ResultSet rs;
                rs=cn.s.executeQuery(query);
                t1.setModel(DbUtils.resultSetToTableModel(rs));


            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String[] args) {
        new Pickup();
    }
}