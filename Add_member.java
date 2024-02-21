import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Add_member {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dashboard Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(7, 1));
        leftPanel.setBackground(new Color(50, 50, 50));

        JButton membreButton = createStyledButton("New Member", "./images/new member.png");
        JButton packButton = createStyledButton("Add Pack", "/path/to/pack.png");


        leftPanel.add(membreButton);
        leftPanel.add(packButton);


        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 2));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));




        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private static JButton createStyledButton(String text, String imagePath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 70, 70));
        button.setFocusPainted(false);

        if (!imagePath.isEmpty()) {
            ImageIcon icon = new ImageIcon(imagePath);
            button.setIcon(icon);
        }
        return button;
    }
}

