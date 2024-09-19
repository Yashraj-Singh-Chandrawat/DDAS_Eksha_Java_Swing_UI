import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class DDA extends JFrame {

    private JButton openButton, closeButton;
    private JLabel titleLabel, messageLabel, pathLabel, usernameLabel;
    private Font titleFont, subtitleFont, pathFont;

    public DDA() {
        // Initialize fonts
        titleFont = new Font("Arial", Font.BOLD, 28);
        subtitleFont = new Font("Arial", Font.BOLD, 18);
        pathFont = new Font("Arial", Font.PLAIN, 14);

        // Set up the JFrame
        setTitle("Data Duplicate Alert");
        setLayout(null);
        setSize(500, 350);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the window when the "Close" button is pressed
        getContentPane().setBackground(Color.DARK_GRAY); // Dark background for the JFrame

        // Title label
        titleLabel = new JLabel("Alert!");
        titleLabel.setForeground(new Color(255, 69, 58)); // Bright red color for title
        titleLabel.setBounds(200, 40, 300, 40);
        titleLabel.setFont(titleFont);
        add(titleLabel);

        // Message label
        messageLabel = new JLabel("File with the same name and size found.");
        messageLabel.setForeground(Color.LIGHT_GRAY); // Light gray color for message
        messageLabel.setBounds(60, 100, 400, 40);
        messageLabel.setFont(subtitleFont);
        add(messageLabel);

        // Path label
        pathLabel = new JLabel("PATH: " + "path placeholder");
        pathLabel.setBounds(60, 150, 400, 40);
        pathLabel.setFont(pathFont);
        pathLabel.setForeground(Color.WHITE); // White color for path
        add(pathLabel);

        // Username label
        String userName = System.getProperty("user.name");
        usernameLabel = new JLabel("Username: " + userName);
        usernameLabel.setBounds(350, 5, 150, 30);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        usernameLabel.setForeground(Color.GRAY); // Gray color for username
        add(usernameLabel);

        // Open button
        openButton = new JButton("Open");
        openButton.setBounds(90, 230, 120, 35);
        openButton.setBackground(new Color(30, 136, 229)); // Bright blue color for button
        openButton.setForeground(Color.WHITE);
        openButton.setFocusPainted(false);
        openButton.setFont(new Font("Arial", Font.BOLD, 14));
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define the file path (update this path as needed)
                String filePath = "Path placeholder";
                File file = new File(filePath);
                if (file.exists()) {
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error opening file: " + ex.getMessage(), 
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "File not found!", 
                            "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(openButton);

        // Close button
        closeButton = new JButton("Close");
        closeButton.setBounds(270, 230, 120, 35);
        closeButton.setBackground(new Color(233, 30, 99)); // Vibrant pink color for button
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.addActionListener((e) -> dispose()); // Dispose of the window when clicked
        add(closeButton);
    }
}

class Test1 {
    public static void main(String[] args) {
        // Create and display the alert dialog on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            DDA alert = new DDA();
            alert.setVisible(true);
        });
    }
}
