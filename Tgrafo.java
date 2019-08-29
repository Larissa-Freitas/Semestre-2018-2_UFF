/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testead2.pkg2018.pkg2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author sobre
 */
public class Tgrafo {
    ArrayList <String> v1 = new ArrayList<String>();
    ArrayList <String> v2 = new ArrayList<String>();
    ArrayList <String> nomes = new ArrayList <String>();
    ArrayList <String> idade = new ArrayList <String>();
   
    public Tgrafo() throws FileNotFoundException, IOException{
        InputStream arq = new FileInputStream("grafo.txt");//PODE UTILIZAR QUALQUER DOCUMENTO DE TEXTO PARA TESTAR, EU DEIXEI UM PRONTO COM NOME "grafoteste.txt"!!
        InputStreamReader arqu = new InputStreamReader(arq);
        BufferedReader arquivo = new BufferedReader(arqu);
        
        String linha = arquivo.readLine();
        String Array[]=new String[1];
        
        while (linha!= null){
            Array =linha.split(" ");
            
            if(Character.isDigit(Array[1].charAt(0))){
                this.nomes.add(Array[0]);
                this.idade.add(Array[1]);
            }else{
               this.aresta(Array[0],Array[1]);
            }
            linha = arquivo.readLine();
        }
        arquivo.close();
    }
    /* PARA FAZER A AD EU UTILIZEI LISTAS, SEI QUE DEVE HAVER UM JEITO MELHOR PRA ARMAZENAR OS DADOS DO ARQUIVO DE TEXTO E TRABALHAR,
    PORÉM ESSE FOI MEU RACIOCINIO E AS FUNÇÕES CUMPREM COM QUE A AD PEDE,ALGUMAS MUDANÇAS PODERIAM DEIXAR O CÓDIGO MELHOR PORÉM NÃO TIVE
    TEMPO PARA MELHORA-LA. AGRADEÇO A CORREÇÃO!
    A FORMA COMO ARMAZENEI OS DADOS DO ARQUIVO NA LISTA FOI ARMAZENANDO O NOME E A IDADE AO MESMO TEMPO OU SEJA O NOME DE INDICE "0"
    CORRESPONDE A IDADE DE INDICE "0". UTILIZANDO O MESMO RACIOCINIO EU ARMAZENEI O V1(PESSOA QUE SEGUE)COM ÍNDICE GUAL A V2(PESSOA A SER SEGUIDA
    DESSA FORMA PODE-SE INTERPRETAR QUE V1.GET(O) SEGUE V2.GET(0), ASSIM COMO V1.GET(1) SEGUE V2.GET(1). DESSA FORMA TRABALHEI COM AS LISTAS PARA
    QUE ELAS RETORNASSEM OS RESULTADOS ESPERADOS DA AD.
    
    
    */
        
    public void aresta(String v1, String v2){
        this.v1.add(v1);
        this.v2.add(v2);
    }
    public static int numero_seguidores (Tgrafo g, String nome){
        int cont =0;
        for (int i=0;i <= g.v1.size()-1;i++){
            if (g.v1.get(i).equals(nome)){
                cont++;
            }
        }
        return cont;
    }
    
    public static void seguidores (Tgrafo g, String nome){
        System.out.print("Seguidores de "+nome+": ");
        for(int i=0;i<=g.v1.size()-1;i++){
            if(g.v2.get(i).equals(nome)){
                System.out.println(g.v1.get(i));
                
                
            }
        }
    }
    
    public static String mais_popular(Tgrafo g){
        int maior =0, cont = 1;
        String nmaior=" ";
        for(int i=0;i<= g.v2.size()-2;i++){
            for(int j=i+1;j<= g.v2.size()-1;j++){
                if(g.v2.get(i).equals(g.v2.get(j))){
                    cont++;
                }
            }
            if(cont>maior){
                maior =cont;
                nmaior=g.v2.get(i);
                cont=1;
                
            }else
                if(cont==maior){
                    nmaior+=" e "+g.v2.get(i);
                }
            cont=1;
        }
        return nmaior;
    }
    
    public static void segue_mais_velho(Tgrafo g){
        String idadev1=" ",idadev2=" ";
        String nomev1=" ";
        for(int i=0;i<= g.v1.size()-1;i++){
            for(int j=0;j<=g.nomes.size()-1;j++){
                 if(g.nomes.get(j).equals(g.v1.get(i))){
                     idadev1=g.idade.get(j);
                     nomev1=g.nomes.get(j);
                 }    
            }
            for(int j=0;j<=g.nomes.size()-1;j++){
                 if(g.nomes.get(j).equals(g.v2.get(i))){
                    idadev2=g.idade.get(j);
                 }
            }
                 
            
            if(Integer.parseInt(idadev1) < Integer.parseInt(idadev2)){
                System.out.println("Segue mais velhos: ");
                System.out.println(nomev1);
                idadev1=" ";
                idadev2=" ";
            }
        }   
    }
}
        
    
