
package DAO;
   import Classes.Coelhos;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoelhosDAO {
      
   private Connection conn;
     public CoelhosDAO() {
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
        ArrayList Criador = new ArrayList();

        try {
            String SQL = "SELECT * FROM coelhos ORDER BY nome";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_coelho = rs.getInt("ID_coelho");
                String nome = rs.getString("nome");
                String raca = rs.getString("raca");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                Date data_nasc = rs.getDate("data_nasc");
                float peso = rs.getFloat("peso");
                String cor = rs.getString("cor");

                Criador.add(new Coelhos(ID_coelho, nome, raca, data_nasc, sexo, peso, cor));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return Criador;
    }
    
    public void inserir(Coelhos coelho) {         
        PreparedStatement ps = null;
        Connection connL = null;        
        if (coelho == null){
            System.out.println("O objeto coelho não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO coelhos (nome, raca, data_nasc, sexo, peso, cor) " +
                    "values (?,?,?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setString(1, coelho.getNome());
            ps.setString(2, coelho.getRaca());
        
            java.util.Date dataJAVA = coelho.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setString(4, Character.toString(coelho.getSexo()));
	    ps.setFloat(5, coelho.getPeso());
            ps.setString(6, coelho.getCor());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao inserir um novo coelho" + sqle);
        }
        finally{
           Conexao.close(connL,ps);
        }
    }
    
    public Coelhos procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Coelhos coelho = new Coelhos();
        coelho = null;

        try{
            String SQL = "SELECT ID_coelho,nome,raca,data_nasc,sexo,peso,cor FROM coelhos WHERE ID_coelho = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
           
            
            while( rs.next()){
              int ID_coelho = rs.getInt("ID_coelho");
              String nome = rs.getString("nome");
              String raca = rs.getString("raca");
              Date data_nasc = rs.getDate("data_nasc");
              char sexo;
              if (rs.getString("sexo") == null) {
                    sexo =' ' ;
                }
              else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
              
              float peso = rs.getFloat("peso");
              String cor = rs.getString("cor");
              
              coelho = new Coelhos(ID_coelho, nome, raca, data_nasc,sexo, peso, cor); 
              
            }
            
            
            
        }catch(SQLException sqle){
            System.out.println("Erro ao procurar coelho " + sqle);
        }
        finally{
          // ConexaoAulaDAO.close(connL,ps);
        }
        return coelho;
    }   
    
    public void excluir(Coelhos coelho){
        PreparedStatement ps = null;
        Connection connL = null;
        if (coelho == null){
           System.out.println("O objeto coelho não pode ser nulo.");
        }

        try{
            String SQL = "DELETE FROM coelhos WHERE ID_coelho=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, coelho.getID_coelho());
            ps.executeUpdate();
        }catch(SQLException sqle){
          System.out.println("Erro ao excluir coelho " + sqle);
        }
        finally{
          Conexao.close(connL,ps);
        }
    }
          public void atualizar(Coelhos coelho) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (coelho == null){
             System.out.println("O objeto coelho não pode ser nulo.");
        }

        try{
            String SQL = "UPDATE coelhos set nome=?,raca=?,data_nasc=?, sexo=?,  peso=?, cor=? WHERE ID_coelho=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL); 
            ps.setString(1, coelho.getNome());
            ps.setString(2, coelho.getRaca());
            java.util.Date dataJAVA = coelho.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setString(4, Character.toString(coelho.getSexo()));
            ps.setFloat(5, coelho.getPeso());
            ps.setString(6, coelho.getCor());            
            ps.setInt(7, coelho.getID_coelho());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao editar coelho " + sqle);
        }
        finally{
           Conexao.close(connL,ps);
        }
    }

    
    
   
}
