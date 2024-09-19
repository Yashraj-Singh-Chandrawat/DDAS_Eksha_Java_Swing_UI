import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.nio.file.Paths;
import javax.swing.Timer;

public class Pane2  {
  
      JPanel frame;
    Pane2() {
		// extra 
		ChromeInstructionPanel i =new ChromeInstructionPanel();
		 
		
        frame = new JPanel();
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
		frame.setLocation(250,250);
		frame.setLayout(null);

        JPanel upperbody = new JPanel();
		
        upperbody.setBackground(new Color(240, 240, 240)); // Light background for content contrast
        upperbody.setLayout(null);
		JLabel l1=i.createImageLabel("abc.png"); // to add image to UPPER Panel
		l1.setBounds(0,0,800,120);
		upperbody.add(l1);
		upperbody.add(new JLabel("App Logo Bosics"));
		upperbody.setBounds(0,0,800,50);
		upperbody.setBackground(Color.blue);
		
		
		 JPanel mainbodypanel = new JPanel();
        mainbodypanel.setBackground(new Color(240, 240, 240)); // Light background for content contrast
        mainbodypanel.add(new JLabel("Content "));
		mainbodypanel.setBounds(0,55,800,600);
		mainbodypanel.setLayout(null);
		mainbodypanel.setBackground(Color.blue);
			   
			   
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setUI(new FacebookTabbedPaneUI());
        Font small =new Font("Roboto", Font.PLAIN, 16);
        
		
		
          Directory addfolder=new Directory();//add folder Panel
		  Extension extensionPage= new Extension ();
	      JPanel ScanFolder= new JPanel();
		  ScanFolder.setLayout(null);
		   RoundedTextField scan =new  RoundedTextField(20);
	          scan.setBounds(150,150,200,40);
			  scan.setFont(small);
			  
			  RoundedButton select=new RoundedButton("Select Directory");
			  select.setBounds(400,150,150,40);
			  select.setFont(small);
			   RoundedButton scan_button=new RoundedButton("Scan");
			  scan_button.setBounds(415,230,120,40);
             	scan_button.setFont(small);
			  JLabel l4=new JLabel("Scan Folder to Find Duplicate ");
          l4.setBounds(160,60,500,80);
	     l4.setFont(new Font("Roboto", Font.PLAIN, 25));
	   //l4.setForeground(Color.Black);
	   
	    JLabel l5=new JLabel("Currently being developed");
          l5.setBounds(200,350,500,80);
	     l5.setFont(new Font("Roboto", Font.PLAIN, 25));
	   l5.setFont(small);
	   l5.setForeground(Color.red);
	            ScanFolder.add(l5);	
	   
	            ScanFolder.add(l4);	
				ScanFolder.add(scan_button);
             	ScanFolder.add(scan);
             	ScanFolder.add(select);
				
				
		  
		  
		   
		  
        // Adding tabs with icons
        tabbedPane.addTab("Select Folder", createIcon("img1.jpg"), addfolder);
                       //      ^                    ^                             ^
					   //      |                    |                             |
					   //  to add tab name     to add small icon on tab      IMP yha par bus mehod ki jagah Panal ke //                                                       Object pass karne h
	   tabbedPane.addTab("Add Extension", createIcon("icon2.png"), extensionPage);
        tabbedPane.addTab("Deep Scan", createIcon("icon3.png"), ScanFolder);
        tabbedPane.addTab("Notification", createIcon("icon4.png"), createPanel("Messages Content"));
        tabbedPane.addTab("History", createIcon("icon4.png"), createPanel("Messages Content"));
		tabbedPane.setBounds(0,0,820,600);
       
		mainbodypanel.add(tabbedPane);// tabbedPane is added on a Panel Named mainbodypanel
	   
   	   frame.add(upperbody);
	   frame.add(mainbodypanel);
      // frame.setVisible(true);
    }

    private static Icon createIcon(String path) {
        // Dummy method for icons, replace with actual ImageIcon if you have images
        return new ImageIcon(new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB));
    }

    private static JPanel createPanel(String content) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240)); // Light background for content contrast
        panel.add(new JLabel(content, JLabel.CENTER));
		panel.setBackground(Color.pink);
        return panel;
    }
}


