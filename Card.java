import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

class Card extends Canvas implements MouseListener{
	java.util.Random r=new java.util.Random();
	BufferedImage b;
	private String carte ;
	public boolean cachee ;
	
	
	Card(String nom,boolean pf)
	{	
		this.carte = nom;
		this.cachee = pf;
		addMouseListener(this);	
	
	}
	public void paint(Graphics g) {
		
		try
		{
			if(cachee)
			{
				b = ImageIO.read(new File("ressources/font.jpg"));
			}
			else
			{
				b = ImageIO.read(new File("ressources/"+carte+".jpg"));
			}
			g.drawImage(b,0,0,null);
		}
		catch(IOException e)
		{
			System.out.println("Je n'arrive pas a lire le fichier jpeg");
		}
		//dessiner une image sur la carte
		
	}
	

	public void mousePressed(MouseEvent e) {
				
		cachee = false;		
		repaint();
		
	}

	
	public void mouseEntered(MouseEvent e) {}

	
	public void mouseExited(MouseEvent e) {}
	
	
	public void mouseReleased(MouseEvent e) {
		int[] numdecarte= new int[1];
		int m = 0;
		for(int j=0 ; j < (MemoryPanel.nbCaseL*MemoryPanel.nbCaseH)-1 ; j++)
		{
			int nbcartesret = 0;
			if(MemoryPanel.tc[j].cachee == false)
			{
				nbcartesret++;
				numdecarte[m] = j ;
				m++;
			}
		}
		if((m == 2) && (MemoryPanel.tc[numdecarte[0]].carte != MemoryPanel.tc[numdecarte[1]].carte))
		{
			MemoryPanel.tc[numdecarte[0]].cachee = true;
			MemoryPanel.tc[numdecarte[1]].cachee = true;
		}
	
	
}
	
	public void mouseClicked(MouseEvent e) {
	
}
	
}
