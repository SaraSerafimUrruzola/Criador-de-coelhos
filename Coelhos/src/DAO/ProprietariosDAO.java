
package DAO;
   import Classes.Proprietarios;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProprietariosDAO {
      
   private Connection conn;
     public ProprietariosDAO() {
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
        ArrayList prop = new ArrayList();

        try {
            String SQL = "SELECT * FROM proprietarios ORDER BY ID_prop";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_prop = rs.getInt("ID_prop");
                String nome_prop = rs.getString("nome_prop");
                String endereco = rs.getString("endereco");
                String fone = rs.getString("fone");

                prop.add(new Proprietarios(ID_prop, nome_prop, endereco, fone));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return prop;
    }
    
    public void inserir(Proprietarios prop) {         
        PreparedStatement ps = null;
        Connection connL = null;        
        if (prop == null){
            System.out.println("O objeto prop não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO proprietarios (nome_prop, endereco, fone) " +
                    "values (?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setString(1, prop.getNome_prop());
            ps.setString(2, prop.getEndereco());
            ps.setString(3, prop.getFone());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao inserir um novo coelho" + sqle);
        }
        finally{
           Conexao.close(connL,ps);
        }
    }
    
    public Proprietarios procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Proprietarios prop = new Proprietarios();
        prop = null;

        try{
            String SQL = "SELECT ID_prop, nome_prop, endereco, fone FROM proprietarios WHERE ID_prop = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
           
            
            while( rs.next()){
              int ID_prop = rs.getInt("ID_prop");
                String nome_prop = rs.getString("nome_prop");
                String endereco = rs.getString("endereco");
                String fone = rs.getString("fone");
              
              prop = new Proprietarios(ID_prop, nome_prop, endereco, fone); 
              
            }
            
            
            
        }catch(SQLException sqle){
            System.out.println("Erro ao procurar proprietário " + sqle);
        }
        finally{
          // ConexaoAulaDAO.close(connL,ps);
        }
        return prop;
    }   
    
    public void excluir(Proprietarios prop){
        PreparedStatement ps = null;
        Connection connL = null;
        if (prop == null){
           System.out.println("O objeto proprietário não pode ser nulo.");
        }

        try{
            String SQL = "DELETE FROM proprietarios WHERE ID_prop=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, prop.getID_prop());
            ps.executeUpdate();
        }catch(SQLException sqle){
          System.out.println("Erro ao excluir proprietário " + sqle);
        }
        finally{
          Conexao.close(connL,ps);
        }
    }
          public void atualizar(Proprietarios prop) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (prop == null){
             System.out.println("O objeto proprietário não pode ser nulo.");
        }

        try{
            String SQL = "UPDATE proprietarios set nome_prop=?, endereco=?, fone=? WHERE ID_prop=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setString(1, prop.getNome_prop());
            ps.setString(2, prop.getEndereco());
            ps.setString(3, prop.getFone());
            ps.setInt(4, prop.getID_prop());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao editar proprietário " + sqle);
        }
        finally{
           Conexao.close(connL,ps);
        }
    }

    
    
   
}
