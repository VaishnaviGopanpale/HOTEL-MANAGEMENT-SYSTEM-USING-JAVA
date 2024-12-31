import java.awt.*;

import java.awt.event.*;

import java.sql.*;
import java.util.Date;


import javax.swing.*;


public class AddCustomer extends JFrame implements ActionListener {
        JComboBox cbid;
        JTextField tfnumber,tfname,tfreservenumber ,tfdeposite,tfcountry;
        JRadioButton rmale,rfemale;
        JLabel checktime;
        Choice croom;
        JButton add,back;


    AddCustomer(){
        JLabel text=new JLabel("New Customer From");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Railway", Font.PLAIN,20));
        add(text);

        JLabel lblid=new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Railway", Font.PLAIN,20));
        add(lblid);

        String idoption[]={"Aaddhar Card","Passport","Driving license","Voter-id Card","Ration Card"};
        cbid =new JComboBox<>(idoption);
        cbid.setBounds(200,80,150,25);
        cbid.setBackground(Color.WHITE);
        add(cbid);

        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Railway", Font.PLAIN,20));
        add(lblnumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Railway", Font.PLAIN,20));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Railway", Font.PLAIN,20));
        add(lblgender);

        rmale=new JRadioButton("Male");
        rmale.setBounds(200,200,60,25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBounds(270,200,100,25);
        rfemale.setBackground(Color.white);
        add(rfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 240, 200, 20);
        lblCountry.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblCountry);
		
        tfcountry = new JTextField();
		tfcountry.setBounds(200, 240, 150, 25);
		add(tfcountry);
		tfcountry.setColumns(10);

        JLabel lblReserveRoomNumber = new JLabel("Room Number:");
		lblReserveRoomNumber.setBounds(35, 280, 160, 20);
        lblReserveRoomNumber.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblReserveRoomNumber);

        croom =new Choice();
        try{
            conn cn=new conn();
            String Query="select * from room where availability='available'";
           ResultSet rs= cn.s.executeQuery(Query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lblchecktimle = new JLabel("Check time");
		lblchecktimle.setBounds(35, 320, 160, 20);
        lblchecktimle.setFont(new Font("Railway", Font.PLAIN,20));
		add(lblchecktimle);

        Date date=new Date();

        checktime = new JLabel(""+ date);
		checktime.setBounds(200, 320, 160, 20);
        checktime.setFont(new Font("Railway", Font.PLAIN,16));
		add(checktime);

        JLabel lbldeposite = new JLabel("Deposite :");
		lbldeposite.setBounds(35, 360, 200, 20);
        lbldeposite.setFont(new Font("Railway", Font.PLAIN,20));
		add(lbldeposite);
		
        tfdeposite = new JTextField();
		tfdeposite.setBounds(200, 360, 150, 25);
		add(tfdeposite);

        add =new JButton("Add");
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add.setBackground(Color.black);
        add.setForeground(Color.black);
        add(add);

        back =new JButton("Back");
        back.setBounds(210,410,120,30);
        back.setBackground(Color.black);
        back.addActionListener(this);
        back.setForeground(Color.black);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
	

        setBounds(350,200,800,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
            String id=(String) cbid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String country =tfcountry.getText();
            String time=checktime.getText();
            String deposite=tfdeposite.getText();
            String checkr=croom.getSelectedItem();

               


            String gender=null;
            if(rmale.isSelected()){
                gender="Male";
            }else if(rfemale.isSelected()){
                gender="Female";
            }
            
            try{
                conn cn =new conn();
                String Query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+checkr+"','"+time+"','"+deposite+"')";
                String Query2="update room set availability='Occupide' where roomnumber ='"+checkr+"' ";
                cn.s.executeUpdate(Query);
                cn.s.executeUpdate(Query2);
                JOptionPane.showMessageDialog(null,"Customer added Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception ea){
                ea.printStackTrace();
            }
        }else if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
