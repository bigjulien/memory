import java.awt.*;
import java.awt.event.*;
public class MemoryPanel extends Panel{
	//Distribution des cartes
	
	private int nbCaseH, largeurCard, hauteurCard, nbCaseL;
	Card c= new Card(80,120);

	public MemoryPanel(int nbCaseH, int nbCaseL){
			
		this.largeurCard=c.largeur;
		this.hauteurCard=c.hauteur;
		this.nbCaseH = nbCaseH;
		this.nbCaseL = nbCaseL;
		// fixer sa dimension
		setPreferredSize(new Dimension(largeurCard*nbCaseL,hauteurCard*nbCaseH)); //ici est le problème
		
		// choisir la couleur de fond
		
	}//fin de public MemoryPanel.

	public void paint (Graphics g){
	setBackground(Color.white);
	g.setColor(Color.black);
	for(int i=0 ; i<nbCaseL ; i++){
		g.drawLine(i*largeurCard,0, i*largeurCard,nbCaseH*hauteurCard);
	} 

	for(int j=0; j<nbCaseH; j++){
		g.drawLine(0,j*hauteurCard,nbCaseL*largeurCard,j*hauteurCard);
	}	

	 }//fin du paint

}
