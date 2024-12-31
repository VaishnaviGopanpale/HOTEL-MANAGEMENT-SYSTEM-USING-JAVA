import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice  ccustomer;
    JButton check,update,back;
    JTextField tfroom,tfclean,tfpending,tfpaid,tfavailable,tfname,tfcheck;
    UpdateRoom(){

        JLabel text =new JLabel("Update Room Status");
        text.setFont(new Font("tahoma",Font.PLAIN,20));
        text.setBounds(90,20,250,30);
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
        lbroom.setBounds(30,130,100,25);
        add(lbroom);

        tfroom =new JTextField();
        tfroom.setBounds(200,130,150,20);
        add(tfroom);

        JLabel  lbavailable=new JLabel("Availability");
        lbavailable.setBounds(30,180,100,25);
        add(lbavailable);

        tfavailable =new JTextField();
        tfavailable.setBounds(200,180,150,20);
        add(tfavailable);

        JLabel lbclean =new JLabel("Cleaning Status");
        lbclean.setBounds(30,230,100,25);
        add(lbclean);

        tfclean =new JTextField();
        tfclean.setBounds(200,230,150,20);
        add(tfclean);

        

        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.black);
        check.addActionListener(this);
        check.setBounds(30,300,100,30);
        add(check);

        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.black);
        update.addActionListener(this);
        update.setBounds(150,300,100,30);
        add(update);
         
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setBounds(270,300,100,30);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


        setBounds(300,280,980,450);
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
                    
                }
            ResultSet rs2 =cn.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
            while (rs2.next()) {
                tfavailable.setText(rs2.getString("availability"));
                tfclean.setText(rs2.getString("cleaning_status"));
                 }
            }catch(Exception ae){
                ae.printStackTrace();
            }

        }else if(e.getSource()==update){
                String avai=tfavailable.getText();
                String Status=tfclean.getText();
                String room=tfroom.getText();
                

                try{
                    conn cn=new conn();
                    cn.s.executeUpdate("update room set availability='"+avai+"',cleaning_status='"+Status+"'  where roomnumber='"+room+"'");
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
        new UpdateRoom();
    }
}

