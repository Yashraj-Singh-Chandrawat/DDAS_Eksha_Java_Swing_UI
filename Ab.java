import javax.swing.*;
import java.awt.*;

public class Ab extends JPanel {
    
	
	ImageIcon img1;
	 Image back;
	 JButton back1;

    public Ab() {
        setLayout(null);
		
		img1=new ImageIcon("wall.jpg");
		 back=img1.getImage();
        
        // Create a text area to display team information
        JTextArea teamInfoArea = new JTextArea();
        teamInfoArea.setEditable(false);
        teamInfoArea.setFont(new Font("Arial", Font.PLAIN, 16));
        teamInfoArea.setText("\n\nData Download Duplication Alert System (DDAS) is an efficient tool developed for the Smart India Hackathon (SIH)\n"+
		"to prevent duplicate data downloads. It alerts users about potential duplicates based on file names and sizes, and performs hash-based   \n"+
 		"comparisons for accuracy. Created by IIST College students, the system enhances data management and optimizes resource usage.\n"+
		
		"\nDeveloped By:\n\n"
                + "- Yashraj Singh Chandrawat: Frontend and Backend Support\n"
                + "- Ramu Kushwah: Frontend and Backend Support\n"
                + "- Vikas Patel: Backend , Idea creator(Founder)and Lead Backend  \n"
                + "- Mahendra and Rahul as Supporting Team Members");
        
        // Add a scroll pane to the text area
        JScrollPane scrollPane = new JScrollPane(teamInfoArea);
		  scrollPane.setBounds(10, 50, 950, 300); 
        add(scrollPane);
        
			 
	
        // Optionally, set background color or other styles
       // setBackground(Color.blue);
	   
	   back1=new JButton("Back");
	   back1.setBounds(400,400,100,50);
	   add(back1);
    }
	 public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(back,0,0,this);
		
		
	}
	
	
}
