

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener{
	JTextField tfname,tfage,tfcompnay,tfmodel,tflocation;
	JLabel lblname,heading,lblage,lblcompany,lblgender,lblmodel,lblavailable,lbllocation;
	JComboBox  cbavailable;
    JRadioButton rbmale,rbfemale;
	JButton add,cancle;

	AddDrivers(){
		

		JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	    heading.setBounds(150, 10, 200, 20);
	    add(heading);

		 lblname = new JLabel("NAME");
         lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
         lblname.setBounds(60, 70, 120, 30);
	    add(lblname);

		 tfname = new JTextField();
         tfname.setBounds(200, 70, 150, 30);
		add(tfname);

        lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 110, 120, 30);
       add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
       add(tfage);

		 lblgender = new JLabel("GENDER");
         lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
         lblgender.setBounds(60, 150, 120, 30);
		add(lblgender);

		rbmale =new JRadioButton("Male");
        rbmale.setBounds(200,150,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale =new JRadioButton("Female");
        rbfemale.setBounds(280,150,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg =new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

		lblcompany = new JLabel("CAR COMPANY");
		lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcompany.setBounds(60, 190, 120, 30);
		add(lblcompany);

        tfcompnay = new JTextField();
		tfcompnay.setBounds(200, 190, 150, 30);
		add(tfcompnay);


    	lblmodel = new JLabel(" MODEL");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmodel.setBounds(60, 230, 120, 30);
	    add(lblmodel);

		tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
		add(tfmodel);

        lblavailable = new JLabel("Availability");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblavailable.setBounds(60, 270, 120, 30);
		add(lblavailable);

		String availableoption[]={"Available","Busy"};
		cbavailable=new JComboBox<>(availableoption);
		cbavailable.setBounds(200, 270, 150, 30);
		cbavailable.setBackground(Color.white);
		add(cbavailable);

        lbllocation = new JLabel("LOCATION");
		lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbllocation.setBounds(60, 310, 120, 30);
		add(lbllocation);

        tflocation = new JTextField();
		tflocation.setBounds(200, 310, 150, 30);
		add(tflocation);


		add=new JButton("ADD DRIVER");
		add.setForeground(Color.black);
		add.setBackground(Color.black);
		add.addActionListener(this);
		add.setBounds(60,370,130,30);
		add(add);
		

		 cancle=new JButton("CANCEL");
		cancle.setForeground(Color.black);
		cancle.setBackground(Color.black);
		cancle.addActionListener(this);
		cancle.setBounds(200,370,130,30);
		add(cancle);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2= i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
		JLabel l15 = new JLabel(i3);
		l15.setBounds(400,30,500,300);
		add(l15);

		
		setLayout(null);
		setBounds(300,200,940,470);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);

		

	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==add){
			String Dname=tfname.getText();
			String Dage=(String) tfage.getText();
            String Ccompany=(String) tfcompnay.getText();
			String Cmodel=(String) tfmodel.getText();
            String Davailable=(String) cbavailable.getSelectedItem();
            String location=(String) tflocation.getText();

            String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        
        }else if(rbfemale.isSelected()){
            gender="female";
        }

			try{
				conn cn =new conn();
				String Query="insert into Driver values('"+Dname+"','"+Dage+"','"+gender+"','"+Ccompany+"','"+Cmodel+"','"+Davailable+"','"+location+"')";
				cn.s.executeUpdate(Query);
				JOptionPane.showMessageDialog(null,"Driver added successfully");
				setVisible(false);

			}catch(Exception e){
				e.printStackTrace();
			}

		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddDrivers();
	}
}