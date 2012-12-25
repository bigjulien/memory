import java.awt.*;
import java.awt.event.*;


public class MemoryPanel extends Panel{
		
	private int nbCaseH,nbCaseL;
	final static int largeurCard=105, hauteurCard=165;	
	
	public MemoryPanel(int nbCaseL, int nbCaseH)
	{		
		this.nbCaseH = nbCaseH;
		this.nbCaseL = nbCaseL;
		// fixer sa dimension
		setPreferredSize(new Dimension((largeurCard+1)*nbCaseH,(hauteurCard+1)*nbCaseL));
		setLayout(new GridLayout(nbCaseL, nbCaseH));
			
		for(int k=0 ; k<nbCaseL*nbCaseH ; k++)
		{
			add(new Card());			
		}
		setBackground(Color.black);
		
	}
	
}
