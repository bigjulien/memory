import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

class Card extends Canvas {
	java.util.Random r=new java.util.Random();
	BufferedImage b;
	private String carte ;
	public boolean cachee ;
	
	
	Card(String nom,boolean pf)
	{	
		this.carte = nom;
		this.cachee = pf;
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
	

	
}
