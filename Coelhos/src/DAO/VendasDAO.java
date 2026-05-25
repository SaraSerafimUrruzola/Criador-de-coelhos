
package DAO;
   import Classes.Vendas;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendasDAO {
      
   private Connection conn;
     public VendasDAO() {
        try{
            this.conn = Conexao.getConnection();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList venda = new ArrayList();

        try {
            String SQL = "SELECT * FROM vendas ORDER BY ID_venda";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_venda = rs.getInt("ID_venda");
                int ID_coelho = rs.getInt("ID_coelho");
                int ID_comprador = rs.getInt("ID_comprador");
                Date data_venda = rs.getDate("data_venda");
                float preco = rs.getFloat("preco");

                venda.add(new Vendas(ID_venda, ID_coelho, ID_comprador, data_venda, preco));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return venda;
    }
    
    public void inserir(Vendas venda) {         
        PreparedStatement ps = null;
        Connection connL = null;        
        if (venda == null){
            System.out.println("O objeto venda não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO vendas (ID_coelho, ID_comprador, data_venda, preco) " +
                    "values (?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setInt(1, venda.getID_coelho());
            ps.setInt(2, venda.getID_comprador());
        
            java.util.Date dataJAVA = venda.getData_venda();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setFloat(4, venda.getPreco());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao inserir uma nova venda" + sqle);
        }
        finally{
           Conexao.close(connL,ps);
        }
    }
    
    public Vendas procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Vendas venda = new Vendas();
        venda = null;

        try{
            String SQL = "SELECT ID_venda, ID_coelho, ID_comprador, data_venda, preco FROM vendas WHERE ID_venda = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
           
            
            while( rs.next()){
              int ID_venda = rs.getInt("ID_venda");
              int ID_coelho = rs.getInt("ID_coelho");
              int ID_comprador = rs.getInt("ID_comprador");
              Date data_venda = rs.getDate("data_venda");
              float preco = rs.getFloat("preco");
              
              venda = new Vendas(ID_venda, ID_coelho, ID_comprador, data_venda, preco); 
              
            }
            
            
            
        }catch(SQLException sqle){
            System.out.println("Erro ao procurar venda " + sqle);
        }
        finally{
          // ConexaoAulaDAO.close(connL,ps);
        }
        return venda;
    }   
    
    public void excluir(int venda){
        PreparedStatement ps = null;
        Connection connL = null;
        //if (venda == null){
           //System.out.println("O objeto venda não pode ser nulo.");
        //}

        try{
            String SQL = "DELETE FROM vendas WHERE ID_venda=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, venda);
            ps.executeUpdate();
        }catch(SQLException sqle){
          System.out.println("Erro ao excluir venda " + sqle);
        }
        finally{
          Conexao.close(connL,ps);
        }
    }
          public void atualizar(Vendas venda) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (venda == null){
             System.out.println("O objeto venda não pode ser nulo.");
        }

        try{
            String SQL = "UPDATE vendas set ID_coelho=?, ID_comprador=?, data_venda=?, preco=? WHERE ID_venda=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setInt(1, venda.getID_coelho());
            ps.setInt(2, venda.getID_comprador());
        
            java.util.Date dataJAVA = venda.getData_venda();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setFloat(4, venda.getPreco());
            ps.setInt(5, venda.getID_venda());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao editar venda " + sqle);
        }
        finally{
           Conexao.close(connL,ps);
        }
    }

    
    
   
}