// This class is fully AI generated to customize the Shape and color of Tabs Don't Learn it Just use 
//  tabbedPane.setUI(new FacebookTabbedPaneUI());
//and it's method   tabbedPane.addTab("Add Extension(title of tab)", createIcon("icon2.png")(image icon), //createPanel("Settings Content") ); 

class FacebookTabbedPaneUI extends BasicTabbedPaneUI {
    private final Color tabColor = new Color(66, 103, 178); // Brighter Facebook Blue
    private final Color selectedTabColor = new Color(255, 255, 255, 180);
    private final int tabSpacing = 15; // More space between tabs
    private final int tabHeight = 50; // Increased height for tabs
    private final int tabWidth = 160; // Increased width for tabs
    private int hoverIndex = -1;

    @Override
    protected void installListeners() {
        super.installListeners();

        tabPane.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = tabForCoordinate(tabPane, e.getX(), e.getY());
                if (index != hoverIndex) {
                    hoverIndex = index;
                    tabPane.repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverIndex = -1;
                tabPane.repaint();
            }
        });
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color baseColor = tabColor;
        if (isSelected) {
            g2.setPaint(new GradientPaint(x, y, baseColor.brighter(), x, y + h, baseColor.darker()));
        } else if (tabIndex == hoverIndex) {
            g2.setPaint(new GradientPaint(x, y, baseColor.brighter().brighter(), x, y + h, baseColor.brighter()));
        } else {
            g2.setPaint(new GradientPaint(x, y, baseColor, x, y + h, baseColor.darker()));
        }

        // Drawing the tab shape as a normal rectangle
        g2.fillRect(x, y, w, h);

        if (isSelected || tabIndex == hoverIndex) {
            g2.setColor(new Color(255, 255, 255, 200));
            g2.setStroke(new BasicStroke(3f));
            g2.drawRect(x, y, w - 1, h - 1);
        }

        // Adding a more prominent glow effect
        if (isSelected) {
            g2.setColor(new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 150));
            g2.setStroke(new BasicStroke(6f));
            g2.drawRect(x - 2, y - 2, w + 4, h + 4);
        }
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
        g.setFont(font.deriveFont(Font.BOLD, 18f));
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (isSelected) {
            g2.setColor(new Color(255, 255, 255));
        } else {
            g2.setColor(new Color(240, 240, 240));
        }

        // Center the text vertically and horizontally within the tab
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(title);
        int textHeight = fm.getAscent();
        int x = (textRect.width - textWidth) / 2 + textRect.x;
        int y = (textRect.height + textHeight) / 2 + textRect.y - 5;

        // Main text
        g2.drawString(title, x, y);
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        // Border handled in paintTabBackground
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        // Custom content border (optional)
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(100, 100, 100));
        g2.setStroke(new BasicStroke(2f));
        g2.drawRect(2, 2, tabPane.getWidth() - 4, tabPane.getHeight() - 4);
    }

    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        return tabHeight; // Set the fixed height for tabs
    }

    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        return tabWidth; // Set the fixed width for tabs
    }

    @Override
    protected void layoutLabel(int tabPlacement, FontMetrics metrics, int tabIndex, String title, Icon icon, Rectangle tabRect, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        super.layoutLabel(tabPlacement, metrics, tabIndex, title, icon, tabRect, iconRect, textRect, isSelected);
        // Adjust textRect for better spacing
        textRect.x = tabRect.x + (tabRect.width - textRect.width) / 2;
        textRect.y = tabRect.y + (tabRect.height + textRect.height) / 2 - 5;
    }
}




class Directory extends JPanel {
    int j=0, y =100 , i = 0;   // int j is remove button check loop 
    ImageIcon img1;
	
