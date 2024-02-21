import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Add_member {
    private static JPanel rightPanel;
    private static JComboBox<String> packComboBox;
    private static JComboBox<String> coachComboBox;
    private static JComboBox<String> sexeComboBox;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dashboard Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(10, 1));
        leftPanel.setBackground(new Color(50, 50, 50));

        JButton addStandardMember = createStyledButton("Add Standard Member", "./images/new member.png");
        JButton addPremiumMember = createStyledButton("Add Premium Member", "/path/to/pack.png");

        leftPanel.add(addStandardMember);
        leftPanel.add(addPremiumMember);

        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(8, 2));
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

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Add Standard Member")) {
                    rightPanel.removeAll();
                    addStandardMemberForm(rightPanel);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                } else if (text.equals("Add Premium Member")) {
                    rightPanel.removeAll();
                    addPremiumMemberForm(rightPanel);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                }
            }
        });

        return button;
    }

    private static void addStandardMemberForm(JPanel panel) {
        String[] labels = {"Nom:", "Prénom:", "Contact:"};
        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            JTextField textField = new JTextField();
            panel.add(label);
            panel.add(textField);
            textFields[i] = textField;
        }

        // Liste déroulante pour le sexe
        JLabel sexeLabel = new JLabel("Sexe:");
        String[] sexeOptions = {"Masculin", "Féminin"};
        sexeComboBox = new JComboBox<>(sexeOptions);
        panel.add(sexeLabel);
        panel.add(sexeComboBox);

        // Liste déroulante pour les packs
        JLabel packLabel = new JLabel("Pack:");
        packComboBox = new JComboBox<>();
        fillPackComboBox();
        panel.add(packLabel);
        panel.add(packComboBox);

        // Liste déroulante pour les coachs
        JLabel coachLabel = new JLabel("Coach:");
        coachComboBox = new JComboBox<>();
        fillCoachComboBox();
        panel.add(coachLabel);
        panel.add(coachComboBox);

        // Bouton de soumission
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textFields[0].getText();
                String prenom = textFields[1].getText();
                String sexe = (String) sexeComboBox.getSelectedItem();
                String contact = textFields[3].getText();
                String selectedPack = (String) packComboBox.getSelectedItem();
                String selectedCoach = (String) coachComboBox.getSelectedItem();

                insertIntoDatabase(nom, prenom, sexe, contact, selectedPack, selectedCoach);
            }
        });
    }

    private static void addPremiumMemberForm(JPanel panel) {
        String[] labels = {"Nom:", "Prénom:", "Contact:"};
        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            JTextField textField = new JTextField();
            panel.add(label);
            panel.add(textField);
            textFields[i] = textField;
        }

        // Liste déroulante pour le sexe
        JLabel sexeLabel = new JLabel("Sexe:");
        String[] sexeOptions = {"Masculin", "Féminin"};
        sexeComboBox = new JComboBox<>(sexeOptions);
        panel.add(sexeLabel);
        panel.add(sexeComboBox);

        // Liste déroulante pour les packs
        JLabel packLabel = new JLabel("Pack:");
        packComboBox = new JComboBox<>();
        fillPackPComboBox();
        panel.add(packLabel);
        panel.add(packComboBox);

        // Liste déroulante pour les coachs
        JLabel coachLabel = new JLabel("Coach:");
        coachComboBox = new JComboBox<>();
        fillCoachPComboBox();
        panel.add(coachLabel);
        panel.add(coachComboBox);

        // Bouton de soumission
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textFields[0].getText();
                String prenom = textFields[1].getText();
                String sexe = (String) sexeComboBox.getSelectedItem();
                String contact = textFields[3].getText();
                String selectedPack = (String) packComboBox.getSelectedItem();
                String selectedCoach = (String) coachComboBox.getSelectedItem();

                insertPIntoDatabase(nom, prenom, sexe, contact, selectedPack, selectedCoach);
            }
        });
    }

    private static void fillPackComboBox() {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT nom FROM pack WHERE categorie = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "standard");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String packName = resultSet.getString("nom");
                packComboBox.addItem(packName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillCoachComboBox() {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT nom FROM coach WHERE categorie = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "standard");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String coachName = resultSet.getString("nom");
                coachComboBox.addItem(coachName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillPackPComboBox() {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT nom FROM pack WHERE categorie = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "Premium");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String packName = resultSet.getString("nom");
                packComboBox.addItem(packName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillCoachPComboBox() {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT nom FROM coach WHERE categorie = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "Premium");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String coachName = resultSet.getString("nom");
                coachComboBox.addItem(coachName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertIntoDatabase(String nom, String prenom, String sexe, String contact, String selectedPack, String selectedCoach) {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO client (nom, prenom, sexe, contact, categorie, pack, coach, statuPaiement) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, sexe);
            statement.setString(4, contact);
            statement.setString(5, "standard");
            statement.setString(6, selectedPack);
            statement.setString(7, selectedCoach);
            statement.setBoolean(8, false);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Client ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'ajout du client : " + e.getMessage());
        }
    }

    private static void insertPIntoDatabase(String nom, String prenom, String sexe, String contact, String selectedPack, String selectedCoach) {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO client (nom, prenom, sexe, contact, categorie, pack, coach, statuPaiement) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, sexe);
            statement.setString(4, contact);
            statement.setString(5, "premium");
            statement.setString(6, selectedPack);
            statement.setString(7, selectedCoach);
            statement.setBoolean(8, false);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Client ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'ajout du client : " + e.getMessage());
        }
    }
}
