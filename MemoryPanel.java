import java.awt.*;
import java.awt.event.*;




public class MemoryPanel extends Panel { 
	
		
	public static int nbCaseH,nbCaseL;
	final static int largeurCard=105, hauteurCard=165, setnb = 53;	
	public static Card[] tc;
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
			quellecase2 = r.nextInt((nbCaseL*nbCaseH)-1);
			quellecase1 = r.nextInt((nbCaseL*nbCaseH)-1);
			String nomCarte = String.valueOf(r.nextInt(setnb));
			// Etant donné qu'on tire des cartes au hasard le jeu peut être plus ou moins facile ...(si on tire plusieurs fois des paires de roi, par exemple)
			
			//On parcourt le tableau a la recherche d'une place libre pour la carte 1 , si la place de départ est occupée.
			//On aurait pu aussi retirer une carte au hasard mais cela est risqué car on a toujours une petite prob. de tomber toujours sur une case occupée
			//Bien que cette prob. soit quasiment nulle au bout de 10 boucles, nous avons choisi ici la sécurité.
			while((tc[quellecase1] != null))
			{
				if(quellecase1 < (nbCaseL*nbCaseH)-1)
				{
					quellecase1++;
				}
				else
				{
					quellecase1 = 0;
				}
			}
			
			//Maintenant on cherche une place pour la carte n2. Attention ! Veillons aussi à ne pas placer la carte 1 et la 2 au même endroit !! 
			while((tc[quellecase2] != null) || (quellecase1 == quellecase2))
			{
				if(quellecase2 < (nbCaseL*nbCaseH)-1)
				{
					quellecase2++;
				}
				else
				{
					quellecase2 = 0;
				}
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
	public static void verifier()
	{
		int val1=0, val2=0;

		int m = 1;		
		for(int j=0 ; j < (nbCaseL*nbCaseH) ; j++)
		{			
			
			if(tc[j].cachee == false )
			{
				if(val1 == 0)val1= j ;
				else val2 = j;		
			}
			
			
		}
		
		if((m == 1) && (tc[val1].carte != tc[val2].carte))
		{
			tc[val1].cachee = true;
			tc[val2].cachee = true;
			System.out.println("ici m ==A1");
		}
		
		
	}


	
}
