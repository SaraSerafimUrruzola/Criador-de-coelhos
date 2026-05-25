/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author 275158
 */
public class Crias {
    
    private int ID_cria;
    private int ID_pai;
    private int ID_mae;
    private Date data_cria;
    private char sexo_cria;
    private float peso_nasc;

    public int getID_cria() {
        return ID_cria;
    }

    public void setID_cria(int ID_cria) {
        this.ID_cria = ID_cria;
    }

    public int getID_pai() {
        return ID_pai;
    }

    public void setID_pai(int ID_pai) {
        this.ID_pai = ID_pai;
    }

    public int getID_mae() {
        return ID_mae;
    }

    public void setID_mae(int ID_mae) {
        this.ID_mae = ID_mae;
    }

    public Date getData_cria() {
        return data_cria;
    }

    public void setData_cria(Date data_cria) {
        this.data_cria = data_cria;
    }

    public char getSexo_cria() {
        return sexo_cria;
    }

    public void setSexo_cria(char sexo_cria) {
        this.sexo_cria = sexo_cria;
    }

    public float getPeso_nasc() {
        return peso_nasc;
    }

    public void setPeso_nasc(float peso_nasc) {
        this.peso_nasc = peso_nasc;
    }

    public Crias() {
    }

    public Crias(int ID_cria, int ID_pai, int ID_mae, Date data_cria, char sexo_cria, float peso_nasc) {
        this.ID_cria = ID_cria;
        this.ID_pai = ID_pai;
        this.ID_mae = ID_mae;
        this.data_cria = data_cria;
        this.sexo_cria = sexo_cria;
        this.peso_nasc = peso_nasc;
    }

}
