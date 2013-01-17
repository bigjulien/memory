import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date; 
import java.lang.Math;
public class MemoryFrame extends Frame implements ActionListener {

		
	Panel p;
	Panel bas = new Panel();
        Timer timer;
        int i;
        static Score sc = new Score();
        static int ndevariante; 
        Label l = new Label();
        Label variante = new Label();
	MenuBar barreMenu = new MenuBar();
	Menu game = new Menu("Game");
	MenuItem nouvelle_partie = new MenuItem("Nouvelle partie");
	MenuItem quitter = new MenuItem("Quitter");
	MenuItem scores = new MenuItem("Scores");
        
	public MemoryFrame(int vari, int lignes, int col){
		
		
		
		p = new MemoryPanel(lignes, col);
		i = (int)Math.pow((lignes*col)/2,vari) ;
		timer  = new Timer();
	
		// on configure la barre de menu
		setMenuBar(barreMenu);
		barreMenu.add(game);
		setTitle("Memory game");
				  				
		setLayout(new BorderLayout());
		bas.setLayout(new BorderLayout());
		
		add(p, BorderLayout.CENTER);
		add(bas,BorderLayout.SOUTH);
		
  		
  		
  		
		game.add(nouvelle_partie);	
		if(vari == -1)
		{
			
			
			// correspond a la variante décalée
			ndevariante = -1;
			variante.setText("Variante du décalage");
			game.add(scores);
		}
		else if(vari == 0)
		{
			//Var standard
			ndevariante = 0;
			variante.setText("Variante classique");
			game.add(scores);
		}
		else
		{
			ndevariante = 1;
			
			variante.setText("Temps restreint");
			
		//Bien que peu élégante, cette écriture nous évite d'avoir a créer une nouvelle classe dans un nouveau fichier pour pas grand chose.
			timer.schedule(new TimerTask(){
					public void run(){
  		
					String trest = String.valueOf(i/60)+":"+String.valueOf(i%60)+" ";
					if(i<=30)
					{
						l.setForeground(Color.red);
					}
					l.setText(trest);	  
					i--;

					}}, 1,1000);
			
			bas.add(l, BorderLayout.WEST);
  		
  		}
  		game.add(quitter);
  		bas.add(variante, BorderLayout.EAST);
  		quitter.addActionListener(this);	
		nouvelle_partie.addActionListener(this);
		scores.addActionListener(this);
  		
		this.pack();
		// Eviter l'étalement
		setResizable(false);
		// Eviter qu'il y ait de l'espace entre les cartes 
		setVisible(true);
		// la rendre visible
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		Object source = e.getSource();
		if(source == quitter) System.exit(0);
		if(source == scores ) sc.afficher();
	}
		

}

