/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.ErpDAOException;
import Conexao.util.Conexao;
import Classes.Crias;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 275158
 */
public class CriasDAO {

    private Connection conn;

    public CriasDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inserir(Crias cria) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (cria == null) {
            throw new ErpDAOException("O objeto cria não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO crias (ID_pai, ID_mae, data_cria, sexo_cria, peso_nasc)"
                    + "values (?,?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, cria.getID_pai());
            ps.setInt(2, cria.getID_mae());
            java.util.Date dataJAVA = cria.getData_cria();
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime());
            ps.setDate(3, dataSQL);
            ps.setString(4, Character.toString(cria.getSexo_cria()));
            ps.setFloat(5, cria.getPeso_nasc());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir uma nova cria" + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public void atualizar(Crias cria) throws ErpDAOException {
    if (cria == null) {
        throw new ErpDAOException("O objeto cria não pode ser nulo.");
    }

    PreparedStatement ps = null;
    Connection connL = this.conn;

    if (connL == null) {
        throw new ErpDAOException("Conexão com o banco de dados não está disponível.");
    }

    try {
        String SQL = "UPDATE crias SET ID_pai=?, ID_mae=?, data_cria=?, sexo_cria=?, peso_nasc=? WHERE ID_cria=?";
        ps = connL.prepareStatement(SQL);  // <-- THIS LINE WAS MISSING

        ps.setInt(1, cria.getID_pai());
        ps.setInt(2, cria.getID_mae());

        java.util.Date dataJAVA = cria.getData_cria();
        java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime());
        ps.setDate(3, dataSQL);

        ps.setString(4, Character.toString(cria.getSexo_cria()));
        ps.setFloat(5, cria.getPeso_nasc());
        ps.setInt(6, cria.getID_cria());

        ps.executeUpdate();

    } catch (SQLException sqle) {
        throw new ErpDAOException("Erro ao editar a cria " + sqle);
    } finally {
        Conexao.close(connL, ps);
    }
}


    public Crias procurar(int ID_cria) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT ID_cria, ID_pai, ID_mae, data_cria, sexo_cria, peso_nasc FROM crias WHERE ID_cria = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ID_cria);
            rs = ps.executeQuery();
            Crias cria = new Crias();
            while (rs.next()) {
                int ID_cria2 = rs.getInt("ID_cria");
                int ID_pai = rs.getInt("ID_pai");
                int ID_mae = rs.getInt("ID_mae");
                Date data_cria = rs.getDate("data_cria");
                char sexo_cria;
                if (rs.getString("sexo_cria") == null) {
                    sexo_cria = ' ';
                } else {
                    sexo_cria = (rs.getString("sexo_cria")).charAt(0);
                }
                float peso_nasc = (rs.getFloat("peso_nasc"));

                cria = new Crias(ID_cria2, ID_pai, ID_mae, data_cria, sexo_cria, peso_nasc);

            }

            return cria;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar a cria " + sqle);
        } finally {
            // conexaoAulaDAO.close(connL,ps);
        }
    }

    public ArrayList Listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList crias = new ArrayList();
        try {
            String SQL = "SELECT * FROM crias ORDER BY ID_cria";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int Id_cria = rs.getInt("ID_cria");
                int ID_pai = rs.getInt("ID_pai");
                int ID_mae = rs.getInt("ID_mae");
                Date data_cria = rs.getDate("data_cria");
                char sexo_cria;
                if (rs.getString("sexo_cria") == null) {
                    sexo_cria = ' ';
                } else {
                    sexo_cria = (rs.getString("sexo_cria")).charAt(0);
                }
                float peso_nasc = (rs.getFloat("peso_nasc"));

                crias.add(new Crias(Id_cria, ID_pai, ID_mae, data_cria, sexo_cria, peso_nasc));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return crias;
    }

    public void excluir(int cria) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (cria == 0) {
            System.out.println("O objeto cria não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM crias WHERE ID_cria=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, cria);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir cria " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }
}
