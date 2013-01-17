//On notera que les scores les plus faibles sont les meilleurs ...
import java.io.*;
import java.util.*;
import java.util.Arrays.*;
import java.awt.*;
import java.awt.event.*;
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

class Score extends JFrame implements ActionListener{
	// Le nom de fichier 
	private String nomFich="top5.bin";
	private String nomFich2="dscore.bin";
	public int scoreCourant = 0;
	JLabel l = new JLabel("");
	JButton ok = new JButton("OK"); 
	JButton raz = new JButton("RAZ");
	JPanel p= new JPanel();

			
	
	public void afficher()
	{
		setLayout(new BorderLayout());
		p.setLayout(new FlowLayout());		
		add(l, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		p.add(ok);
		p.add(raz);

		l.setText(getTopFive());
		 
		pack();
		ok.addActionListener(this);
		raz.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == ok)this.dispose();
		if(source == raz){
			reinit();
			l.setText(getTopFive());
		}
	}
	
	public void addFichier5(int sc)
	{
		int[] provisoire = new int[5];
		try
		{
			DataInputStream is = new DataInputStream(new FileInputStream(nomFich));
			
			try 
			{				
				for(int i = 0; i<5 ; i++)
				{			
					provisoire[i]= is.readInt();
				}
				
			}
			catch( IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					is.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}		
		catch (FileNotFoundException e){
			System.out.println("Erreur de lecture de fichier");
			e.printStackTrace();
		}		
		
		Arrays.sort(provisoire);
	

		try
		{
			DataOutputStream os = new DataOutputStream(new FileOutputStream(nomFich));
			try 
			{
				boolean unefois = false;				
				for(int i = 0; i<5 ; i++)
				{
					if((provisoire[i] == 0 || sc < provisoire[i])&& unefois == false)
					{
						os.writeInt((byte)sc);
						unefois = true;
					}
					else
					{
						os.writeInt((byte)(provisoire[i]));
					}
				}				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					os.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}		
		catch (FileNotFoundException e)
		{
			System.out.println("Erreur de lecture de fichier");
			e.printStackTrace();
		}		

	}	
	
	public void addDscore(int sc)
	{
		try{// Attention os n'est connue que dans ce bloc try. C'est la même chose que pour le i d'un for
			DataOutputStream os1 = new DataOutputStream(new FileOutputStream(nomFich2));// On branche le tuyau (Stream) vers 1 fichier (autre ex = pipe entre processus ) Piped Output Stream
			
			try {
				os1.writeInt((byte)sc);
			}
			catch( IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					os1.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		catch (FileNotFoundException e){
			System.out.println("Erreur de lecture de fichier");
			e.printStackTrace();
		}		

	}

	public void reinit()
	{
		try{
			// Attention os n'est connue que dans ce bloc try. C'est la même chose que pour le i d'un for
			DataOutputStream os2 = new DataOutputStream(new FileOutputStream(nomFich));// On branche le tuyau (Stream) vers 1 fichier (autre ex = pipe entre processus ) Piped Output Stream
			DataOutputStream os3 = new DataOutputStream(new FileOutputStream(nomFich2)) ;
			try {
				for(int i = 0; i<5 ; i++)
				{
					os2.writeInt((byte)0);
				
				}
				os3.writeInt((byte)0);
			}
			catch( IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					os2.close();
					os3.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("Erreur de lecture de fichier");
			e.printStackTrace();
		}		

	}
	
	public String getTopFive()
	{
	
	String st = "<html><h1 color='red'>Vos 5 meilleurs scores: </h1><p>";
	try
	{
		DataInputStream is1 = new DataInputStream( new FileInputStream(nomFich)) ;
		boolean finf = false;
		while(!finf)
		{
			try
			{
				
				for(int i=0; i<4 ; i++)
				{
					st += is1.readInt()+"<br/>";
				}
				
			}
			catch(EOFException e){ finf = true; }
			catch(IOException e){ e.printStackTrace();}
		}
		try { is1.close(); } catch(IOException e) {e.printStackTrace();}
			
	}
	
	catch(FileNotFoundException e){ e.printStackTrace();}
	st += "</p></html>";
	return st;	
	}
	
	public String getPrecedent()
	{
	int value=0;
	int progression;
	String st="";
	try
	{
		DataInputStream is3 = new DataInputStream( new FileInputStream(nomFich)) ;
		boolean finf = false;
		while(!finf)
		{
			try
			{
				value = is3.readInt();
			}
			catch(EOFException e){ finf = true; }
			catch(IOException e){ e.printStackTrace();}
		}
		try { is3.close(); } catch(IOException e) {e.printStackTrace();}
			
	}
	catch(FileNotFoundException e){ e.printStackTrace();}
	progression = value - scoreCourant ;
	st +=  "<html>Score: "+String.valueOf(value)+"<br/>Progression: "+String.valueOf(progression)+"</html>";
	return st;	
	}		

}
