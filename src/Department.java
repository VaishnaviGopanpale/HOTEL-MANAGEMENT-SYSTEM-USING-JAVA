import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {
    JTable t1;
    JButton back;

    Department() {
        // Set the background color for the frame
        getContentPane().setBackground(Color.white);

        // Create a table
        t1 = new JTable();
        t1.setShowGrid(true); // Enable table grid lines
        t1.setGridColor(Color.BLACK); // Set grid color

        // Highlight headers
        JTableHeader header = t1.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 14)); // Bold font for headers

        // Add the table to a scroll pane
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 50, 700, 350);
        add(sp);

        // Back button
        back = new JButton("Back");
        back.setBounds(280, 400, 120, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK); // Use white text for better contrast
        add(back);

        // Load data into the table
        try {
            conn cn = new conn();
            ResultSet rs = cn.s.executeQuery("SELECT * FROM Department");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame settings
        setBounds(400, 200, 700, 480);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Handle back button action
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Department();
    }
}
