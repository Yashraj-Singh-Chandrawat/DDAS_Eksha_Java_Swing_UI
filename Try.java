 import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Fdemo extends JFrame implements ActionListener{
    
    JButton b1;
	
	
   HomePage hm;	
   Ab ab;
   Pane2 m;
      Container cn=getContentPane();
    CardLayout card; 

	Fdemo(){
		 setTitle(" Eksha .. DDAS SIH2024 (Team Rocket)");
		 card=new CardLayout();
		 setLayout(card);
	
		
        
		hm=new HomePage();
		add("Home",hm);
		
		ab=new Ab();
		add("about",ab);
		
		m=new Pane2();
		add("mainpage",m.frame);
		
		//m2=new Main12();
		//add("Mainpage2",m2);
		
		
			
		hm.startButton.addActionListener(this);
	    hm.aboutButton.addActionListener(this);
		ab.back1.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		// chatGPT check this code how can i access those two buttons 
		if(e.getSource() == hm.startButton){
			card.show(cn,"mainpage");
		}
		
		if(e.getSource() == hm.aboutButton){
			card.show(cn,"about");
		}
		if(e.getSource() == ab.back1){
			card.show(cn,"Home");
		}
	
	}
}

class HomePage extends JPanel{
	 
	 
	 ImageIcon img1,img2;
	 Image back,startpic;
	 RoundedButton startButton,aboutButton;
	HomePage (){
		
		 setLayout(null);
		
             
		setBackground(Color.blue);
	     img1=new ImageIcon("testit2.png");
		 back=img1.getImage();
		 
		 img2=new ImageIcon("start.gif"); // use it to add Image to start button
		
		JLabel welcomeLabel = new JLabel("Welcome to the Data Download Duplication Alert System");
		welcomeLabel.setBounds(50,430,700,50);
		welcomeLabel.setFont(new Font("Roboto", Font.PLAIN, 30));
	     
      	 // getContentPane().setBackground(new Color(0xf0f0f0));
       // add(welcomeLabel);


        startButton = new RoundedButton("Start");
		Font small =new Font("", Font.PLAIN, 16);
		startButton.setFont(small);

        aboutButton = new RoundedButton("About");
		aboutButton.setFont(small);
		startButton.setBounds(230,500,100,50);
        aboutButton.setBounds(470,500,100,50);    
		add(startButton);
        add(aboutButton);
       // add(buttonPanel, BorderLayout.SOUTH);
  
 
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(back,0,0,this);
		
		
	}
}


class Try{
	public static void main(String ar[]){
		
		Fdemo f =new Fdemo();
		 f.setVisible(true);
		 f.setBounds(550,250,800,700);
		 f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		  f.setResizable(false);
	}
}