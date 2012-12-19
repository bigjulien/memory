public class MemoryPanel extends Panel{
	//Distribution des cartes
	BufferedImage image;
	
	public Image(BufferedImage image){
		this.image = image ;
	}

	public void paint ( Graphics g ){
	int x = (getWidth() -image.getWidth() ) /2;
	int y = (getWidth() - image.getHeight() ) /2;
	g.drawImage(image,x,y,this);
	}
}
