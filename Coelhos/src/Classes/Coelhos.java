/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;


public class Coelhos {
    int ID_coelho;
    String nome;
    String raca;
    Date data_nasc;
    char sexo;
    float peso;
    String cor;

    public Coelhos() {
    }

    public Coelhos(int ID_coelho, String nome, String raca, Date data_nasc, char sexo, float peso, String cor) {
        this.ID_coelho = ID_coelho;
        this.nome = nome;
        this.raca = raca;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.peso = peso;
        this.cor = cor;
    }

    public int getID_coelho() {
        return ID_coelho;
    }

    public void setID_coelho(int ID_coelho) {
        this.ID_coelho = ID_coelho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
    
}
