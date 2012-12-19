import java.awt.*;
import java.awt.event.*;


public class MemoryFrame extends Frame {
MenuBar barreMenu = new MenuBar();
Menu game = new Menu("Game");
MenuItem nouvelle_partie = new MenuItem("Nouvelle partie");
MenuItem quitter = new MenuItem("Quitter");
Label l = new Label("Infos");
Panel p = new MemoryPanel(6,6);
    // fermer la fenetre avec un bouton terminer
    public MemoryFrame(){	  
	// la rendre visible
	
	setLayout(new BorderLayout());
	add(l,BorderLayout.SOUTH);
	add(p,BorderLayout.CENTER);
	
	// on configure la barre de menu
	this.setMenuBar(barreMenu);
	barreMenu.add(game);
	game.add(nouvelle_partie);
	game.add(quitter);
	

	

	// choisir la couleur des caractères

	// écrire du texte dans l'entete de la fenetre
	setTitle("Memory game");
	
	
	quitter.addActionListener(new ActionQuitter());	
	setVisible(true);
	// la rendre visible
	this.pack();
	
	

	}

}

