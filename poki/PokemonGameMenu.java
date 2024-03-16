import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonGameMenu extends JFrame {

    private String username;

    public PokemonGameMenu() {
        setTitle("Pokemon Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the window

        // Username input
        String input = JOptionPane.showInputDialog(this, "Enter your username:");
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty. Exiting...");
            System.exit(0);
        }
        username = input.trim();

        // Create buttons
        JButton startGameButton = new JButton("Start Game");
        JButton selectPokemonButton = new JButton("Select Pokemon");
        JButton quitButton = new JButton("Quit");

        // Add action listeners
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        selectPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectPokemon();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(startGameButton);
        panel.add(selectPokemonButton);
        panel.add(quitButton);

        // Add panel to frame
        add(panel);
    }

    private void startGame() {
        // Add logic to start the game
        System.out.println("Starting new game for username: " + username);
    }

    private void selectPokemon() {
        // Add logic to select Pokemon
        System.out.println("Selecting Pokemon for username: " + username);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PokemonGameMenu menu = new PokemonGameMenu();
                menu.setVisible(true);
            }
        });
    }
}
