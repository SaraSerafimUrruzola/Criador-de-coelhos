/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author sarau
 */
public class Proprietarios {
    int ID_prop;
    String nome_prop;
    String endereco;
    String fone;

    public int getID_prop() {
        return ID_prop;
    }

    public void setID_prop(int ID_prop) {
        this.ID_prop = ID_prop;
    }

    public String getNome_prop() {
        return nome_prop;
    }

    public void setNome_prop(String nome_prop) {
        this.nome_prop = nome_prop;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Proprietarios() {
    }

    public Proprietarios(int ID_prop, String nome_prop, String endereco, String fone) {
        this.ID_prop = ID_prop;
        this.nome_prop = nome_prop;
        this.endereco = endereco;
        this.fone = fone;
    }
}
