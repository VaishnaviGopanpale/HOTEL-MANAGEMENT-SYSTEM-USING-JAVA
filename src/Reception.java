import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{
    JButton newcoustomer;
    Reception(){

        newcoustomer=new JButton("New Coustomer");
        newcoustomer.setBounds(10,30,200,30);
        newcoustomer.addActionListener(this);
        newcoustomer.setForeground(Color.black);
        newcoustomer.setBackground(Color.black);
        add(newcoustomer);

        
        JButton rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.addActionListener(this);
        rooms.setForeground(Color.black);
        rooms.setBackground(Color.black);
        add(rooms);

        
        JButton deparment=new JButton("Department");
        deparment.setBounds(10,110,200,30);
        deparment.addActionListener(this);
        deparment.setForeground(Color.black);
        deparment.setBackground(Color.black);
        add(deparment);

        
        JButton allemployee=new JButton("All Employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setForeground(Color.black);
        allemployee.addActionListener(this);
        allemployee.setBackground(Color.black);
        add(allemployee);

        
        JButton customer=new JButton("Customer Info");
        customer.setBounds(10,190,200,30);
        customer.addActionListener(this);
        customer.setForeground(Color.black);
        customer.setBackground(Color.black);
        add(customer);

        
        JButton manager=new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.addActionListener(this);
        manager.setForeground(Color.black);
        manager.setBackground(Color.black);
        add(manager);

        
        JButton checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.addActionListener(this);
        checkout.setForeground(Color.black);
        checkout.setBackground(Color.black);
        add(checkout);

        
        JButton update=new JButton("Update");
        update.setBounds(10,310,200,30);
        update.addActionListener(this);
        update.setForeground(Color.black);
        update.setBackground(Color.black);
        add(update);

        JButton roomstatus=new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.addActionListener(this);
        roomstatus.setForeground(Color.black);
        roomstatus.setBackground(Color.black);
        add(roomstatus);

        JButton pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setForeground(Color.black);
        pickup.addActionListener(this);
        pickup.setBackground(Color.black);
        add(pickup);

        JButton searchroom=new JButton("Search Room");
        searchroom.setBounds(10,430,200,30);
        searchroom.addActionListener(this);
        searchroom.setForeground(Color.black);
        searchroom.setBackground(Color.black);
        add(searchroom);

        JButton logout=new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.black);
        logout.setBackground(Color.black);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel l15 = new JLabel(i1);
		l15.setBounds(250,30,500,470);
		add(l15);

        setLayout(null);
        setBounds(350,200,850,570);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("New Coustomer")){
            setVisible(false);
            new AddCustomer();
        }else if(e.getActionCommand().equals("Rooms")){
            setVisible(false);
            new Room();
        }else if(e.getActionCommand().equals("Department")){
            setVisible(false);
            new Department();
        }else if(e.getActionCommand().equals("All Employee")){
            setVisible(false);
            new Employeeinfo();
        }else if(e.getActionCommand().equals("Customer Info")){
            setVisible(false);
            new Customerinfo();
        }else if(e.getActionCommand().equals("Manager Info")){
            setVisible(false);
            new Managerinfo();
        }else if(e.getActionCommand().equals("Search Room")){
            setVisible(false);
            new SearchRoom();
        }else if(e.getActionCommand().equals("Update")){
            setVisible(false);
            new Updatecheck();
        }else if(e.getActionCommand().equals("Update Room Status")){
            setVisible(false);
            new UpdateRoom();
        }else if(e.getActionCommand().equals("Pickup Service")){
            setVisible(false);
            new Pickup();
        }else if(e.getActionCommand().equals("Checkout")){
            setVisible(false);
            new CheckOut();
        }else{
            setVisible(false);
        
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
