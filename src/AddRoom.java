

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener{
	JTextField tfprice,tfroomnumber;
	JLabel lblroomnumber,heading,lblprice,lblclean,lblavailable,lbltype;
	JComboBox cbavailable, cbcleane,cbtype;
	JButton add,cancle;

	AddRoom(){
		

		JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	    heading.setBounds(150, 20, 200, 20);
	    add(heading);

		 lblroomnumber = new JLabel("Room Number");
		lblroomnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblroomnumber.setBounds(60, 80, 120, 30);
	    add(lblroomnumber);

		 tfroomnumber = new JTextField();
		tfroomnumber.setBounds(200, 80, 150, 30);
		add(tfroomnumber);

		 lblavailable = new JLabel("Availability");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblavailable.setBounds(60, 130, 120, 30);
		add(lblavailable);

		String availableoption[]={"Available","Occupide"};
		 cbavailable=new JComboBox<>(availableoption);
		cbavailable.setBounds(200, 130, 150, 30);
		cbavailable.setBackground(Color.white);
		add(cbavailable);

		 lblclean = new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblclean.setBounds(60, 180, 120, 30);
		add(lblclean);

		String clean[]={"Cleaned","Dirty"};
		 cbcleane=new JComboBox<>(clean);
		cbcleane.setBounds(200, 180, 150, 30);
		cbcleane.setBackground(Color.white);
		add(cbcleane);


		 lblprice = new JLabel(" PRICE");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblprice.setBounds(60, 230, 120, 30);
	    add(lblprice);

		 tfprice = new JTextField();
		tfprice.setBounds(200, 230, 150, 30);
		add(tfprice);

		 lbltype = new JLabel("BED TYPE");
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltype.setBounds(60, 280, 120, 30);
		add(lbltype);

		String type[]={"Single bed","Double bed"};
		 cbtype=new JComboBox<>(type);
		cbtype.setBounds(200, 280, 150, 30);
		cbtype.setBackground(Color.white);
		add(cbtype);

		 add=new JButton("ADD ROOM");
		add.setForeground(Color.black);
		add.setBackground(Color.black);
		add.addActionListener(this);
		add.setBounds(60,350,130,30);
		add(add);
		

		cancle=new JButton("CANCEL");
		cancle.setForeground(Color.black);
		cancle.setBackground(Color.black);
		cancle.addActionListener(this);
		cancle.setBounds(200,350,130,30);
		add(cancle);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel l15 = new JLabel(i1);
		l15.setBounds(400,30,500,300);
		add(l15);

		
		setLayout(null);
		setBounds(300,200,940,470);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);

		

	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==add){
			String roomnumber=tfroomnumber.getText();
			String availabilty=(String) cbavailable.getSelectedItem();
			String status =(String) cbcleane.getSelectedItem();
			String price=(String) tfprice.getText();
			String type=(String) cbtype.getSelectedItem();

			

			try{
				conn cn =new conn();
				String Query="insert into room values('"+roomnumber+"','"+availabilty+"','"+status+"','"+price+"','"+type+"')";
				
				cn.s.executeUpdate(Query);
				JOptionPane.showMessageDialog(null,"Room added successfully");
				setVisible(false);

			}catch(Exception e){
				e.printStackTrace();
			}

		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddRoom();
	}
}