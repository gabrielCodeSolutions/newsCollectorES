/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openSource_Teste;

import model.Noticia;
import openSource.MineradorOpenSource;
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
public class OpenSource_JUnit_Test {
    
    MineradorOpenSource mineradorOpenSource;
    
    public OpenSource_JUnit_Test() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        mineradorOpenSource = new MineradorOpenSource();
        mineradorOpenSource.conectaOpenSource();
        mineradorOpenSource.processaDados();
    }
    
    /* Início dos testes de processamento de dados respectivo ao site DIO Linux.
    Aqui serão verificados se as manchetes e os links derivados das notícias do
    site foram coletadas de maneira correta.
    */
    
    @Test
    public void testeDIOCollector0(){
        
        String manchete = "Colorful deployments: An introduction to blue-green, canary, and rolling deployments";
        String link= "https://opensource.com/article/17/5/colorful-deployments";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(0).getManchete());
        assertTrue(this.compararNoticia(noticia));
                
    }
    
    @Test
    public void testeDIOCollector1(){
        
        String manchete = "5 ways to motivate technical employees";
        String link= "https://opensource.com/article/17/5/5-ways-to-motivate-technical-employees";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(1).getManchete());
        assertTrue(this.compararNoticia(noticia));
                
    }
    
    @Test
    public void testeDIOCollector2(){
        String manchete = "Not playing around: Lessons from indie game developers";
        String link= "https://opensource.com/article/17/5/what-foss-can-learn-indie-game-development";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(2).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector3(){
        String manchete = "3 lessons in open communication";
        String link= "https://opensource.com/open-organization/17/5/open-communication-lessons";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(3).getManchete());
        assertTrue(this.compararNoticia(noticia));;
    }
    
    @Test
    public void testeDIOCollector4(){
        String manchete = "How to speed up your MySQL queries 300 times";
        String link= "https://opensource.com/article/17/5/speed-your-mysql-queries-300-times";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(4).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector5(){
        String manchete = "The next big challenge for open source: rich collaboration software";
        String link= "https://opensource.com/article/17/5/next-big-challenge-open-source-rich-collaboration-software";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(5).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector6(){
        String manchete = "We're giving away two LulzBot 3D printers";
        String link= "https://opensource.com/article/17/5/open-hardware-3d-printer-giveaway";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(6).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeDIOCollector7(){
        String manchete = "Introducing the Forum at OpenStack Summit Boston";
        String link= "https://opensource.com/article/17/5/openstack-summit-boston-forum";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorOpenSource.getListaDeNoticiasFinais().get(7).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    // Método utilizado para procurar uma dada noticia num ArrayList.
    public boolean compararNoticia(Noticia noticia){
        for (int i=0;i<=mineradorOpenSource.getListaDeNoticiasFinais().size();i++){
            if (noticia.getManchete().equals(mineradorOpenSource.getListaDeNoticiasFinais().get(i).getManchete())|| noticia.getLink().equals(mineradorOpenSource.getListaDeNoticiasFinais().get(i).getLink())){
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
