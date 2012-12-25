import java.awt.*;
import java.awt.event.*;


public class MemoryFrame extends Frame {

	Label l = new Label("Pas d'informations a afficher");
	MenuBar barreMenu = new MenuBar();
	Menu game = new Menu("Game");
	MenuItem nouvelle_partie = new MenuItem("Nouvelle partie");
	MenuItem quitter = new MenuItem("Quitter");
	Panel p = new MemoryPanel(4,7);

    
	public MemoryFrame(){
	
	
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
		
		this.pack();
		// Eviter l'étalement
		setResizable(false);
		// Eviter qu'il y ait de l'espace entre les cartes 
		setVisible(true);
		// la rendre visible
	}

}