    Image img;
	int veryimportantCounter=-1;
	int pathCounter;
    JFileChooser fileChooser;
    RoundedTextField tx[] = new RoundedTextField[10];
     RoundedButton b[] = new  RoundedButton[6];
	RemoveButton Remove;
	RemoveButton remove[] = new RemoveButton[6];
     RoundedButton AddMoreDir;
     RoundedButton Save;
	String defaultpath;
	 String recievePath[] = new String[8];
    String firstPath; // for Storing the firstPath of directory that user going to store
    String s[] = new String[10];  // Taking String array to store 10 different Directory paths
     boolean check[]=new boolean[6];
	 int index;
    public Directory() {
        img1 = new ImageIcon("testit.jpg");
        img = img1.getImage();
		
		//  
		Font small =new Font("Roboto", Font.PLAIN, 14);
		Font medium =new Font("Roboto", Font.PLAIN, 16);

        setLayout(null);
        String userName = System.getProperty("user.name");
        JLabel username = new JLabel("UserName : " + userName);
        username.setBounds(590, 20, 150, 35);
		username.setFont(small);
        add(username);

        JLabel work = new JLabel("Select Directory");
        work.setBounds(140, 60, 200, 35);
		work.setFont(medium);
        add(work);

        RoundedTextField txt1 = new RoundedTextField(20);
        txt1.setSize(220, 35);
        txt1.setLocation(140, 100);
        add(txt1);
        txt1.setEditable(false);
        txt1.setText(getDefaultDownloadPath());
		 

         RoundedButton selectDirButton = new  RoundedButton("Select Directory");
        selectDirButton.setSize(190, 30);
        selectDirButton.setLocation(400, 100);
        selectDirButton.setFont(small);
        add(selectDirButton);
		
		
		Remove = new RemoveButton("Remove");
        Remove.setSize(100, 30);
        Remove.setLocation(600, 100);
		Remove.setBackground(Color.red);
        Remove.setFont(small);
        add(Remove);
		Remove.addActionListener(e -> {
            // calling method to display file chooser option and saving it in string 
			 String s1=txt1.getText();
            txt1.setText("");
			JOptionPane.showMessageDialog(txt1, "Removed Folder : "+s1);
			
        });
		
		// to add remove button at Runtime
    for(int y=160,i=0; i<5; i++){ // iss line wala i variable local h
		remove[i] = new RemoveButton("Remove");
        remove[i].setSize(100, 30);
        remove[i].setLocation(600, y); 
		remove[i].setBackground(Color.red);
        remove[i].setFont(small);
		y+=60;
      }
	  
	  
	  
	  

         selectDirButton.addActionListener(e -> {
            firstPath = getPath(); // calling method to display file chooser option and saving it in string 
			txt1.setText(firstPath);
        });

        AddMoreDir = new  RoundedButton("Add More");
        AddMoreDir.setSize(130, 35);
        AddMoreDir.setLocation(200, 450);
        AddMoreDir.setFont(small);
        add(AddMoreDir);


        Save = new  RoundedButton("Start Monitering");
        Save.setSize(150, 35);
        Save.setLocation(400, 450);
        Save.setFont(small);
        add(Save);
		
		
		
		
		
Save.addActionListener(e ->{
		
		
		  recievePath[0]=txt1.getText();
		for(pathCounter=0;pathCounter<=veryimportantCounter;pathCounter++){
			try{
			recievePath[pathCounter+1]=tx[pathCounter].getText();
			}
			catch(Exception e2){
				JOptionPane.showMessageDialog(null, "Something went Wrong Try Again");
			}
		} 
        String path[] = recievePath;
        String pathseparator = System.getProperty("path.separator");
           JOptionPane.showMessageDialog(null,"Directories Saved for Monitering");
        String joinedpaths= String.join(pathseparator,path);
        String command = "setx DDAS_DIRECTORIES \"" + joinedpaths+ "\"";
        try
		{
        BufferedWriter writer = new BufferedWriter(new FileWriter("setpath.bat"));
            writer.write(command);
            writer.close();
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","start","setpath.bat");
			Process process = pb.start();
			process.waitFor();
            System.out.println("environment path variable set to " + joinedpaths);
        } 
		catch (IOException | InterruptedException ex) 
		{
            throw new RuntimeException(ex);
        }		
		
		});



        AddMoreDir.addActionListener(e -> {
            if (i < 5) {
                if (i > 0 && tx[i - 1].getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill above Directory..");
                } else {
                    y += 60;
                    tx[i] = new RoundedTextField(20);
                    tx[i].setSize(220, 35);
                    tx[i].setLocation(140, y);
                    add(tx[i]);
                    tx[i].setEditable(false);
                    
					veryimportantCounter=i;
				    
                    b[i] = new  RoundedButton("Select Directory");
                    b[i].setSize(190, 30);
                    b[i].setFont(small);
                    b[i].setLocation(400, y);
   	  // calling method to display file chooser option and saving it in string
                    add(b[i]);
					add(remove[i]);
                    check[i]=true;
					

                    int index = i; // Save the current index to use in the lambda
                    b[index].addActionListener(e1 -> {
                        s[index] = getPath();
                        if (s[index] != null)
                            tx[index].setText(s[index]); // Update text field with selected path
                    });
					
                    remove[i].addActionListener(e12 -> {
					  for(j=0;j<5;j++){
						if(e12.getSource()==remove[j]){
                if (tx[j] != null) { // Ensure tx[currentIndex] is initialized
                    String s1 = tx[j].getText();
                    tx[j].setText(""); // Clear the text field
                    JOptionPane.showMessageDialog(tx[j], "Removed Folder: " + s1);
                } else {
                    JOptionPane.showMessageDialog(null, "No directory to remove.");
                }
						}
					  }
            });
			
                    i++;
                    revalidate();
                    repaint();
					
                }
            } else {
                JOptionPane.showMessageDialog(null, "Maximum number of fields reached.");
            }
        });
    }




    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method to ensure proper painting
        g.drawImage(img, 0, 0, this);
		
		
    }

    public String getDefaultDownloadPath() {
        // Get the user's home directory and append the Downloads folder
        return Paths.get(System.getProperty("user.home"), "Downloads").toString();
    }

    // Method for FileChooser
    String getPath() {
        JFileChooser fileChooser1 = new JFileChooser();
        fileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser1.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
            return fileChooser1.getSelectedFile().getAbsolutePath();

        return null; // Handle the case when no directory is selected
    }
}


