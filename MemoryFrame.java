import java.awt.*;
import java.awt.event.*;


public class MemoryFrame extends Frame {
    // les dimensions de la fenetre
    private static final int LARGEUR = 300;
    private static final int HAUTEUR = 200;
    
    MenuBar barreMenu = new MenuBar();
    Menu game = new Menu("Game");
    MenuItem nouvelle_partie = new MenuItem("Nouvelle partie");
    MenuItem quitter = new MenuItem("Quitter");
    Card c= new Card(10,10);
    Panel p = new Panel();
    
    // fermer la fenetre avec un bouton terminer
    public MemoryFrame(){
	p.add(c);
	add(p);
	// fixer sa dimension
	setSize(LARGEUR,HAUTEUR);
	// la rendre visible
	setVisible(true);
	// choisir la couleur de fond
	setBackground(Color.gray);
	// choisir la couleur des caractères
	setForeground(Color.white);
	// écrire du texte dans l'entete de la fenetre
	setTitle("Memory game");
	// pour le placement du boutton
	setLayout(new FlowLayout());
	
	// on configure la barre de menu
	this.setMenuBar(barreMenu);
	barreMenu.add(game);
	game.add(nouvelle_partie);
	game.add(quitter);
	
	//action des menus déroulant
	quitter.addActionListener(new ActionQuitter());
	
	// la rendre visible
	pack();	
	setVisible(true);
	

	}
}

