/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRLinux_Teste;

// Imports com erros até a finalização do script para o site
// BR Linux

import model.Noticia;
import brLinux.MineradorBRLinux;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Efraim - 1152123138
 * Created: 25/04/2017 - 15:37
 * Last Modified: 25/04/2017 - 15:40
 * 
 */
public class BRLinux_JUnit_Test {
    
    MineradorBRLinux mineradorBRLinux;
    
    public BRLinux_JUnit_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        mineradorBRLinux = new MineradorBRLinux();
        mineradorBRLinux.conectaBrLinux();
        mineradorBRLinux.processaDados();
    }
    
    /* ATENÇÃO: ESTE TESTE FOI DESENVOLVIDO PREVIAMENTE AO SCRIPT QUE TESTA, 
    SENDO ASSIM, MÉTODOS, 'IMPORTS' E VARIÁVEIS PODEM NECESSITAR DE ALTERAÇÕES
    PARA FUNCIONAR CORRETAMENTE.
    
        Início dos testes de processamento de dados respectivo ao site BR Linux.
    Aqui serão verificados se as manchetes e os links derivados das notícias do
    site foram coletadas de maneira correta.
    */

    @Test
    public void testeBRCollector1(){
        
        String manchete = "Evolução histórica do Ubuntu Destkop";
        String link= "http://br-linux.org/2017/01/evolucao-historica-do-ubuntu-destkop.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorBRLinux.getListaDeNoticiasFinais().get(0).getManchete());
        assertTrue(this.compararNoticia(noticia));
                
    }
    
    @Test
    public void testeBRCollector2(){
        String manchete = "Filebeat – enviando logs para o Elasticsearch";
        String link= "http://br-linux.org/2017/01/filebeat-enviando-logs-para-o-elasticsearch.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorBRLinux.getListaDeNoticiasFinais().get(1).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeBRCollector3(){
        String manchete = "Café com Linux - Analisando o Endless O.S";
        String link= "http://br-linux.org/2017/01/cafe-com-linux-analisando-o-endless-os.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorBRLinux.getListaDeNoticiasFinais().get(2).getManchete());
        assertTrue(this.compararNoticia(noticia));;
    }
    
    @Test
    public void testeBRCollector4(){
        String manchete = "Entendendo Algoritmos, um guia ilustrado para programadores e outros curiosos";
        String link= "http://br-linux.org/2017/01/entendendo-algoritmos-um-guia-ilustrado-para-programadores-e-outros-curiosos.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorBRLinux.getListaDeNoticiasFinais().get(3).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeBRCollector5(){
        String manchete = "Meia-volta: agora Libreboot quer voltar a fazer parte do GNU";
        String link= "http://br-linux.org/2017/01/meia-volta-agora-libreboot-quer-voltar-a-fazer-parte-do-gnu.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorBRLinux.getListaDeNoticiasFinais().get(4).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeBRCollector6(){
        String manchete = "Profile e rc: Entendendo os arquivos de inicialização do Bash e as diferenças entre eles";
        String link= "http://br-linux.org/2017/01/profile-e-rc-entendendo-os-arquivos-de-inicializacao-do-bash-e-as-diferencas-entre-eles.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorBRLinux.getListaDeNoticiasFinais().get(5).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    @Test
    public void testeBRCollector7(){
        String manchete = "System76: Fase 3, ativar - design aplicado a computadores vendidos com Linux instalado";
        String link= "http://br-linux.org/2017/01/system76-fase-3-ativar-design-aplicado-a-computadores-vendidos-com-linux-instalado.html";
        Noticia noticia = new Noticia(link,manchete);
        // Teste de coleta da manchete e link
        System.out.println(mineradorBRLinux.getListaDeNoticiasFinais().get(6).getManchete());
        assertTrue(this.compararNoticia(noticia));
    }
    
    // Método utilizado para procurar uma dada noticia num ArrayList.
    public boolean compararNoticia(Noticia noticia){
        for (int i=0;i<=mineradorBRLinux.getListaDeNoticiasFinais().size();i++){
            if (noticia.getManchete().equals(mineradorBRLinux.getListaDeNoticiasFinais().get(i).getManchete())|| noticia.getLink().equals(mineradorBRLinux.getListaDeNoticiasFinais().get(i).getLink())){
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
