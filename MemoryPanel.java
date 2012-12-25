import java.awt.*;
import java.awt.event.*;


public class MemoryPanel extends Panel{
		
	private int nbCaseH,nbCaseL;
	final static int largeurCard=105, hauteurCard=165, setnb = 54;	
	public Card[] tc;
	java.util.Random r=new java.util.Random();
	java.util.Random r2=new java.util.Random();
	public MemoryPanel(int nbCaseL, int nbCaseH)
	{		
		this.nbCaseH = nbCaseH;
		this.nbCaseL = nbCaseL;
		// fixer sa dimension
		setPreferredSize(new Dimension((largeurCard+1)*nbCaseH,(hauteurCard+1)*nbCaseL));
		setLayout(new GridLayout(nbCaseL, nbCaseH));
		tc = new Card[nbCaseH*nbCaseL];
		for(int k=0 ; k<(nbCaseL*nbCaseH)/2 ; k++)
		{
			int quellecase1=0, quellecase2=0;
			quellecase2 = r2.nextInt((nbCaseL*nbCaseH)/2);
			quellecase1 = r2.nextInt((nbCaseL*nbCaseH)/2);
			String nomCarte = String.valueOf(r.nextInt(setnb));
			System.out.println(nomCarte);
			
			while((tc[quellecase1] != null) || (quellecase1 == quellecase2))
			{
				quellecase1++;
			}
			while((tc[quellecase2] != null) || (quellecase1 == quellecase2))
			{
				quellecase2++;
			}			
			tc[quellecase1] = new Card(nomCarte,true);
			tc[quellecase2] = new Card(nomCarte,true);			
		}
		
		for(int i=0 ; i < (nbCaseL*nbCaseH) ; i++)
		{
			add(tc[i]);
		}
			
		setBackground(Color.black);
		
	}

	
}
