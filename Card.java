import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

class Card extends Canvas {

	BufferedImage b;
	
	
	public void paint(Graphics g) {
		
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
