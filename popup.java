import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class DDA extends JPanel {
    JLabel l1, l2, l3, l4;
    JButton b1, b2, b3, exit;
    Font titleFont, labelFont, buttonFont;
    String s;

    DDA() {
        setLayout(null);

        // Set professional fonts
        titleFont = new Font("Arial", Font.BOLD, 24); // Title font
        labelFont = new Font("Arial", Font.PLAIN, 16); // Labels font
        buttonFont = new Font("Arial", Font.PLAIN, 14); // Buttons font

        // Title Label
        l1 = new JLabel("File Duplicate Alert!!");
        l1.setForeground(new Color(220, 20, 60)); // Crimson color
        l1.setSize(300, 40);
        l1.setLocation(100, 30);  // Centered horizontally
        l1.setFont(titleFont);
        add(l1);

        // Info Labels
        l2 = new JLabel("Duplicate File Found!");
        l2.setForeground(Color.DARK_GRAY);
        l2.setSize(300, 40);
        l2.setLocation(100, 80);  // Centered horizontally
        l2.setFont(labelFont);
        add(l2);

        l3 = new JLabel("Do you want to delete?");
        l3.setSize(300, 40);
        l3.setLocation(100, 120);  // Centered horizontally
        l3.setFont(labelFont);
        add(l3);

        l4 = new JLabel("PATH : " + s);
        l4.setSize(400, 40);
        l4.setLocation(50, 180);
        l4.setFont(labelFont);
        add(l4);

        // Open button
        b1 = new JButton("Open");
        b1.setFont(buttonFont);
        b1.setBackground(new Color(70, 130, 180)); // Professional blue color
        b1.setForeground(Color.WHITE);
        b1.setSize(120, 35);
        b1.setLocation(40, 250); // More spacing between buttons
        b1.addActionListener(e -> openFile());
        add(b1);

        // Delete button
        b2 = new JButton("Delete");
        b2.setFont(buttonFont);
        b2.setBackground(new Color(178, 34, 34)); // Professional red color
        b2.setForeground(Color.WHITE);
        b2.setSize(120, 35);
        b2.setLocation(180, 250); // More spacing between buttons
        b2.addActionListener(e -> deleteFile());
        add(b2);

        // Download button
        b3 = new JButton("Download");
        b3.setFont(buttonFont);
        b3.setBackground(new Color(34, 139, 34)); // Professional green color
        b3.setForeground(Color.WHITE);
        b3.setSize(120, 35);
        b3.setLocation(320, 250); // More spacing between buttons
        add(b3);

        // Exit button
        exit = new JButton("Close");
        exit.setFont(buttonFont);
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        exit.setSize(120, 35);
        exit.setLocation(180, 320); // Centered below the other buttons
        exit.addActionListener(e -> {
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose(); // Close frame without affecting backend
            }
        });
        add(exit);
    }

    private void openFile() {
        String filePath = s;
        File file = new File(filePath);
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error opening file: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "File not found!");
        }
    }

    private void deleteFile() {
        String filePath1 = s;
        File file1 = new File(filePath1);
        if (file1.exists()) {
            if (file1.delete()) {
                JOptionPane.showMessageDialog(null, "File deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete file!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "File not found!");
        }
    }

    public void setPath(String filePath) {
        s = filePath;
        l4.setText("PATH : " + s); // Update path label
    }
}

class Popup {
    public static void main(String[] ar) {
        JFrame frame = new JFrame();
        DDA ddaPanel = new DDA();
        frame.add(ddaPanel);
        frame.setSize(500, 400); // Adjusted frame size
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only frame
    }
}
