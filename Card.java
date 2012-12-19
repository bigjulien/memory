import java.awt.*;
import java.awt.event.*;
class Card extends Canvas{
//dessiner une image
	
	public int largeur;
	public int hauteur;

	public Card(int largeur, int hauteur){

		this.largeur=largeur;
		this.hauteur=hauteur;
		// fixer sa dimension
		setPreferredSize(new Dimension(largeur,hauteur));
	
	}//fin de public Card


	public void paint(Graphics g){
	//dessiner une image sur la carte


	}

}//fin de la class Card
