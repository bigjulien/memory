import java.awt.*;
import java.awt.event.*;


public class MemoryFrame extends Frame {
MenuBar barreMenu = new MenuBar();
Menu game = new Menu("Game");
MenuItem nouvelle_partie = new MenuItem("Nouvelle partie");
MenuItem quitter = new MenuItem("Quitter");
Label l = new Label("Infos");
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
	setVisible(true);
	// la rendre visible
	this.pack();
	// Eviter l'étalement
	}

}

