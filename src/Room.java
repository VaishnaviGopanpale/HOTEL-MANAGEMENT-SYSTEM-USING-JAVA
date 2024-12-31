import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {
    JTable t1;
    JButton back;

    Room() {
        // Set the background color of the frame
        getContentPane().setBackground(Color.white);

        // Add an image to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        // Create a table
        t1 = new JTable();
        t1.setShowGrid(true); // Enable table grid lines
        t1.setGridColor(Color.BLACK); // Set grid color
        t1.setBounds(0, 40, 500, 400);

        // Add the table to a scroll pane
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 40, 500, 400);
        add(sp);

        // Add column headers
        JLabel lb1 = new JLabel("Room Number");
        lb1.setBounds(10, 10, 100, 20);
        add(lb1);

        JLabel lb2 = new JLabel("Availability");
        lb2.setBounds(120, 10, 100, 20);
        add(lb2);

        JLabel lb3 = new JLabel("Status");
        lb3.setBounds(220, 10, 100, 20);
        add(lb3);

        JLabel lb4 = new JLabel("Price");
        lb4.setBounds(320, 10, 100, 20);
        add(lb4);

        JLabel lb5 = new JLabel("Bed Type");
        lb5.setBounds(410, 10, 100, 20);
        add(lb5);

        // Back button
        back = new JButton("Back");
        back.setBounds(200, 500, 120, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.black); // Use white text for better contrast
        add(back);

        // Load data into the table
        try {
            conn cn = new conn();
            ResultSet rs = cn.s.executeQuery("SELECT * FROM room");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame settings
        setBounds(300, 200, 1050, 600);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Room();
    }
}
