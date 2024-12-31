import javax.print.DocFlavor.STRING;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addemployee extends JFrame implements ActionListener{

        JTextField tfname,tfpho,tfsal,tfage,tfem,tfaadhar;
        JLabel lbname,lbage,lbsal,lbem,lbgender,lbpho,lbjob,lbaadhar;
        JRadioButton rbmale,rbfemale;
        JComboBox cbjob;
        JButton sub;


    Addemployee(){

        lbname=new JLabel("NAME");
        lbname.setBounds(60,30,120,30);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbname);

        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        lbage=new JLabel("AGE");
        lbage.setBounds(60,80,120,30);
        lbage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbage);

        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        lbgender=new JLabel("GENDER");
        lbgender.setBounds(60,130,120,30);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbgender);

        rbmale =new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale =new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        lbjob=new JLabel("JOB");
        lbjob.setBounds(60,180,120,30);
        lbjob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbjob);

        String str[]={"Chefs","HouseKeeping","Clerks","Kitchen staff","Room service","Manager","Accountant","waiter/waitress"};
        cbjob =new JComboBox<>(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
       
       
        lbsal=new JLabel("SALARY");
        lbsal.setBounds(60,230,120,30);
        lbsal.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbsal);

        tfsal=new JTextField();
        tfsal.setBounds(200,230,150,30);
        add(tfsal);

        lbpho=new JLabel("PHONE");
        lbpho.setBounds(60,280,120,30);
        lbpho.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbpho);

        tfpho=new JTextField();
        tfpho.setBounds(200,280,150,30);
        add(tfpho);


        lbem=new JLabel("EMAIL");
        lbem.setBounds(60,330,120,30);
        lbem.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbem);

        tfem=new JTextField();
        tfem.setBounds(200,330,150,30);
        add(tfem);


        sub =new JButton("SUBMIT");
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.black);
        sub.addActionListener(this);
        sub.setBounds(200,430,150,30);
        add(sub);
        
        ImageIcon I1= new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 =I1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel jl =new JLabel(i3);
        jl.setBounds(380,60,450,370);
        add(jl);


        
        lbaadhar=new JLabel("AADHAR");
        lbaadhar.setBounds(60,380,120,30);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbaadhar);

        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

        ButtonGroup bg =new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);


        setLayout(null);
        setBounds(320,200,850,540);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String name=tfname.getText();
        String salary=tfsal.getText();
        String phone=tfpho.getText();
        String email=tfem.getText();
        String aadhar=tfaadhar.getText();
        String age=tfage.getText();
        String job=(String)cbjob.getSelectedItem();

        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"name should not empty");
            setVisible(false);
            return;
        }

        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        
        }else if(rbfemale.isSelected()){
            gender="female";
        }

        try{
            conn cn =new conn();
            String Query="insert into Employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')"; 

            cn.s.executeUpdate(Query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
        }
        catch(Exception ea){
            ea.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Addemployee();
    }
}
