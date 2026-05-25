/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao.util;

import Classes.Configuracao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class acessoArquivo {

    private static final String FILE_NAME = "breeder.cfg";

    // Get the folder where the JAR is running
    private static File getConfigFile() {
        String dir = System.getProperty("user.dir"); // current working directory
        return new File(dir, FILE_NAME);
    }

    public static void grava(Configuracao CF) {
        try {
            File arquivo = getConfigFile();
            ObjectOutputStream fluxo = new ObjectOutputStream(new FileOutputStream(arquivo));
            fluxo.writeObject(CF);
            fluxo.flush();
            fluxo.close();
            System.out.println("Dados gravados com sucesso no arquivo breeder.cfg");
        } catch (Exception e) {
            System.out.println("Falha na gravação do arquivo: " + e);
        }
    }

    public static Configuracao le() {
        Configuracao CF = new Configuracao();
        try {
            File arquivo = getConfigFile();
            if (!arquivo.exists()) {
                // file doesn't exist yet
                return CF;
            }
            ObjectInputStream fluxo = new ObjectInputStream(new FileInputStream(arquivo));
            CF = (Configuracao) fluxo.readObject();
            fluxo.close();
            System.out.println("Dados lidos com sucesso no arquivo breeder.cfg");
        } catch (Exception e) {
            System.out.println("Falha na leitura do arquivo: " + e);
        }
        return CF;
    }
}
