import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    private JPanel cards;
    private CardLayout cardLayout;

    public GameMenu() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the window

        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cards.getLayout();

        // Menu panel
        JPanel menuPanel = createMenuPanel();
        cards.add(menuPanel, "Menu");

        // Fight panel
        JPanel fightPanel = createFightPanel();
        cards.add(fightPanel, "Fight");

        add(cards);
        cardLayout.show(cards, "Menu"); // Show menu panel by default

        setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Username input
        JLabel usernameLabel = new JLabel("Enter Username:");
        JTextField usernameField = new JTextField(20);

        // Play button
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if (!username.isEmpty()) {
                    cardLayout.show(cards, "Fight"); // Switch to fight panel
                    JOptionPane.showMessageDialog(GameMenu.this, "Starting game for " + username);
                    // Replace this with your game logic to start the fight
                } else {
                    JOptionPane.showMessageDialog(GameMenu.this, "Please enter a username!");
                }
            }
        });

        panel.add(usernameLabel, BorderLayout.NORTH);
        panel.add(usernameLabel, BorderLayout.LINE_START); // Align label to the left
    panel.add(usernameField, BorderLayout.BEFORE_FIRST_LINE); // Place field above label

        panel.add(playButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createFightPanel() {
        JPanel panel = new JPanel(new BorderLayout());
    
        // Panel to display player and opponent
        JPanel battlePanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns
        JLabel playerLabel = new JLabel("Player");
        JLabel opponentLabel = new JLabel("Opponent");
        battlePanel.add(playerLabel);
        battlePanel.add(opponentLabel);
    
        // Panel to choose attack options
        JPanel attackPanel = new JPanel(new GridLayout(2, 2)); // 2 rows, 2 columns
        JButton attack1Button = new JButton("Attack 1");
        JButton attack2Button = new JButton("Attack 2");
        JButton attack3Button = new JButton("Attack 3");
        JButton attack4Button = new JButton("Attack 4");
        attackPanel.add(attack1Button);
        attackPanel.add(attack2Button);
        attackPanel.add(attack3Button);
        attackPanel.add(attack4Button);
    
        panel.add(battlePanel, BorderLayout.CENTER);
        panel.add(attackPanel, BorderLayout.SOUTH);
    
        return panel;
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMenu();
            }
        });
    }
}
