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
        JButton addCoachButton = createStyledButton("Add Coach", "/path/to/pack.png");

        JButton listePackButton = createStyledButton("Pack List", "./images/list of members.png");
        JButton listeCoachButton = createStyledButton("Coach List", "./images/list of members.png");
        JButton listeMemberButton = createStyledButton("Member List", "./images/list of members.png");
        JButton deconnexionButton = createStyledButton("Déconnexion", "./images/logout.png");

        leftPanel.add(membreButton);
        leftPanel.add(packButton);
        leftPanel.add(addCoachButton);
        leftPanel.add(listePackButton);
        leftPanel.add(listeCoachButton);
        leftPanel.add(listeMemberButton);
        leftPanel.add(deconnexionButton);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 2));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        // Ajouter deux boutons à la partie droite
        JButton rightButton1 = createStyledButton("Right Button 1", "");
        JButton rightButton2 = createStyledButton("Right Button 2", "");

        // Ajouter de l'espace entre les boutons
        int spaceWidth = 10; // Ajustez la largeur de l'espace selon vos besoins
        JPanel spacePanel = new JPanel();
        spacePanel.setPreferredSize(new Dimension(spaceWidth, 1)); // Largeur de l'espace
        rightPanel.add(rightButton1);
        rightPanel.add(spacePanel);
        rightPanel.add(rightButton2);


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

