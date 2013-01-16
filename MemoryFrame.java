import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date; 
public class MemoryFrame extends Frame {

	Label l = new Label("Pas d'informations a afficher");
	MenuBar barreMenu = new MenuBar();
	Menu game = new Menu("Game");
	MenuItem nouvelle_partie = new MenuItem("Nouvelle partie");
	MenuItem quitter = new MenuItem("Quitter");
	
	//Vérifier que la dim <= 52*2
	Panel p = new MemoryPanel(4,7);

        Timer timer;
        int i = 60;
        
        
        
	public MemoryFrame(){
		timer  = new Timer();
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.CENTER);
		add(l,BorderLayout.SOUTH);
	
	
		// on configure la barre de menu
		setMenuBar(barreMenu);
		barreMenu.add(game);
		game.add(nouvelle_partie);
		game.add(quitter);
		
		quitter.addActionListener(new ActionQuitter());	
	
		setTitle("Memory game");
		timer.schedule(new TimerTask(){
  public void run(){
  l.setText(String.valueOf(i) );	  
  i--;
  }
  }, 1000);
		this.pack();
		// Eviter l'étalement
		setResizable(false);
		// Eviter qu'il y ait de l'espace entre les cartes 
		setVisible(true);
		// la rendre visible
	}

}

