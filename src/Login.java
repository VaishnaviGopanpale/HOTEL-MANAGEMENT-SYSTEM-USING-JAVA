
import javax.swing.*;
import java.sql.*;



import java.awt.*;
import java.awt.event.*;


public  class Login extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField passf;
    JButton login,Can;

    /**
     * 
     */
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
         
        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user); 

        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        passf=new JPasswordField();
        passf.setBounds(150,70,150,30);
        add(passf);


        login =new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);


        Can =new JButton("Cancel");
        Can.setBounds(180,150,120,30);
        Can.setBackground(Color.BLACK);
        Can.setForeground(Color.black);
        Can.addActionListener(this);
        add(Can);

        ImageIcon IM =new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=IM.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        setBounds(500,200,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == login){
            String user= username.getText();
            String pass= passf.getText();

            try{
                conn cn= new conn(); 
                String Query="select * from login where username='"+ user +"' and password='"+ pass +"'";
                ResultSet rs=cn.s.executeQuery(Query);

                if(rs.next()){
                    setVisible(false);
                    new Dashboard();

                }else{
                    JOptionPane.showMessageDialog(null, "Invalide username or password");
                    setVisible(false);
                }
            
            }
            catch(Exception a){
                a.printStackTrace();
            }

        }else if (e.getSource()== Can){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
