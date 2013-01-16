import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date; 
public class MemoryFrame extends Frame {

		
	Panel p;
	Panel bas = new Panel();
        Timer timer;
        int i;
        
        Label l = new Label("");
        Label variante = new Label("Variante standard");
	MenuBar barreMenu = new MenuBar();
	Menu game = new Menu("Game");
	MenuItem nouvelle_partie = new MenuItem("Nouvelle partie");
	MenuItem quitter = new MenuItem("Quitter");

        
	public MemoryFrame(int secondes, int lignes, int col){
		p = new MemoryPanel(lignes, col);
		i = secondes;
		timer  = new Timer();
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.CENTER);
		add(bas,BorderLayout.SOUTH);
		bas.setLayout(new BorderLayout());
		bas.add(l, BorderLayout.WEST);
		bas.add(variante, BorderLayout.EAST);
	
	
		// on configure la barre de menu
		setMenuBar(barreMenu);
		barreMenu.add(game);
		game.add(nouvelle_partie);
		game.add(quitter);
		
		quitter.addActionListener(new ActionQuitter());	
	
		setTitle("Memory game");
		//Bien que peu élégante, cette écriture nous évite d'avoir a créer une nouvelle classe dans un nouveau fichier pour pas grand chose.
		timer.schedule(new TimerTask(){
  		public void run(){
  		
  			String trest = String.valueOf(i/60)+":"+String.valueOf(i%60);
  			if(i<=30)
  			{
  				l.setForeground(Color.red);
  			}
  			l.setText(trest);	  
  			i--;

  		}}, 1,1000);
		this.pack();
		// Eviter l'étalement
		setResizable(false);
		// Eviter qu'il y ait de l'espace entre les cartes 
		setVisible(true);
		// la rendre visible
	}

}

