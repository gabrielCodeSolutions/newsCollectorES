package DIOLinux_Teste;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dioLinux.Noticia;
import dioLinux.MineradorDioLinux;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Efraim
 */
public class DIOLinux_JUnit_Test {
    
    MineradorDioLinux mineradorDioLinux;
    
    public DIOLinux_JUnit_Test() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        mineradorDioLinux = new MineradorDioLinux();
        mineradorDioLinux.conectaDioLinux();
        mineradorDioLinux.processaDados();
    }
    
    /* Início dos testes de processamento de dados respectivo ao site DIO Linux.
    Aqui serão verificados se as manchetes e os links derivados das notícias do
    site foram coletadas de maneira correta.
    */
    
    @Test
    public void testeDIOCollector0(){
        
        String manchete = "Como testar novos recursos no Firefox antes de todos!";
        String link= "http://www.diolinux.com.br/2017/04/como-testar-novos-recursos-no-firefox.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(0).getManchete());
        assertTrue(this.compararNoticia(noticia));
                
    }
    
    @Test
    public void testeDIOCollector1(){
        
        String manchete = "United - O tema para KDE Plasma que transforma a sua interface no Unity";
        String link= "http://www.diolinux.com.br/2017/04/united-o-tema-unity-ubuntu-para-kde-plasma.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(4).getManchete());
        assertTrue(this.compararNoticia(noticia));
                
    }
    
    @Test
    public void testeDIOCollector2(){
        String manchete = "Como fazer o Google Chrome e o Firefox reconhecerem todos os Emojis";
        String link= "http://www.diolinux.com.br/2017/04/como-fazer-o-google-chrome-reconhecerem-emojis.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(1).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector3(){
        String manchete = "Agricultores querem \"fazer root\" em tratores da John Deere";
        String link= "http://www.diolinux.com.br/2017/04/agricultores-querem-fazer-root-em-tratores.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(2).getManchete());
        assertTrue(this.compararNoticia(noticia));;
    }
    
    @Test
    public void testeDIOCollector4(){
        String manchete = "Lançado Deepin 15.4 para provar que Linux não é difícil de uma vez por todas";
        String link= "http://www.diolinux.com.br/2017/04/deepin-154-download-rapido.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(3).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector5(){
        String manchete = "Como criar e embutir legendas em vídeos usando Linux";
        String link= "http://www.diolinux.com.br/2017/04/como-criar-e-embutir-legendas-em-videos-no-linux.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(5).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector6(){
        String manchete = "Anbox - O projeto que quer integrar Apps de Android nas distros Linux de Desktop";
        String link= "http://www.diolinux.com.br/2017/04/anbox-app-android-linux-desktop.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(6).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector7(){
        String manchete = "Lançado Ubuntu 17.04 Zesty Zapus, confira as novidades faça o download!";
        String link= "http://www.diolinux.com.br/2017/04/ubuntu-1704-download-torrent.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorDioLinux.getListaDeNoticias().get(7).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    // Método utilizado para procurar uma dada noticia num ArrayList.
    public boolean compararNoticia(Noticia noticia){
        for (int i=0;i<=mineradorDioLinux.getListaDeNoticias().size();i++){
            if (noticia.getManchete().equals(mineradorDioLinux.getListaDeNoticias().get(i).getManchete())|| noticia.getLink().equals(mineradorDioLinux.getListaDeNoticias().get(i).getLink())){
                return true;
            } 
        }
        return false;
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
