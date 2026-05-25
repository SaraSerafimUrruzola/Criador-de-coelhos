package Classes;

import java.sql.Time;
import java.util.Date;

public class CriasCoelhos {
    int ID_cria;
    int ID_pai;
    int ID_mae;
    Date data_cria;
    char sexo_cria;
    float peso_nasc;
    int ID_coelho;
    String nome_pai;
    String nome_mae;
    String raca;
    Date data_nasc;
    char sexo;
    String cor;
   

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }
        
    public CriasCoelhos(int ID_cria, String nome_pai, String nome_mae, Date data_cria, char sexo_cria, float peso_nasc) {
        this.ID_cria = ID_cria;
        this.data_cria = data_cria;
        this.sexo_cria = sexo_cria;
        this.peso_nasc = peso_nasc;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
    }

    public CriasCoelhos(int ID_cria, int ID_pai, int ID_mae, Date data_cria, char sexo_cria, float peso_nasc, int ID_coelho, String nome_pai, String nome_mae, String raca, Date data_nasc, char sexo, String cor) {
        this.ID_cria = ID_cria;
        this.ID_pai = ID_pai;
        this.ID_mae = ID_mae;
        this.data_cria = data_cria;
        this.sexo_cria = sexo_cria;
        this.peso_nasc = peso_nasc;
        this.ID_coelho = ID_coelho;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.raca = raca;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.cor = cor;
    }
    
    
    
    public CriasCoelhos() {
    }

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

    public int getID_coelho() {
        return ID_coelho;
    }

    public void setID_coelho(int ID_coelho) {
        this.ID_coelho = ID_coelho;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
}
