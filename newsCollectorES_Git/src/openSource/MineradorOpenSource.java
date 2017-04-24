/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openSource;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Gabriel Menezes da Silva e Marquinhos
 */
public class MineradorOpenSource {

    private Document d;

    public void conectaOpenSource() throws IOException {
        d = Jsoup.connect("https://opensource.com/").get();
    }

    public void processaDados() {
        //Query para pegar a notícia do brLinux
        Elements listaNoticia = d.select("div#content h2 a");
        System.out.println(listaNoticia.get(2).attr("href"));
        System.out.println(listaNoticia.size());
    }

    public static void main(String[] args) throws IOException {
        MineradorOpenSource m = new MineradorOpenSource();
        m.conectaOpenSource();
        m.processaDados();
    }
}
