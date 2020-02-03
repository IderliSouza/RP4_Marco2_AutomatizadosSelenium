/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpiv;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author vitao
 */
public class LeitorTxt {
    public String[] ler(String local){
        BufferedReader buff;
        String linha;
        Integer itens;
        String []vetor = null;
        int cont=0;
        try {
            buff = new BufferedReader(new FileReader(local));
            linha = buff.readLine();
            itens = Integer.parseInt(linha);
            vetor = new String[itens];
            
            linha = buff.readLine();
            while (linha != null) {
                vetor[cont] = linha;
                cont++;

                linha = buff.readLine();
            }
            buff.close();

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            
        }
        return vetor;
    }
}
