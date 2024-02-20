import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Créer une fenêtre pour l'interface
        JFrame frame = new JFrame("Bienvenue dans votre salle de sport LETT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500); // Ajustez la taille selon vos besoins

        // Créer un panneau pour contenir les composants
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Ajouter un panneau pour le bouton image en haut à gauche
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Ajouter une image au bouton
        ImageIcon closeButtonIcon = new ImageIcon("C:\\Users\\darel\\Downloads\\Gym Icon Jframe\\Icon Gym Jframe\\close_icon.png"); // Remplacez le chemin de votre image
        JButton closeButton = new JButton(closeButtonIcon);
        buttonPanel.add(closeButton);

        // Ajouter une image à gauche
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\darel\\Downloads\\Gym Icon Jframe\\Icon Gym Jframe\\OIP (1).jpg"); // Mettez le chemin de votre image
        JLabel imageLabel = new JLabel(imageIcon);
        mainPanel.add(imageLabel, BorderLayout.WEST);

        // Créer un panneau pour le titre centré et le reste du contenu
        JPanel contentPanel = new JPanel(new GridBagLayout());

        // Créer le titre centré
        JLabel titleLabel = new JLabel("Bienvenue dans votre salle de sport");
        titleLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));

        // Ajouter le titre centré au panneau
        contentPanel.add(titleLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

        // Ajouter les étiquettes et les champs de texte pour l'utilisateur et le mot de passe
        JLabel usernameLabel = new JLabel("USERNAME");
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("PASSWORD");
        JPasswordField passwordField = new JPasswordField(15);

        // Ajouter les étiquettes et les champs de texte au panneau
        contentPanel.add(usernameLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        contentPanel.add(usernameField, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        contentPanel.add(passwordLabel, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        contentPanel.add(passwordField, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        // Créer un bouton de connexion
        JButton loginButton = new JButton("CONNEXION");

        // Ajouter le bouton de connexion au panneau
        contentPanel.add(loginButton, new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));

        // Créer une case à cocher pour afficher le mot de passe
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");

        // Ajouter la case à cocher au panneau
        contentPanel.add(showPasswordCheckBox, new GridBagConstraints(0, 4, 2, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

        // Ajouter le panneau du contenu à droite
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Ajouter les panneaux principaux à la fenêtre
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}