import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

class Card extends Canvas {

	BufferedImage b;
	public int largeur;
	public int hauteur;
	
	public Card(int largeur, int hauteur){
		this.largeur=largeur;
		this.hauteur=hauteur;
		// fixer sa dimension
		setSize(new Dimension(hauteur, largeur));
		
	}
	
	public void paint(Graphics g) {
		setBackground(Color.red);
		try
		{
			b = ImageIO.read(new File("ressources/a01.jpg"));
			g.drawImage(b,0,0,null);
		}
		catch(IOException e)
		{
			System.out.println("ERREUR");
		}
		//dessiner une image sur la carte
		
	}
	

	
}
