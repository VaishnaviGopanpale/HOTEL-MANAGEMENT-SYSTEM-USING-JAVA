import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updatecheck extends JFrame implements ActionListener {
    Choice  ccustomer;
    JButton check,update,back;
    JTextField tfroom,tfcheck,tfpending,tfpaid,tfname;
    Updatecheck(){

        JLabel text =new JLabel("Update Status");
        text.setFont(new Font("tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.red);
        add(text);

        JLabel lbid =new JLabel("Customer Id");
        lbid.setBounds(30,80,100,20);
        add(lbid);

        ccustomer =new Choice();
        try{
            conn cn=new conn();
            String Query="select * from customer";
           ResultSet rs= cn.s.executeQuery(Query);
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
       
        JLabel lbroom =new JLabel("Room Number");
        lbroom.setBounds(30,120,100,25);
        add(lbroom);

        tfroom =new JTextField();
        tfroom.setBounds(200,120,150,20);
        add(tfroom);

        JLabel lbname =new JLabel("Name");
        lbname.setBounds(30,160,100,25);
        add(lbname);

        tfname =new JTextField();
        tfname.setBounds(200,160,150,20);
        add(tfname);

        JLabel lbcheck =new JLabel("Checkin time");
        lbcheck.setBounds(30,200,100,25);
        add(lbcheck);

        tfcheck =new JTextField();
        tfcheck.setBounds(200,200,150,20);
        add(tfcheck);

        JLabel lbpaid =new JLabel("Amount Paid");
        lbpaid.setBounds(30,240,100,25);
        add(lbpaid);

        tfpaid =new JTextField();
        tfpaid.setBounds(200,240,150,20);
        add(tfpaid);

        JLabel lbpending =new JLabel("Amount Pending");
        lbpending.setBounds(30,280,100,25);
        add(lbpending);

        tfpending =new JTextField();
        tfpending.setBounds(200,280,150,20);
        add(tfpending);

        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.black);
        check.addActionListener(this);
        check.setBounds(30,360,100,30);
        add(check);

        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.black);
        update.addActionListener(this);
        update.setBounds(150,360,100,30);
        add(update);
         
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setBounds(270,360,100,30);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);


        setBounds(300,280,980,500);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==check){
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try{
                conn cn =new conn();
                ResultSet rs= cn.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheck.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                ResultSet rs2=cn.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while (rs2.next()) {
                    String price =rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountpaid);
                 }
            }catch(Exception ae){
                ae.printStackTrace();
            }

        }else if(e.getSource()==update){
                String number=ccustomer.getSelectedItem();
                String name=tfname.getText();
                String room=tfroom.getText();
                String checkin=tfcheck.getText();
                String deposite =tfpaid.getText();

                try{
                    conn cn=new conn();
                    cn.s.executeUpdate("update customer set room='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposite+"' where number='"+number+"'");
                    JOptionPane.showMessageDialog(null,"Data updated Successful");
                    setVisible(false);
                    new Reception();
                }catch(Exception ea){
                    ea.printStackTrace();
                }

        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Updatecheck();
    }
}
