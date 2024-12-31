import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.JTableHeader;


public class Customerinfo extends JFrame implements ActionListener {
    JTable t1;
    JButton back;

    Customerinfo() {
        // Frame background
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // JTable
        t1 = new JTable();
        t1.setShowGrid(true); // Enable grid lines
        t1.setGridColor(Color.BLACK); // Set grid line color

        // Customize table header
        JTableHeader header = t1.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 14)); // Bold font for headers

        // Add table to a scroll pane
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 40, 1000, 400);
        add(sp);

        // Back button
        back = new JButton("Back");
        back.setBounds(450, 500, 120, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.black);
        add(back);

        // Fetch data and set table model
        try {
            conn cn = new conn();
            ResultSet rs = cn.s.executeQuery("SELECT * FROM customer");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Frame settings
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    // Action listener for the back button
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception(); // Assuming Reception is another frame
    }

    public static void main(String[] args) {
        new Customerinfo();
    }
}
