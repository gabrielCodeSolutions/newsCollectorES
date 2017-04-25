package dioLinux;
public class Noticia {

	String link;
	String manchete;
	
	public Noticia(String link, String manchete) {
		this.link = link;
		this.manchete = manchete;
	}
	
	public String getLink() {
		return link;
	}

	public String getManchete() {
		return manchete;
	}

    @Override
    public String toString() {
        return manchete+"\n"+link+"\n";
    }
        
        

}
