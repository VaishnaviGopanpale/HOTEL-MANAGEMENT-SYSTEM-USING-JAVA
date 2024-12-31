import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Employeeinfo extends JFrame implements ActionListener {
    JTable t1;
    JButton back;

    Employeeinfo() {
        // Setting the background color
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Table to display employee data
        t1 = new JTable();
        t1.setShowGrid(true); // Enable grid lines
        t1.setGridColor(Color.BLACK); // Set grid color for better clarity

        // Highlight headers
        JTableHeader header = t1.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 14)); // Bold font for headers

        // Adding table to a scroll pane
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 50, 1000, 400);
        add(sp);

        // Back button
        back = new JButton("Back");
        back.setBounds(450, 500, 120, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        add(back);

        // Fetch data and set the table model
        try {
            conn cn = new conn();
            ResultSet rs = cn.s.executeQuery("SELECT * FROM Employee");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame settings
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    // Handle the back button action
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception(); // Assuming Reception is another frame
    }

    public static void main(String[] args) {
        new Employeeinfo();
    }
}
