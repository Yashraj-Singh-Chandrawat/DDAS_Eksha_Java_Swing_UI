package CustomUIComponents;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomUIComponents {

    // Rounded Button
    public static class RoundedButton extends JButton {
        private Color hoverBackgroundColor;
        private Color pressedBackgroundColor;

        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false); // Remove default button fill
            setFocusPainted(false);      // Remove default focus border
            setForeground(Color.WHITE);  // Text color
            setBackground(new Color(94, 114, 235)); // Default background color (blue)

            hoverBackgroundColor = new Color(60, 85, 160);  // Hover color
            pressedBackgroundColor = new Color(40, 60, 120); // Pressed color

            // Add hover effect
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(hoverBackgroundColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(new Color(94, 114, 235)); // Back to default blue when hover ends
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    setBackground(pressedBackgroundColor);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBackground(hoverBackgroundColor);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded corners
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            // No border
        }

        @Override
        public Insets getInsets() {
            return new Insets(10, 20, 10, 20); // Padding for rounded look
        }
    }

    // Primary Label (Heading Style)
    public static class PrimaryLabel extends JLabel {
        public PrimaryLabel(String text) {
            super(text);
            setForeground(new Color(51, 51, 51)); // Dark grey color
            setFont(new Font("Arial", Font.BOLD, 18)); // Larger, bold font for headings
        }
    }

    // Secondary Label (Regular Text Style)
    public static class SecondaryLabel extends JLabel {
        public SecondaryLabel(String text) {
            super(text);
            setForeground(new Color(102, 102, 102)); // Lighter grey for regular text
            setFont(new Font("Arial", Font.PLAIN, 14)); // Normal font size
        }
    }

    // Custom Rounded Text Field
    public static class RoundedTextField extends JTextField {
        private int arcWidth;
        private int arcHeight;

        public RoundedTextField(int columns, int arcWidth, int arcHeight) {
            super(columns);
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setOpaque(false); // Make the background transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Background color
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(209, 217, 230)); // Light blueish-grey border
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
            g2.dispose();
        }

        @Override
        public Insets getInsets() {
            return new Insets(10, 10, 10, 10); // Padding inside text field
        }
    }
}
