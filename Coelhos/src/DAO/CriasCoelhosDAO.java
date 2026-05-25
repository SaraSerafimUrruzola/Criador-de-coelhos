package DAO;

import Conexao.util.Conexao;
import Classes.CriasCoelhos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class CriasCoelhosDAO {

    private Connection conn;

    public CriasCoelhosDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            System.out.println("Erro de conexão: " + ":\n" + e.getMessage());
        }
    }

    public ArrayList<CriasCoelhos> listar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList<CriasCoelhos> MedicosCon = new ArrayList<>();

        try {
            String SQL = "SELECT crias.ID_cria, Pai.nome AS nome_pai, Mae.nome AS nome_mae, crias.data_cria, crias.sexo_cria, crias.peso_nasc "
                    + "FROM crias "
                    + "JOIN coelhos AS Pai ON crias.ID_pai = Pai.ID_coelho "
                    + "JOIN coelhos AS Mae ON crias.ID_mae = Mae.ID_coelho "
                    + "WHERE crias.ID_cria = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, Integer.toString(codigo));
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_cria = rs.getInt("ID_cria");
                String nome_pai = rs.getString("nome_pai");
                String nome_mae = rs.getString("nome_mae");
                char sexo_cria = rs.getString("sexo_cria") != null ? rs.getString("sexo_cria").charAt(0) : ' ';
                Date data_cria = rs.getDate("data_cria");
                float peso_nasc = rs.getFloat("peso_nasc");

                MedicosCon.add(new CriasCoelhos(ID_cria, nome_pai, nome_mae, data_cria, sexo_cria, peso_nasc));
            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao listar crias " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
        return MedicosCon;
    }

    public ArrayList<CriasCoelhos> listarcrias(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList<CriasCoelhos> MedicosCon = new ArrayList<>();

        try {
            String SQL = "SELECT crias.ID_cria, Pai.nome AS nome_pai, Mae.nome AS nome_mae, crias.data_cria, crias.sexo_cria, crias.peso_nasc "
                    + "FROM crias "
                    + "JOIN coelhos AS Pai ON crias.ID_pai = Pai.ID_coelho "
                    + "JOIN coelhos AS Mae ON crias.ID_mae = Mae.ID_coelho "
                    + "WHERE crias.ID_cria = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_cria = rs.getInt("ID_cria");
                String nome_pai = rs.getString("nome_pai");
                String nome_mae = rs.getString("nome_mae");
                char sexo_cria = rs.getString("sexo_cria") != null ? rs.getString("sexo_cria").charAt(0) : ' ';
                Date data_cria = rs.getDate("data_cria");
                float peso_nasc = rs.getFloat("peso_nasc");

                MedicosCon.add(new CriasCoelhos(ID_cria, nome_pai, nome_mae, data_cria, sexo_cria, peso_nasc));
            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao listar: " + sqle.getMessage());
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return MedicosCon;
    }

    public CriasCoelhos procuraMae(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        CriasCoelhos MedicosCon = new CriasCoelhos();

        try {
            String SQL = "SELECT crias.ID_cria, crias.ID_pai, crias.ID_mae, Pai.nome AS nome_pai, Mae.nome AS nome_mae, crias.data_cria, crias.sexo_cria, crias.peso_nasc "
                    + "FROM crias "
                    + "JOIN coelhos AS Pai ON crias.ID_pai = Pai.ID_coelho "
                    + "JOIN coelhos AS Mae ON crias.ID_mae = Mae.ID_coelho "
                    + "WHERE crias.ID_cria = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int ID_mae = rs.getInt("ID_mae");
                String nome_mae = rs.getString("nome_mae");

                MedicosCon.setID_mae(ID_mae);
                MedicosCon.setNome_mae(nome_mae);
            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao listar: " + sqle.getMessage());
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return MedicosCon;
    }

    public CriasCoelhos procuraPai(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        CriasCoelhos MedicosCon = new CriasCoelhos();

        try {
            String SQL = "SELECT crias.ID_cria, crias.ID_pai, crias.ID_mae, Pai.nome AS nome_pai, Mae.nome AS nome_mae, crias.data_cria, crias.sexo_cria, crias.peso_nasc "
                    + "FROM crias "
                    + "JOIN coelhos AS Pai ON crias.ID_pai = Pai.ID_coelho "
                    + "JOIN coelhos AS Mae ON crias.ID_mae = Mae.ID_coelho "
                    + "WHERE crias.ID_cria = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int ID_pai = rs.getInt("ID_pai");
                String nome_pai = rs.getString("nome_pai");

                MedicosCon.setID_pai(ID_pai);
                MedicosCon.setNome_pai(nome_pai);
            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao listar: " + sqle.getMessage());
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return MedicosCon;
    }

    public CriasCoelhos procuraKit(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        CriasCoelhos MedicosCon = new CriasCoelhos();

        try {
            String SQL = "SELECT crias.ID_cria, crias.ID_pai, crias.ID_mae, Pai.nome AS nome_pai, Mae.nome AS nome_mae, crias.data_cria, crias.sexo_cria, crias.peso_nasc "
                    + "FROM crias "
                    + "JOIN coelhos AS Pai ON crias.ID_pai = Pai.ID_coelho "
                    + "JOIN coelhos AS Mae ON crias.ID_mae = Mae.ID_coelho "
                    + "WHERE crias.ID_cria = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int ID_cria = rs.getInt("ID_cria");
                MedicosCon.setID_cria(ID_cria);
            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao listar: " + sqle.getMessage());
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return MedicosCon;
    }
}
