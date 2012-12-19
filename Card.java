import java.awt.*;

class Card extends Canvas{
//dessiner une image
	private int COTECASE=30;
	private int largeurCard;
	private int hauteurCard;

	public Card(int largeur, int hauteur){

		largeurCard=largeur;
		hauteurCard=hauteur;
		// fixer sa dimension
		setSize(largeurCard*COTECASE,hauteurCard*COTECASE);
		// la rendre visible
		setVisible(true);
		// choisir la couleur de fond
		setBackground(Color.black);
		// choisir la couleur des caractères
		setForeground(Color.white);
	}//fin de public Card


	public void paint(Graphics g){
	//dessiner une image sur la carte


	}

}//fin de la class Card
