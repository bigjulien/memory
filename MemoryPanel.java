import java.awt.*;
import java.awt.event.*;


public class MemoryPanel extends Panel{
		
	private int nbCaseH, largeurCard, hauteurCard, nbCaseL;
	Card cr= new Card(105,165);
	
	public MemoryPanel(int nbCaseH, int nbCaseL)
	{		
		this.largeurCard=cr.largeur;
		this.hauteurCard=cr.hauteur;
		this.nbCaseH = nbCaseH;
		this.nbCaseL = nbCaseL;
		// fixer sa dimension
		setPreferredSize(new Dimension(largeurCard*nbCaseL,hauteurCard*nbCaseH));
		setLayout(new GridLayout(nbCaseH,nbCaseL));
		add(cr);
	}

	public void paint (Graphics g)
	{
		
		setBackground(Color.white);
		g.setColor(Color.black);
		for(int i=0 ; i<=nbCaseL ; i++)
		{
			g.drawLine(i*largeurCard,0, i*largeurCard,nbCaseH*hauteurCard);
			
		} 

		for(int j=0; j<=nbCaseH; j++)
		{
			g.drawLine(0,j*hauteurCard,nbCaseL*largeurCard,j*hauteurCard);
		}	
		
	 }

}
