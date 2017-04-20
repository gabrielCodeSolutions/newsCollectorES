import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by gabriel and marquinhows on 15/04/17.
 */
public class MineradorDioLinux_EDIT {

    public static void main(String[] args) throws IOException {
        /*Deve ser feito um "for" para passar por todos os elementos*/
        // E usar "querys" do css para percorrer os elementos
        //Conecta com o site
        Document d = Jsoup.connect("http://www.diolinux.com.br/").timeout(6000).get();
        //Usa css query para achar determinado elemento de acordo com a formatação da página
        //Retorn um array com os elementos
        Elements listaNoticiasDesordenadaTextoCompleto = d.select("div.item-title a ");
        Elements listaNoticiasOrdenadas = d.select("ul.posts li a ");
        for (int i = 0; i < listaNoticiasOrdenadas.size();i++) {
            Element noticia = (Element) listaNoticiasOrdenadas.get(i);
            String link = noticia.attr("href");
            String noticiaShortText = noticia.text();

            for (int j = 0; j < listaNoticiasDesordenadaTextoCompleto.size();j++) {
                Element noticiaMancheteCompleta = (Element) listaNoticiasDesordenadaTextoCompleto.get(j);
                if(noticiaMancheteCompleta.attr("href").equals(link)){
                    noticiaShortText = noticiaMancheteCompleta.text();
                }
            }

            System.out.println(link);
            System.out.println(noticiaShortText);
        }

    }
}
