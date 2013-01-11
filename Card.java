import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

class Card extends Canvas implements MouseListener{
	java.util.Random r=new java.util.Random();
	BufferedImage b;
	public String carte ;
	public boolean cachee, trouvee= false ;
	
	
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
	public void mouseReleased(MouseEvent e) {
		
		MemoryPanel.verifier();
		
	}
	
	public void mouseEntered(MouseEvent e) {}

	
	public void mouseExited(MouseEvent e) {}
	
	
	
	
	public void mouseClicked(MouseEvent e) {
	
}
	
}
