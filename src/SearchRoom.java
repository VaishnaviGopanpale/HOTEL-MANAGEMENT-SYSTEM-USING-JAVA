import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {
    JTable t1;
    JButton back, submit;
    JComboBox<String> bedtype;
    JCheckBox available;

    SearchRoom() {
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        bedtype = new JComboBox<>(new String[] { "Single bed", "Double bed" });
        bedtype.setBounds(150, 100, 150, 25);
        bedtype.setBackground(Color.white);
        add(bedtype);

        available = new JCheckBox("Only display available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.white);
        add(available);

        // Table with Scroll Pane
        t1 = new JTable();
        t1.setShowGrid(true); // Enable grid lines
        t1.setGridColor(Color.BLACK); // Set grid line color

        // Customize table header
        JTableHeader header = t1.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 200, 1000, 300);
        add(sp);

        // Table Headers
        JLabel lb1 = new JLabel("Room Number");
        lb1.setBounds(50, 160, 100, 20);
        add(lb1);

        JLabel lb2 = new JLabel("Availability");
        lb2.setBounds(270, 160, 100, 20);
        add(lb2);

        JLabel lb3 = new JLabel("Cleaning Status");
        lb3.setBounds(450, 160, 100, 20);
        add(lb3);

        JLabel lb4 = new JLabel("Price");
        lb4.setBounds(670, 160, 100, 20);
        add(lb4);

        JLabel lb5 = new JLabel("Bed Type");
        lb5.setBounds(850, 160, 100, 20);
        add(lb5);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(300, 500, 120, 30);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.black);
        add(submit);

        // Back Button
        back = new JButton("Back");
        back.setBounds(500, 500, 120, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.black);
        add(back);

        // Load Data into Table
        try {
            conn cn = new conn();
            ResultSet rs = cn.s.executeQuery("SELECT * FROM room");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame Settings
        setBounds(300, 200, 1000, 600);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String query1 = "SELECT * FROM Room WHERE bed_type='" + bedtype.getSelectedItem() + "'";
                String query2 = "SELECT * FROM Room WHERE availability='available' AND bed_type='" + bedtype.getSelectedItem() + "'";
                conn cn = new conn();
                ResultSet rs;
                if (available.isSelected()) {
                    rs = cn.s.executeQuery(query2);
                } else {
                    rs = cn.s.executeQuery(query1);
                }
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception(); // Assuming Reception is another class
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
