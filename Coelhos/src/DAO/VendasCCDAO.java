package DAO;

import Classes.Vendas;
import Classes.VendasCC;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class VendasCCDAO {

    private Connection conn;

    public VendasCCDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList<VendasCC> venda = new ArrayList<>();

        try {
            String SQL = "SELECT ID_venda, vendas.ID_coelho, bun.nome AS nome_coelho, vendas.ID_comprador, comp.nome_prop AS nome_comp, data_venda, preco "
                    + "FROM vendas "
                    + "JOIN coelhos AS bun ON vendas.ID_coelho = bun.ID_coelho "
                    + "JOIN proprietarios AS comp ON vendas.ID_comprador = comp.ID_prop "
                    + "ORDER BY ID_venda";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_venda = rs.getInt("ID_venda");
                int ID_coelho = rs.getInt("ID_coelho");
                String nome_coelho = rs.getString("nome_coelho");
                int ID_comprador = rs.getInt("ID_comprador");
                String nome_comp = rs.getString("nome_comp");
                Date data_venda = rs.getDate("data_venda");
                float preco = rs.getFloat("preco");

                venda.add(new VendasCC(ID_venda, ID_coelho, nome_coelho, ID_comprador, nome_comp, data_venda, preco));
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return venda;
    }

    public VendasCC procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        VendasCC venda = new VendasCC();
        venda = null;

        try {
            String SQL = "SELECT ID_venda, vendas.ID_coelho, bun.nome AS nome_coelho, vendas.ID_comprador, comp.nome_prop AS nome_comp, data_venda, preco "
                    + "FROM vendas "
                    + "JOIN coelhos AS bun ON vendas.ID_coelho = bun.ID_coelho "
                    + "JOIN proprietarios AS comp ON vendas.ID_comprador = comp.ID_prop "
                    + "WHERE ID_venda = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_venda = rs.getInt("ID_venda");
                int ID_coelho = rs.getInt("ID_coelho");
                String nome_coelho = rs.getString("nome_coelho");
                int ID_comprador = rs.getInt("ID_comprador");
                String nome_comp = rs.getString("nome_comp");
                Date data_venda = rs.getDate("data_venda");
                float preco = rs.getFloat("preco");

                venda = new VendasCC(ID_venda, ID_coelho, nome_coelho, ID_comprador, nome_comp, data_venda, preco);

            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao procurar venda " + sqle);
        } finally {
            // ConexaoAulaDAO.close(connL,ps);
        }
        return venda;
    }

    public ArrayList<VendasCC> listarvendas(int codigo) {
        ArrayList<VendasCC> vendas = new ArrayList<>();
        try {
            String SQL = "SELECT ID_venda, vendas.ID_coelho, bun.nome AS nome_coelho, vendas.ID_comprador, comp.nome_prop AS nome_comp, data_venda, preco "
                    + "FROM vendas "
                    + "JOIN coelhos AS bun ON vendas.ID_coelho = bun.ID_coelho "
                    + "JOIN proprietarios AS comp ON vendas.ID_comprador = comp.ID_prop "
                    + "WHERE vendas.ID_coelho = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VendasCC venda = new VendasCC();
                venda.setID_venda(rs.getInt("ID_venda"));
                venda.setID_comprador(rs.getInt("ID_comprador"));
                venda.setID_coelho(rs.getInt("ID_coelho"));
                venda.setData_venda(rs.getDate("data_venda"));
                venda.setPreco(rs.getFloat("preco"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }
    
    public ArrayList<VendasCC> listarv(int codigo) {
        ArrayList<VendasCC> vendas = new ArrayList<>();
        try {
            String SQL = "SELECT ID_venda, vendas.ID_coelho, bun.nome AS nome_coelho, vendas.ID_comprador, comp.nome_prop AS nome_comp, data_venda, preco "
                    + "FROM vendas "
                    + "JOIN coelhos AS bun ON vendas.ID_coelho = bun.ID_coelho "
                    + "JOIN proprietarios AS comp ON vendas.ID_comprador = comp.ID_prop "
                    + "WHERE vendas.ID_venda = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VendasCC venda = new VendasCC();
                venda.setID_venda(rs.getInt("ID_venda"));
                venda.setID_comprador(rs.getInt("ID_comprador"));
                venda.setID_coelho(rs.getInt("ID_coelho"));
                venda.setData_venda(rs.getDate("data_venda"));
                venda.setPreco(rs.getFloat("preco"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public void atualizar(Vendas venda) throws SQLException {
        String SQL = "UPDATE vendas SET ID_coelho = ?, ID_comprador = ?, data_venda = ?, preco = ? WHERE ID_venda = ?";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, venda.getID_coelho());
            ps.setInt(2, venda.getID_comprador());
            ps.setDate(3, new java.sql.Date(venda.getData_venda().getTime()));
            ps.setFloat(4, venda.getPreco());
            ps.setInt(5, venda.getID_venda());
            ps.executeUpdate();
            System.out.println("Venda ID " + venda.getID_venda() + " updated successfully.");
        }
    }

}
