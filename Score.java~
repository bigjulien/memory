import java.io.*;
import java.util.*;

class Score {
	// Le nom de fichier 
	private String nomFich="top5.bin";
	private String nomFich2="dscore.bin";
	public int scorePrecedent;
	public int scoreCourant;
	Score(int sc) {
		this.scoreCourant = sc;
		
	}
	
	public void addFichier5(int sc)
	{
		try{// Attention os n'est connue que dans ce bloc try. C'est la même chose que pour le i d'un for
			DataOutputStream os = new DataOutputStream(new FileOutputStream(nomFich));// On branche le tuyau (Stream) vers 1 fichier (autre ex = pipe entre processus ) Piped Output Stream
			DataInputStream is = new DataInputStream(new FileInputStream(nomFich)) ;
			try {
				for(int i = 0; i<5 ; i++)
				{					
					if(sc < is.readInt())
					{
						os.writeInt((byte)sc);
						break;
					}
				}
			}
			catch( IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					os.close();
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

	
	public void addDscore(int sc)
	{
		try{// Attention os n'est connue que dans ce bloc try. C'est la même chose que pour le i d'un for
			DataOutputStream os = new DataOutputStream(new FileOutputStream(nomFich2));// On branche le tuyau (Stream) vers 1 fichier (autre ex = pipe entre processus ) Piped Output Stream
			
			try {
				os.writeInt((byte)sc);
			}
			catch( IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					os.close();
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
			DataOutputStream os = new DataOutputStream(new FileOutputStream(nomFich));// On branche le tuyau (Stream) vers 1 fichier (autre ex = pipe entre processus ) Piped Output Stream
			DataOutputStream os2 = new DataInputStream(new FileInputStream(nomFich2)) ;
			try {
				for(int i = 0; i<5 ; i++)
				{
					os.writeInt((byte)0);
				
				}
				os2.writeInt((byte)0);
			}
			catch( IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					os.close();
					os2.close();
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
	
	String st="";
	try
	{
		DataInputStream is = new DataInputStream( new FileInputStream(nomFich)) ;
		boolean finf = false;
		while(!finf)
		{
			try
			{
				for(int i=0; i<4 ; i++)
				{
					st += is.readInt()+"\n";
				}
			}
			catch(EOFException e){ finf = true; }
			catch(IOException e){ e.printStackTrace();}
		}
		try { is.close(); } catch(IOException e) {e.printStackTrace();}
			
	}
	catch(FileNotFoundException e){ e.printStackTrace();}
	return st;	
	}
	
	public String getPrecedent()
	{
	int value;
	int progression;
	String st="";
	try
	{
		DataInputStream is = new DataInputStream( new FileInputStream(nomFich)) ;
		boolean finf = false;
		while(!finf)
		{
			try
			{
				value = is.readInt();
			}
			catch(EOFException e){ finf = true; }
			catch(IOException e){ e.printStackTrace();}
		}
		try { is.close(); } catch(IOException e) {e.printStackTrace();}
			
	}
	catch(FileNotFoundException e){ e.printStackTrace();}
	progression = value - sc ;
	st +=  "Score: "+String.valueOf(value)+"\nProgression: "+String.valueOf(progression);
	return st;	
	}		

}
