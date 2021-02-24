/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import static java.lang.reflect.Array.get;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George
 */
public class PersonaDAO implements CRUD{
    Conexion cn = new Conexion();
    Connection con; 
    PreparedStatement ps;
    ResultSet rs;
    Persona p= new Persona();
    
    @Override
    
    public List listar(){
        ArrayList<Persona>list = new ArrayList<>();
        String sql = "select * from cliente";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Persona per= new Persona();
                per.setId(rs.getInt("ID"));
                per.setNombre(rs.getString("NOMBRE"));
                per.setCedula(rs.getString("CEDULA"));
                per.setMarcaCarro(rs.getString("MARCA_CARRO"));
                list.add(per);
            }
        }catch (Exception e){
            System.out.println("Error " + e);
        }
        return list;
    }
    
   

    @Override
    public Persona list(int id) {
        String sql = "select * from cliente where id="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("ID"));
                p.setNombre(rs.getString("NOMBRE"));
                p.setCedula(rs.getString("CEDULA"));
                p.setMarcaCarro(rs.getString("MARCA_CARRO"));
                
            }
        }catch (Exception e){
            System.out.println("Error " + e);
        }
        return p;
      }

    @Override
    public boolean add(Persona per) {
        
        String sql = "INSERT INTO cliente (NOMBRE, CEDULA, MARCA_CARRO) VALUES('" +per.getNombre()+ "','" +per.getCedula()+ "','" +per.getMarcaCarro() +"')";
        
        try{
            con=cn.getConnection();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
        }
        catch (SQLException e){
            System.out.append("maybe esto no funciono, por esto dejo este  mensaje "+e);
        }
        return true;
    }

    @Override
    public boolean editar(Persona per) {
    String sql = "UPDATE cliente SET NOMBRE = '" +per.getNombre()+ "', CEDULA= '" +per.getCedula()+ "', MARCA_CARRO= '" +per.getMarcaCarro() +"' WHERE ID ='"+ per.getId()+  "'";
      try{
            con=cn.getConnection();
          ps=con.prepareStatement(sql);
          ps.executeUpdate(); 
        }
        catch (SQLException e){
            System.out.append("maybe esto no funciono, por esto dejo este  mensaje "+e);
        }
      return true;
        
    }
    
    public boolean eliminars(int id) {
    String sql = "delete from cliente where ID="+id;
    
    try{
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        
    }catch (Exception e){
        
    }
    return false;
    }
    
    @Override
    public boolean eliminar(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        
}
