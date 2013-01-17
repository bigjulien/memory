import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class ZDialog extends JDialog {
    private ZDialogInfo zInfo = new ZDialogInfo();
    private MemoryFrame MemF;
    private boolean sendData;
    private JLabel colonneLabel, ligneLabel, varianteLabel,  icon;
    private JRadioButton tranche1, tranche2, tranche3;
    private JComboBox colonne,ligne;
    
    
    public ZDialog(JFrame parent, String title, boolean modal){
	super(parent, title, modal);
	this.setSize(600, 300);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	this.initComponent();
    }
    
    public ZDialogInfo showZDialog(){
	this.sendData = false;
	this.setVisible(true);     
	return this.zInfo;     
    }
    

    
    private void initComponent(){
	//Icône
	icon = new JLabel(new ImageIcon("ressources/final.png"));
	JPanel panIcon = new JPanel();
	panIcon.setBackground(Color.white);
	panIcon.setLayout(new BorderLayout());
	panIcon.add(icon);
	
	//Lignes
	JPanel panLigne = new JPanel();
	panLigne.setBackground(Color.white);
	panLigne.setPreferredSize(new Dimension(220, 80));
	panLigne.setBorder(BorderFactory.createTitledBorder("Lignes: "));
	ligne = new JComboBox();
	
	ligne.addItem("2");
	ligne.addItem("3");
	ligne.addItem("4");
	ligne.addItem("5");
	ligneLabel = new JLabel("Nombre de lignes: ");
	panLigne.add(ligneLabel);
	panLigne.add(ligne);
	
	//colonnes
	JPanel panColonne = new JPanel();
	panColonne.setBackground(Color.white);
	panColonne.setPreferredSize(new Dimension(220, 80));
	panColonne.setBorder(BorderFactory.createTitledBorder("Colonnes: "));
	colonne = new JComboBox();
	
	colonne.addItem("2");
	colonne.addItem("4");
	colonne.addItem("6");
	colonne.addItem("8");
	colonne.addItem("10");
	colonneLabel = new JLabel("Nombre de colonnes: ");
	panColonne.add(colonneLabel);
	panColonne.add(colonne);
	
	//Les variantes de jeu
	JPanel panVariante = new JPanel();
	panVariante.setBackground(Color.white);
	panVariante.setBorder(BorderFactory.createTitledBorder("Les différentes variantes du jeu MEMORY"));
	panVariante.setPreferredSize(new Dimension(440, 120));
	tranche1 = new JRadioButton("Simple");
	tranche1.setSelected(true);
	tranche2 = new JRadioButton("Décalage des cartes à chaque tour");
	tranche3= new JRadioButton("Temps limité");
	ButtonGroup bg = new ButtonGroup();
	bg.add(tranche1);
	bg.add(tranche2);
	bg.add(tranche3);
	panVariante.add(tranche1);
	panVariante.add(tranche2);	
	panVariante.add(tranche3);
	
	JPanel content = new JPanel();
	content.setBackground(Color.white);
	content.add(panColonne);
	content.add(panLigne);
	content.add(panVariante);
	
	


	
	JPanel control = new JPanel();
	JButton okBouton = new JButton("OK");
	
	okBouton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) { 
 	 	    System.out.println(ligne.getSelectedItem());
		    System.out.println(colonne.getSelectedItem());
		    new MemoryFrame(Traitement(getVariante()),Integer.valueOf((String)(ligne.getSelectedItem())),Integer.valueOf((String)((colonne.getSelectedItem()))));
		    dispose();
		}
		
		public String getVariante(){
		    return (tranche1.isSelected()) ? tranche1.getText() :
			(tranche2.isSelected()) ? tranche2.getText() :
			(tranche3.isSelected()) ? tranche3.getText() :

			tranche1.getText(); 
		}
		
		
	    });
	
	JButton cancelBouton = new JButton("Annuler");
	cancelBouton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
		    setVisible(false);
		}     
	    });
	
	control.add(okBouton);
	control.add(cancelBouton);
	
	this.getContentPane().add(panIcon, BorderLayout.WEST);
	this.getContentPane().add(content, BorderLayout.CENTER);
	this.getContentPane().add(control, BorderLayout.SOUTH);
    } 

    public int Traitement(String getVariante){
	if (getVariante==tranche1.getText()) return 0;
	if (getVariante==tranche2.getText()) return -1;
	else return 2;
    }
    
	
}
