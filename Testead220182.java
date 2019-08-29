package testead2.pkg2018.pkg2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Character;

public class Testead220182 {
    public static void main (String[] args) throws FileNotFoundException, IOException {
         //TESTES COM A CLASSE UTILIZANDO O EXEMPLO DA QUESTÃO DA AD2: 
        Tgrafo g =new Tgrafo();
        
        System.out.println(g.v1.get(1));//APENAS PARA TESTAR SE A LISTA ARMAZENOU OS DADOS CORRETAMENTE
        
        int numero_seguidores= Tgrafo.numero_seguidores(g,"Bruna");
        System.out.println(numero_seguidores);
        
        Tgrafo.seguidores(g,"Marcos");
        
        String popular = Tgrafo.mais_popular(g);
        System.out.println(popular);
        
        Tgrafo.segue_mais_velho(g); //NESSA FUNÇÃO EU NÃO CONSEGUI REMOVER AS REPETIÇÕES OU SEJA OS NOMES APARECEM MAIS DE UMA VEZ NO RESULTADO
        
        
        
        
        
    }
    
}
