/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario   @param nombre
 * 
 */
public class empresaDAO {
    private int Codigo_empresa;
    private String nit_empresa;
    private String nombre_empresa ;
    private String correo_empresa ;
    private String contrasena_empresa;
    private String telefono_empresa;
    private String ubicacion_empresa;
    Connection conexion = null;
    PreparedStatement ps;
    ResultSet res;   
    String bd="dbdevjobs";
    String url="jdbc:mysql://localhost:3306/"+bd;
    String user="root";
    String pass="";

    public empresaDAO( String nit_empresa, String nombre_empresa, String correo_empresa, String contrasena_empresa, String telefono_empresa, String ubicacion_empresa) {
        this.nit_empresa = nit_empresa;
        this.nombre_empresa = nombre_empresa;
        this.correo_empresa = correo_empresa;
        this.contrasena_empresa = contrasena_empresa;
        this.telefono_empresa = telefono_empresa;
        this.ubicacion_empresa = ubicacion_empresa;
        
        
        
    }
    /*Esta seccion se utiliza para guardar los nombres de los campos en la base datos para poder compararlos a la hora de logearse*/
    
    public empresaDAO(){
    
    }
   
    
       public void registro(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
                try {
                    conexion= DriverManager.getConnection(url,user,pass);
                   
                    String sql ="insert into TBregitro_empresa(nit_empresa, nombre_empresa, correo_empresa, contrasena_empresa, telefono_empresa, ubicacion_empresa) values(?, ?, ?, ?, ?, ?)";
                    ps= conexion.prepareStatement(sql);
                    ps.setString(1, nit_empresa);
                    ps.setString(2, nombre_empresa);
                    ps.setString(3, correo_empresa);
                    ps.setString(4, contrasena_empresa);
                    ps.setString(5, telefono_empresa);
                    ps.setString(6, ubicacion_empresa);
                    ps.execute();
                    ps.close();
                    ps=null;
                    conexion.close();
                            
            } catch (SQLException ex) {
                    System.out.println(ex);
            }
                    
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        /* Aqui se realiza la propia conexion con la base datos y se piden los campos respectivos */
    }
       
       public int incio_sesion_empresa(String nit, String correo, String contrasena){
            int codigo = -1;
             try {
            Class.forName("com.mysql.jdbc.Driver");
                try {
                    conexion= DriverManager.getConnection(url,user,pass);
              
                    String sql ="select * from TBregitro_empresa where  nit_empresa=? and correo_empresa=? and contrasena_empresa=?";
                    ps= conexion.prepareStatement(sql);     
                    ps.setString(1, nit);
                    ps.setString(2, correo);
                    ps.setString(3, contrasena);
                    res= ps.executeQuery();
                    while(res.next()){
                        codigo = res.getInt("Codigo_empresa");
                        
                    }
                    ps.close();
                    ps=null;
                    conexion.close();
                            
            } catch (SQLException ex) {
                    System.out.println(ex);
                    
            }
                    
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
      return codigo; 
      /* Aqui se realiza la consulta para verficar si el usuario realmente esta registrado */
    } 
    public int getCodigo_empresa() {
        return Codigo_empresa;
        
    }
   /**
    * 
    * @param Codigo_empresa es para poder recopilar la respuesta de la consuta
    */

    public void setCodigo_empresa(int Codigo_empresa) {
        this.Codigo_empresa = Codigo_empresa;
        
    }
    
    
    public String getNit_empresa() {
        return nit_empresa;
       
    }
/**
 * 
 * @param nit_empresa es para poder recopilar la respuesta de la consuta y poder enviar el nit de la empresa
 */
    public void setNit_empresa(String nit_empresa) {
        this.nit_empresa = nit_empresa;
       
    }

    public String getNombre_empresa() {
        return nombre_empresa;
       
    }
  /**
   * 
   * 
   * @param nombre_empresa  es para poder recopilar la respuesta de la consuta y poder enviar el nombre de la empresa
   */
    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
       
    }

    public String getCorreo_empresa() {
        return correo_empresa;
        
    }
 /**
  * 
  * @param correo_empresa es para poder recopilar la respuesta de la consuta y poder enviar el correo de la empresa
  */
    public void setCorreo_empresa(String correo_empresa) {
        this.correo_empresa = correo_empresa;
       
        
    }

    public String getContrasena_empresa() {
        return contrasena_empresa;
        
    }

    /**
     * 
     * @param contrasena_empresa es para poder recopilar la respuesta de la consuta y poder enviar la contraseña de la empresa
     */
    public void setContrasena_empresa(String contrasena_empresa) {
        this.contrasena_empresa = contrasena_empresa;
        
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
         
    }
   /**
    * 
    * @param telefono_empresa es para poder recopilar la respuesta de la consuta y poder enviar el tel de la empresa
    */
    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
     
    }

    public String getUbicacion_empresa() {
        return ubicacion_empresa;
        /* Este metodo get es para poder recopilar la respuesta de la consuta y poder enviar la ubicacion de la empresa */
    }
/**
 * 
 * 
 * @param ubicacion_empresa es para poder recopilar la respuesta de la consuta y poder enviar la ubicacion de la empresa
 */
    public void setUbicacion_empresa(String ubicacion_empresa) {
        this.ubicacion_empresa = ubicacion_empresa;
        /*Se igualan ambas ubicaciones de la empresa con el metodo set*/
    } 

}
