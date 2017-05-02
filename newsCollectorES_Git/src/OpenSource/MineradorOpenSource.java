/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openSource;

import java.io.IOException;
import java.util.ArrayList;
import model.Noticia;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author 1151126001
 */
public class MineradorOpenSource {

    private Document d;
    private ArrayList<Noticia> listaDeNoticiasFinais;

    public MineradorOpenSource() {
        listaDeNoticiasFinais = new ArrayList<>();
    }

    public void conectaOpenSource() throws IOException {
        d = Jsoup.connect("https://opensource.com/").get();
    }

    public void processaDados() {
        Elements listaLinks = d.select("div.pane-node-title h2 a");
        for (int i = 0; i < listaLinks.size(); i++) {
            String link = listaLinks.get(i).attr("href");
            String manchete = listaLinks.get(i).toString();
            link = completarLink(link);
            manchete = filtraMachete(manchete);
            this.listaDeNoticiasFinais.add(new Noticia(link, manchete));
        }
    }
    /**
     * @return the listaDeNoticiasFinais
     */
    public ArrayList<Noticia> getListaDeNoticiasFinais() {
        return listaDeNoticiasFinais;
    }
    
    private String completarLink(String link) {
        return "https://opensource.com"+link;
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

}