class Ext extends JPanel{
	 RoundedButton chrome ,edge, firefox;
	   ImageIcon imgic0,imgic1,imgic2,imgic3;
	 Image img0;
   Ext(){
	   setLayout(null);
	   imgic0 = new ImageIcon("testit.jpg");
       img0 = imgic0.getImage();
		 Font f2=new Font("",Font.BOLD,16);
		
		imgic1 = new ImageIcon("chrome.png");
		
		 imgic2 = new ImageIcon("edge.png");
        //img2 = imgic2.getImage();
		
		imgic3 = new ImageIcon("firefox.png");
        //img3 = imgic3.getImage();
		
	     JLabel l4=new JLabel("Add Extension to your Browser in One Click");
         l4.setBounds(160,80,500,80);
	   l4.setFont(new Font("Roboto", Font.PLAIN, 25));
	   //l4.setForeground(Color.Black);
	   add(l4);
  
 		   
	   chrome=new  RoundedButton("Chrome");
	   chrome.setBounds(170,200,150,80);
	   chrome.setFont(f2);
	   add(chrome);
	   
	   edge=new  RoundedButton("Edge");
	    edge.setBounds(450,200,150,80);
		edge.setFont(f2);
	   add(edge);
	   
	   //firefox=new  RoundedButton(imgic3);
	  // add(firefox);
	   
   }
   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method to ensure proper painting
        g.drawImage(img0, 0, 0, this);
    }
   
}


class ChromeInstructionPanel extends JPanel{
	
	   RoundedButton bk;
	ChromeInstructionPanel(){
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		bk=new  RoundedButton("                                                                  back                                                       ");
		bk.setBounds(500,20,800,50);
		//bk.setLocation(500,20);
		add(bk);
		
		add(createStep("Step 1: Open Chrome Browser."));
		add(createImageLabel("step1.png"));
		add(createStep(""));
		add(createStep(""));
		add(createStep(" Step 2: Access Extensions PageDescription: "));
		add(createStep(""));
		
		add(createStep("Click on the Extension option at the top-right corner of Chrome."));
		add(createImageLabel("stemainbodypanel.png"));
		add(createStep(""));
		add(createStep(""));
		
		add(createStep("Step 3: Click on Manage Extensions "));
		add(createStep(""));
		add(createImageLabel("step3.png"));
		add(createStep(""));add(createStep(""));
		
		add(createStep("Step 4: Turn on Developer OPtion"));
		add(createStep(""));
		add(createImageLabel("step4.png"));
		add(createStep(""));
		add(createStep(""));
		add(createStep("Step 5: click on Load unpacked"));
		add(createStep(""));
		add(createImageLabel("step5.png"));
		
		
	}
	
	
	
