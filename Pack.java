import javax.swing.*;
import java.awt.*;

public class Pack {
    public static void main(String[] args) {
        // Créer une fenêtre pour l'interface
        JFrame frame = new JFrame("Dashboard Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500); // Ajustez la taille selon vos besoins

        // Panneau principal avec un BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panneau gauche pour les boutons (barre de navigation)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(7, 1));
        leftPanel.setBackground(new Color(50, 50, 50)); // Couleur d'arrière-plan

        // Créer les boutons pour le menu avec une police et une couleur différentes
        JButton membreButton = createStyledButton("Membre", "C:\\Users\\darel\\Downloads\\Gym Icon Jframe\\Icon Gym Jframe\\new member.png");
        JButton packButton = createStyledButton("Pack", "/path/to/pack.png");
        JButton listeButton = createStyledButton("Liste", "C:\\Users\\darel\\Downloads\\Gym Icon Jframe\\Icon Gym Jframe\\list of members.png");
        JButton jButton4 = createStyledButton("Button 4", "/path/to/button4.png");
        JButton jButton5 = createStyledButton("Button 5", "/path/to/button5.png");
        JButton deconnexionButton = createStyledButton("Déconnexion", "C:\\Users\\darel\\Downloads\\Gym Icon Jframe\\Icon Gym Jframe\\logout.png");

        // Ajouter les boutons au panneau gauche
        leftPanel.add(membreButton);
        leftPanel.add(packButton);
        leftPanel.add(listeButton);
        leftPanel.add(jButton4);
        leftPanel.add(jButton5);
        leftPanel.add(deconnexionButton);

        // Panneau droit pour les informations sur les packs
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4, 2));

        // Créer les labels et les champs de texte pour les informations sur les packs
        JLabel titleLabel = new JLabel("Vos Packs", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Police en gras et plus grande
        JLabel nomLabel = new JLabel("Nom", SwingConstants.RIGHT);
        JLabel prixLabel = new JLabel("Prix", SwingConstants.RIGHT);
        JLabel descriptionLabel = new JLabel("Description", SwingConstants.RIGHT);
        JTextField nomTextField = createStyledTextField();
        JTextField prixTextField = createStyledTextField();
        JTextField descriptionTextField = createStyledTextField();
        JButton stockerButton = createStyledButton("Stocker en BD","C:\\Users\\darel\\Downloads\\Gym Icon Jframe\\Icon Gym Jframe\\save.png");

        // Ajouter les composants au panneau droit
        rightPanel.add(titleLabel);
        rightPanel.add(new JLabel()); // Composant vide pour l'alignement
        rightPanel.add(nomLabel);
        rightPanel.add(nomTextField);
        rightPanel.add(prixLabel);
        rightPanel.add(prixTextField);
        rightPanel.add(descriptionLabel);
        rightPanel.add(descriptionTextField);

        // Ajouter le panneau gauche et le panneau droit au panneau principal
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        // Ajouter le panneau principal à la fenêtre
        frame.add(mainPanel);

        // Afficher la fenêtre
        frame.setVisible(true);
    }



    private static JButton createStyledButton(String text, String imagePath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Police de taille moyenne
        button.setForeground(Color.WHITE); // Texte en blanc
        button.setBackground(new Color(70, 70, 70)); // Couleur de fond gris foncé
        button.setFocusPainted(false); // Supprimer le contour de mise au point

        // Ajouter une icône à partir du chemin d'image
        if (!imagePath.isEmpty()) {
            ImageIcon icon = new ImageIcon(imagePath);
            button.setIcon(icon);
        }
        return button;
    }


    private static JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 5)); // Police de taille moyenne
        textField.setBackground(new Color(220, 220, 220)); // Couleur de fond gris clair
        return textField;
    }
}
