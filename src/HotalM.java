import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HotalM extends JFrame implements ActionListener {
    HotalM() {
        setSize(1920, 1080);
        setLocation(100, 100);
        setLayout(null);

        // Load and scale the image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel jl = new JLabel(scaledIcon);
        jl.setBounds(0, 0, 1920, 1080);
        add(jl);

        JLabel text = new JLabel("HOTAL MANAGEMENT SYSTEM");
        text.setBounds(460, 50, 1000, 90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        jl.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        jl.add(next);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        new Login(); // Assuming Login is another class in your project
    }

    public static void main(String[] args) {
        new HotalM();
    }
}
    