	// To create Label or Step Instruction
	 private static JLabel createStep(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    // Method to create an image label
    public static JLabel createImageLabel(String path) {
        ImageIcon icon = new ImageIcon(path);
        JLabel label = new JLabel(icon);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }
	
	
}

 class RoundedTextField extends JTextField {
    
    private Color borderColor;
    private Color defaultBackgroundColor;
    private Color focusedBackgroundColor;
    private Color unfocusedBackgroundColor;
    private Color placeholderColor;

    public RoundedTextField(int columns) {
        super(columns);

        // Define colors
        defaultBackgroundColor = new Color(230, 240, 255); // Light blue for default background
        focusedBackgroundColor = new Color(200, 220, 255); // Slightly darker blue when focused
        unfocusedBackgroundColor = new Color(230, 240, 255); // Light blue when not focused
        borderColor = new Color(120, 180, 255); // Premium blue border
        placeholderColor = new Color(150, 170, 190); // Light gray for placeholder

        setBackground(defaultBackgroundColor); // Initial background color
        setForeground(Color.DARK_GRAY); // Text color
        setFont(new Font("Arial", Font.PLAIN, 14)); // Font style

        setOpaque(false); // Make it transparent to support custom painting
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Padding inside text field

        // Focus listener to handle background change
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setBackground(focusedBackgroundColor); // Change background on focus
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(unfocusedBackgroundColor); // Revert to unfocused background
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Smooth rounded background

        super.paintComponent(g); // Draw text on top
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Premium border color
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(2)); // Thicker border for modern look
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Smooth rounded border

        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 20, 10, 20); // Padding inside text field
    }

    public void setPlaceholderText(String text) {
        setText(text);
        setForeground(placeholderColor); // Set placeholder color
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(text)) {
                    setText(""); // Clear placeholder when focused
                    setForeground(Color.DARK_GRAY); // Normal text color
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(text); // Restore placeholder when not focused
                    setForeground(placeholderColor);
                }
            }
        });
    }
}


 class RoundedButton extends JButton {

    private Color defaultBackgroundColor;
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;
    private Color borderColor;
    private Color shadowColor;
    
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); // Remove default button fill
        setFocusPainted(false);      // Remove default focus border
        setForeground(new Color(255, 255, 255));  // Text color

        // Define colors
        defaultBackgroundColor = new Color(94, 114, 235); // Default premium blue
        hoverBackgroundColor = new Color(60, 85, 160);    // Darker on hover
        pressedBackgroundColor = new Color(40, 60, 120);  // Darker on press
        borderColor = new Color(180, 180, 180);           // Light gray border
        shadowColor = new Color(220, 220, 220);           // Light shadow

        setBackground(defaultBackgroundColor); // Set the initial background color

        // Mouse listener for hover and press effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackgroundColor); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultBackgroundColor); // Revert to default when not hovering
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackgroundColor); // Change color on press
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(hoverBackgroundColor); // Back to hover color when released
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create shadow effect
        g2.setColor(shadowColor);
        g2.fillRoundRect(4, 4, getWidth() - 8, getHeight() - 8, 30, 30); // Slight shadow

        // Draw background with gradient effect
        GradientPaint gradient = new GradientPaint(0, 0, getBackground(), 0, getHeight(), getBackground().brighter());
        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Smooth rounded rectangle

        super.paintComponent(g); // Draw the text on top of the background

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Premium border
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(2)); // Thicker border for a modern look
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        return new Insets(12, 20, 12, 20); // Padding for the rounded button
    }
}

 class RemoveButton extends JButton {

    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public RemoveButton(String text) {
        super(text);
        setContentAreaFilled(false); // Remove default button fill
        setFocusPainted(false);      // Remove default focus border
        setForeground(Color.WHITE);  // Text color
        setBackground(Color.red); // Default background color (red)

        hoverBackgroundColor = new Color(214, 60, 60);  // Hover color (darker red)
        pressedBackgroundColor = new Color(175, 40, 40); // Pressed color (darkest red)

        // Add hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackgroundColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground( Color.red); // Back to default red when hover ends
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