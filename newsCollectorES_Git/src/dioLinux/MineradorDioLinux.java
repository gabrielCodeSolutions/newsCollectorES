import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by gabriel and marquinhos on 15/04/17.
 */
public class MineradorDioLinux{
 private Document d;
 private ArrayList<Noticia> listaDeNoticiasFinais;
 
 public MineradorDioLinux(){
	 listaDeNoticiasFinais = new ArrayList<Noticia>();
 }

	public void conectaDioLinux() throws IOException {
        d = Jsoup.connect("http://www.diolinux.com.br/").get();
    }
    public String processaDados() {
        listaDeNoticiasFinais.clear();
        Elements listaNoticiasDesordenadaTextoCompleto = d.select("div.item-title a ");
        Elements listaNoticiasOrdenadas = d.select("ul.posts li a ");
        String txt = new String();
        for (int i = 0; i < listaNoticiasOrdenadas.size(); i++) {
            Element noticia = (Element) listaNoticiasOrdenadas.get(i);
            String link = noticia.attr("href");
            String noticiaShortText = noticia.text();
            for (int j = 0; j < listaNoticiasDesordenadaTextoCompleto.size(); j++) {
                Element noticiaMancheteCompleta = (Element) listaNoticiasDesordenadaTextoCompleto.get(j);
                if (noticiaMancheteCompleta.attr("href").equals(link)) {
                    noticiaShortText = noticiaMancheteCompleta.text();
                }
            }
            Noticia n = new Noticia(link,noticiaShortText);
            listaDeNoticiasFinais.add(n);
            txt += noticiaShortText + "\n" + link + "\n\n";
        }
        return txt;
    }
    
    public ArrayList<Noticia> getListaDeNoticias() {
    	return listaDeNoticiasFinais;
    }
}


