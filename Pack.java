import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pack {
    // Définir les informations de connexion à la base de données
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gym";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

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

        packButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightPanel.removeAll();
                addFormFields(rightPanel);
                rightPanel.revalidate();
                rightPanel.repaint();
            }
        });

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

    private static void addFormFields(JPanel panel) {
        String[] labels = {"Nom du Pack:", "Catégorie:", "Description:", "Durée:", "Prix:"};
        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            JTextField textField = new JTextField();
            panel.add(label);
            panel.add(textField);
            textFields[i] = textField;
        }

        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textFields[0].getText();
                String categorie = textFields[1].getText();
                String description = textFields[2].getText();
                String duree = textFields[3].getText();
                int prix = Integer.parseInt(textFields[4].getText());

                insertIntoDatabase(nom, categorie, description, duree, prix);
            }
        });
    }

    private static void insertIntoDatabase(String nom, String categorie, String description, String duree, int prix) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO pack(nom, categorie, description, duree, prix) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nom);
            statement.setString(2, categorie);
            statement.setString(3, description);
            statement.setString(4, duree);
            statement.setInt(5, prix);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Le pack a été ajouté avec succès !");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'ajout du pack : " + ex.getMessage());
}
}
}