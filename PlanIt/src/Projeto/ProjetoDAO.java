package Projeto;

import db.DBConnection;
import db.DBDriver;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
	Connection con;

    public ProjetoDAO() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, "planit", "root", "V3r3@dor3sMYSQL");
        }
    }
    
    public boolean criarProjeto(Projeto projeto) {
        if(existe(projeto)){
            return false;
        } else {
            String nf = "INSERT INTO projeto (id, nome, andamento) VALUES (?,?,?)";
            PreparedStatement pst;
            try {
                pst = con.prepareStatement(nf);
                pst.setInt(1, projeto.getId());
                pst.setString(2, projeto.getNome());
                pst.setFloat(3, projeto.getAndamento());
                
                int res = pst.executeUpdate();
                if (res == 1) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
    
    public boolean existe(Projeto projeto) {
        try {
            String existe = "SELECT id FROM projeto WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(existe);
            pst.setInt(1, projeto.getId());
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                if (res.getLong("id") == projeto.getId()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }
    
    
       public ArrayList<Projeto> obterTodosProjetos() {          
               String todos = "SELECT * FROM projeto";           
               PreparedStatement ps;                             
               ArrayList<Projeto> projetos = new ArrayList<>();  
               try {                                             
                   ps = con.prepareStatement(todos);             
                   ResultSet rs = ps.executeQuery();             
                   while (rs.next()) {                           
                       Projeto a = new Projeto(rs.getInt("id"), rs.getString("nome"));                
                       a.setAndamento(rs.getFloat("andamento"));         
                       projetos.add(a);                          
                   }                                             
                                                                 
               } catch (SQLException ex) {                       
                   throw new RuntimeException(ex);               
               }                                                 
                                                                 
               return projetos;                              
           }        
       
       
       
      public Projeto obterProjeto(int id) {               
              String projeto = "SELECT * FROM projeto";        

              PreparedStatement ps;                                  
                
              try {                                                  
                  ps = con.prepareStatement(projeto);                  
                  ResultSet rs = ps.executeQuery();    
                  while (rs.next()) {                                
                      Projeto a = new Projeto(rs.getInt("id"), rs.getString("nome"));                                    
                      a.setAndamento(rs.getFloat("andamento"));             
                      if(a.getId() == id) {
                    	  return a;
                      }
                     
                  }                                                  
                                                                     
              } catch (SQLException ex) {                            
                  throw new RuntimeException(ex);                    
              }                                                      
                                                                     
              return null;                                       
          }   
       
       
       
      public boolean updateProjeto(Projeto projeto) {
          String string = "UPDATE projeto SET nome = ?, andamento = ? WHERE id = ?";
          PreparedStatement pst;
          try {
              pst = con.prepareStatement(string);
              pst.setString(1, projeto.getNome());
              pst.setFloat(2, projeto.getAndamento());
              pst.setInt(4, projeto.getId());
              int res = pst.executeUpdate();
              if(res == 1){
                  return true;
              }
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
          return false;
      }
      
      
      public boolean deleteProjeto(Projeto projeto) {
          String string = "DELETE FROM projeto WHERE id = ?";
          PreparedStatement pst;
          try {
              pst = con.prepareStatement(string);
              pst.setInt(1, projeto.getId());
              int res = pst.executeUpdate();
              if(res == 1){
                  return true;
              }
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
          return false;
      }
}
