import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        ImageIcon IM =new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=IM.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);



        setBounds(0,0,1920,1080);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text =new JLabel("WELCOME TO BALAJI SAROVAR ");
        text.setForeground(Color.WHITE);
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,50));
        image.add(text);
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotal=new JMenu("HOTAL MANAGEMENT");
        hotal.setForeground(Color.red);
        mb.add(hotal);


        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        mb.add(admin);

        JMenuItem recption=new JMenuItem("RECPTION");
        recption.addActionListener(this);
        hotal.add(recption);

        JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms=new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);


        JMenuItem adddriver=new JMenuItem("ADD DRIVERS");
        adddriver.addActionListener(this);
        admin.add(adddriver);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new Addemployee();
            
        }else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRoom();
            
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDrivers();
        }else if(ae.getActionCommand().equals("RECPTION")){
            new Reception();
        }
    }
    public static void main(String[] args) {
       new Dashboard();
    }
}
