/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Date;

/**
 *
 * @author sarau
 */
public class VendasCC {
    int ID_venda;
    int ID_coelho;
    String nome_coelho;
    int ID_comprador;
    String nome_comp;
    Date data_venda;
    float preco;

    public int getID_venda() {
        return ID_venda;
    }

    public void setID_venda(int ID_venda) {
        this.ID_venda = ID_venda;
    }

    public int getID_coelho() {
        return ID_coelho;
    }

    public void setID_coelho(int ID_coelho) {
        this.ID_coelho = ID_coelho;
    }

    public String getNome_coelho() {
        return nome_coelho;
    }

    public void setNome_coelho(String nome_coelho) {
        this.nome_coelho = nome_coelho;
    }

    public int getID_comprador() {
        return ID_comprador;
    }

    public void setID_comprador(int ID_comprador) {
        this.ID_comprador = ID_comprador;
    }

    public String getNome_comprador() {
        return nome_comp;
    }

    public void setNome_comprador(String nome_comprador) {
        this.nome_comp = nome_comprador;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public VendasCC() {
    }

    public VendasCC(int ID_venda, int ID_coelho, String nome_coelho, int ID_comprador, String nome_comprador, Date data_venda, float preco) {
        this.ID_venda = ID_venda;
        this.ID_coelho = ID_coelho;
        this.nome_coelho = nome_coelho;
        this.ID_comprador = ID_comprador;
        this.nome_comp = nome_comprador;
        this.data_venda = data_venda;
        this.preco = preco;
    }
    
    public VendasCC(String nome_coelho, String nome_comprador, Date data_venda, float preco) {
        this.nome_coelho = nome_coelho;
        this.nome_comp = nome_comprador;
        this.data_venda = data_venda;
        this.preco = preco;
    }
    
}
