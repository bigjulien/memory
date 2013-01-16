import java.awt.*;
import java.awt.event.*;




public class MemoryPanel extends Panel { 
	
		
	public static int nbCaseH,nbCaseL;
	final static int largeurCard=105, hauteurCard=165, setnb = 53;	
	public static Card[] tc;
	private int[] tableauInit;
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
		
		//Pour ne pas avoir deux cartes identiques si possible donc la dim max est 100 (10*10)
		tableauInit = new int[nbCaseH*nbCaseL/2];		
		
		for(int z=0 ; z< (nbCaseL*nbCaseH)/2 ; z++)
		{
			tableauInit[z] = (r.nextInt(setnb));
			// -z car on ne compare qu'avec les nombres déja tirés
			for(int x=0 ; x< ((nbCaseL*nbCaseH)/2)-z ; x++)
			{
				if(tableauInit[z] == tableauInit[x])
				{					
					tableauInit[z]++;
				}
			}
			
		}

		
		for(int k=0 ; k<(nbCaseL*nbCaseH)/2 ; k++)
		{
			int quellecase1=0, quellecase2=0;
			quellecase2 = r.nextInt((nbCaseL*nbCaseH)-1);
			quellecase1 = r.nextInt((nbCaseL*nbCaseH)-1);
			String nomCarte=String.valueOf(tableauInit[k]);
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
		int ndecarte[] = new int[2];
		int m =1;
		
		for(int j=0 ; j < (nbCaseL*nbCaseH) ; j++)
		{			
			if(!(tc[j].cachee) && !(tc[j].trouvee))
			{
				
				ndecarte[m] = j;
				if(m==0) m =1;
				else m =0;	
			}
						
		}
		
		if((m==1)&&(tc[ndecarte[0]].carte != tc[ndecarte[1]].carte))
		{
			tc[ndecarte[0]].cachee = true;
			tc[ndecarte[1]].cachee = true;
			tc[ndecarte[0]].repaint();
			tc[ndecarte[1]].repaint();
		}
		if((m==1)&&(tc[ndecarte[0]].carte == tc[ndecarte[1]].carte))
		{
			tc[ndecarte[0]].trouvee = true;
			tc[ndecarte[1]].trouvee = true;
		}

		
		
	}


	
}
