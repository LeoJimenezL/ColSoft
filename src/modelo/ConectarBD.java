/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Estudiante
 */
public class ConectarBD 
{
    private Connection con;
    private String jdbcDriver ="com.mysql.jdbc.Driver";
    private String databaseURL = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "";
    
    public Connection conectar() throws SQLException
    {
        con = DriverManager.getConnection(this.databaseURL, this.user, this.password);
        return con;
    }
    
    public void desconectar() throws SQLException
    {
        if (con!=null) 
        {
           try
           {
               con.close();
           }
           finally
           {
               con=null;
           }
        }
    }
    
    public static void main(String[] args) throws SQLException {
        ConectarBD con = new ConectarBD();
        
        System.out.println("" +  con.conectar());
        
    }
}
