package org.example;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

class Notification extends JPanel {

    private RoundedButton openButton, closeButton;
    private JLabel titleLabel, messageLabel, pathLabel, usernameLabel;
    private Font titleFont, subtitleFont, pathFont;

    String s = " C:\\Users\\yashr\\Downloads";

    public void DDAs() {
        // Initialize fonts
        titleFont = new Font("Arial", Font.BOLD, 28);
        subtitleFont = new Font("Arial", Font.BOLD, 18);
        pathFont = new Font("Arial", Font.PLAIN, 14);

        // Set up the JPanel
        setLayout(null);
        setSize(500, 350);
        setBackground(new Color(255, 255, 255));

        // Title label
        titleLabel = new JLabel("Alert!");
        titleLabel.setForeground(new Color(255, 69, 58)); // Bright red color for title
        titleLabel.setBounds(200, 40, 300, 40);
        titleLabel.setFont(titleFont);
        add(titleLabel);

        // Message label
        messageLabel = new JLabel("File with the same name and size found.");
        messageLabel.setForeground(new Color(64, 58, 58, 255)); // Light gray color for message
        messageLabel.setBounds(60, 100, 400, 40);
        messageLabel.setFont(subtitleFont);
        add(messageLabel);

        // Path label
        pathLabel = new JLabel("PATH: " + s);
        pathLabel.setBounds(60, 150, 400, 40);
        pathLabel.setFont(pathFont);
        pathLabel.setForeground(new Color(64, 58, 58, 255));
        add(pathLabel);

        // Username label
        String userName = System.getProperty("user.name");
        usernameLabel = new JLabel("Username: " + userName);
        usernameLabel.setBounds(350, 5, 150, 30);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        usernameLabel.setForeground(Color.DARK_GRAY);
        add(usernameLabel);

        // Custom Open button (Rounded)
        openButton = new RoundedButton("Open");
        openButton.setBounds(90, 230, 120, 35);
        openButton.setBackground(new Color(44, 241, 34)); // Lighter blue
        openButton.setForeground(Color.WHITE);
        add(openButton);

        // Custom Close button (Rounded)
        closeButton = new RoundedButton("Close");
        closeButton.setBounds(270, 230, 120, 35);
        closeButton.setBackground(new Color(255, 56, 56)); // Vibrant pink color
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener((e) -> {
            Window window = SwingUtilities.windowForComponent(this);
            if (window != null) {
                window.dispose();
            }
        });
        add(closeButton);
    }

    public void showPopup(Notification a) throws JSONException {
        Test1 f1 = new Test1(a);
        f1.setVisible(true);
    }

    public void setPath(JSONObject object) throws JSONException {
        s = object.getString("filePath");
    }
}

class Test1 extends JFrame {

    Test1(Notification dda) {
        setTitle("Data Duplicate Alert - By Eksha");
        dda.DDAs();
        add(dda);
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setAlwaysOnTop(true);
    }
}

class Test {
    public static void main(String ar[]) throws JSONException {
        Notification nn = new Notification();
        nn.showPopup(nn);
    }
}



