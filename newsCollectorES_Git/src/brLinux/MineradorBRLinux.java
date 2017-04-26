/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brLinux;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import model.Noticia;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Menezes da Silva e Marquinhos
 */
public class MineradorBRLinux {

    private Document d;
    private ArrayList<Noticia> listaDeNoticiasFinais;

    public MineradorBRLinux() {
        listaDeNoticiasFinais = new ArrayList<>();
    }

    public void conectaBrLinux() throws IOException {
        d = Jsoup.connect("http://br-linux.org/").get();
    }

    public void processaDados() {
        //Query para pegar a notícia do brLinux
        Elements listaLinks = d.select("div.socialplugs a");
        Elements listaManchetes = d.select("div#content h2 a ");
        for (int i = 1, j = 0; i < listaLinks.size(); i = i + 3, j++) {
            String link = listaLinks.get(i).attr("href");
            String manchete = listaManchetes.get(j).toString();
            link = filtraLink(link);
            manchete = filtraMachete(manchete);
            this.listaDeNoticiasFinais.add(new Noticia(link, manchete));
        }
    }

    private String filtraLink(String link) {
        while (link.charAt(0) != '=') {
            link = link.substring(1);
        }
        link = link.substring(1);
        return link;
    }

    private String filtraMachete(String manchete) {
        while (manchete.charAt(0) != '>') {
            manchete = manchete.substring(1);
        }
        manchete = manchete.substring(1);
        while (manchete.charAt(manchete.length() - 1) != '<') {
            manchete = manchete.substring(0, manchete.length() - 1);
        }
        manchete = manchete.substring(0, manchete.length() - 1);
        return manchete;
    }

    /**
     * @return the listaDeNoticiasFinais
     */
    public ArrayList<Noticia> getListaDeNoticiasFinais() {
        return listaDeNoticiasFinais;
    }

}
