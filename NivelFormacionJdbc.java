/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Nivel_Formacion;

/**
 *
 * @author leonardo
 */
public class NivelFormacionJdbc extends Jdbc
{   
    private List listaNivelFormacion;
    Jdbc cone = new Jdbc();
    
     public void saveNivelFormacion(Nivel_Formacion nf)throws SQLException 
    {
        PreparedStatement pstt = null;
        try
        {
            pstt = this.getCon().prepareStatement("insert into nivelformacion values(?,?,?,?)");
            pstt.setString(1, null);
            pstt.setInt(2, nf.getIdNivelFormacion());
            pstt.setString(3, nf.getNombre());
            pstt.setString(4, nf.getEstado());
            
            if((getFormacion(nf.getIdNivelFormacion()).getNombre()==null))
            {
               if(nf.getNombre()!=null)
               {
                   pstt.executeUpdate();
                   JOptionPane.showMessageDialog(null, "El Producto fue Registrado Correctamente!");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Campos Vacíos");
                   
               }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Producto que registra ya existe");
            }
        }
        finally
        {
            if(pstt!=null)
            {
                pstt.close();
            }
        }
    }
    
    public void updateNivelFormacion(Nivel_Formacion nf) throws SQLException
    {
        PreparedStatement pstn = null;
        try
        {
            pstn=this.getCon().prepareStatement("update nivelformacion set idnivelformacion=?,nombre=?,estado=?");
            pstn.setInt(1, nf.getIdNivelFormacion());
            pstn.setString(2, nf.getNombre());
            pstn.setString(3, nf.getEstado());
            pstn.executeUpdate();
            
             if((getFormacion(nf.getIdNivelFormacion()).getNombre()==null))
            {
               if(nf.getNombre()!=null)
               {
                   pstn.executeUpdate();
                   JOptionPane.showMessageDialog(null, "El Producto fue Registrado Correctamente!");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Campos Vacíos");
                   
               }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Producto que registra ya existe");
            }
            
            
        }
        finally
        {
            if(pstn!=null)
            pstn.close();
        }
    }
    
    public Nivel_Formacion getFormacion(int idnivelformacion) throws SQLException 
    {
        Nivel_Formacion nf = new Nivel_Formacion();
        PreparedStatement pstt = null;
        ResultSet rs = null;
        try 
        {
            pstt =this.getCon().prepareStatement("select * from nivelformacion where idnivelformacion=?");
            pstt.setInt(1, idnivelformacion);
            rs = pstt.executeQuery();
            while (rs.next()) 
            {
                nf = load(rs);
            }
        } 
        finally 
        {
            if (pstt != null) 
            {
                pstt.close();
            }
            if (nf != null) 
            {
                rs.close();
            }
        }
        return nf;
    }
    
    public List getNivelFormacion() throws SQLException 
    {
        listaNivelFormacion = new LinkedList();
        PreparedStatement pstt = null;
        ResultSet rs = null;
        try 
        {
            pstt = this.getCon().prepareStatement("select * from nivelformacion where idnivelformacion=?");
            rs = pstt.executeQuery();
            while (rs.next()) 
            {
                listaNivelFormacion.add(load(rs));
            }
        } 
        finally 
        {
            if (pstt != null) 
            {
                pstt.close();
            }
            if (rs != null) 
            {
                rs.close();
            }
        }
        return listaNivelFormacion;
    }

    private Nivel_Formacion load(ResultSet rs) throws SQLException 
    {
        Nivel_Formacion nf = new Nivel_Formacion();
        nf.setIdNivelFormacion(rs.getInt(2));
        nf.setNombre(rs.getString(3));
        nf.setEstado(rs.getString(4));
        
        return nf;
    }
    
    public void DeleteNivelFormacion(int idnivelformacion)throws SQLException 
    {
        PreparedStatement pstn=null;
        try
        {
            pstn= this.getCon().prepareStatement("delete from nivelformacion where idnivelformacion=?");
            pstn.setInt(1, idnivelformacion);
            pstn.executeUpdate();
        }
        finally
        {
            if(pstn != null)
            {
                pstn.close();
            }
        }
    }
}
