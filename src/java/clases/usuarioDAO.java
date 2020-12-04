
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class usuarioDAO {
    private int Codigo_usuario;
    private String identificacion_usuario;
    private String nombre_usuario ;
    private String apellido_usuario ;
    private String correo_usuario;
    private String contrasena_usuario;
    private String telefono_usuario;
    private String fecha_nacimiento;
    private String genero_usuario;
    Connection conexion = null;
    PreparedStatement ps;
    ResultSet res;   
    String bd="dbdevjobs";
    String url="jdbc:mysql://localhost:3306/"+bd;
    String user="root";
    String pass="";

    public usuarioDAO(String identificacion_usuario, String nombre_usuario, String apellido_usuario, String correo_usuario, String contrasena_usuario, String telefono_usuario, String fecha_nacimiento, String genero_usuario) {
        this.identificacion_usuario = identificacion_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.correo_usuario = correo_usuario;
        this.contrasena_usuario = contrasena_usuario;
        this.telefono_usuario = telefono_usuario;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero_usuario = genero_usuario;   
        /*Esta seccion se utiliza para guardar los nombres de los campos en la base datos para poder compararlos a la hora de logearse*/
    }
    public usuarioDAO(){
    
    }
    public void registro(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
                try {
                    conexion= DriverManager.getConnection(url,user,pass);
                    System.out.println("XD ENTRO A REGISTRO");
                    String sql ="insert into tbregistro_usuarios(identificacion_usuario, nombre_usuario, apellido_usuario, correo_usuario, contrasena_usuario, telefono_usuario, fecha_nacimiento, genero_usuario) values(?, ?, ?, ?, ?, ?, ?, ?)";
                    ps= conexion.prepareStatement(sql);
                    ps.setString(1, identificacion_usuario);
                    ps.setString(2, nombre_usuario);
                    ps.setString(3, apellido_usuario);
                    ps.setString(4, correo_usuario);
                    ps.setString(5, contrasena_usuario);
                    ps.setString(6, telefono_usuario);
                    ps.setString(7, fecha_nacimiento );
                    ps.setString(8, genero_usuario);
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
    
    public int incio_sesion(String correo, String contrasena){
            int codigo = -1;
             try {
            Class.forName("com.mysql.jdbc.Driver");
                try {
                    conexion= DriverManager.getConnection(url,user,pass);
                   
                    String sql ="select * from TBregistro_usuarios where correo_usuario=? and contrasena_usuario=?";
                    ps= conexion.prepareStatement(sql);                    
                    ps.setString(1, correo);
                    ps.setString(2, contrasena);
                    res= ps.executeQuery();
                    while(res.next()){
                        codigo = res.getInt("Codigo_usuario");
                        
                    }
                    ps.close();
                    ps=null;
                    conexion.close();
                            
            } catch (SQLException ex) {
                    System.out.println(ex);
                    
            }
            /* Aqui se realiza la consulta para verficar si el usuario realmente esta registrado */        
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
      return codigo; 
    } 
    public int getCodigo_usuario() {
        return Codigo_usuario;
     
    }
    /**
     * 
     * @param Codigo_usuario es para poder recopilar la respuesta de la consuta y poder enviar el codigo del usuario
     */

    public void setCodigo_usuario(int Codigo_usuario) {
        this.Codigo_usuario = Codigo_usuario;
        /*Se igualan ambos codigos del usuario con el metodo set*/
    }

    public String getIdentificacion_usuario() {
        return identificacion_usuario;
        
    }
 /**
  * 
  * 
  * @param identificacion_usuario es para poder recopilar la respuesta de la consuta y poder enviar el codigo de identificacion del usuario
  */
    public void setIdentificacion_usuario(String identificacion_usuario) {
        this.identificacion_usuario = identificacion_usuario;
    
    }

    public String getNombre_usuario() {
        return nombre_usuario;
        
    }
    /**
     * 
     * @param nombre_usuario es para poder recopilar la respuesta de la consuta y poder enviar el nombre del usuario
     */

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
       
    }

    public String getApellido_usuario() {
        return apellido_usuario;

    }
 /**
  * 
  * @param apellido_usuario es para poder recopilar la respuesta de la consuta y poder enviar los apellidos del usuario
  */
    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
        
    }

    public String getCorreo_usuario() {
        return correo_usuario;

    }
    /**
     * 
     * @param correo_usuario es para poder recopilar la respuesta de la consuta y poder enviar el correo del usuario
     */

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
      
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
       
    }
    /**
     * 
     * @param contrasena_usuario es para poder recopilar la respuesta de la consuta y poder enviar la contraseña del usuario
     */

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
       
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
        
    }
    /**
     * 
     * @param telefono_usuario es para poder recopilar la respuesta de la consuta y poder enviar los telefonos del usuario
     */

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
        
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
     
    }
    /**
     * 
     * @param fecha_nacimiento es para poder recopilar la respuesta de la consuta y poder enviar la fecha de nacimiento del usuario
     */

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
        
        
    }

    public String getGenero_usuario() {
        return genero_usuario;
                

        
    }
    /**
     * 
     * @param genero_usuario es para poder recopilar la respuesta de la consuta y poder enviar el genero del usuario 
     */

    public void setGenero_usuario(String genero_usuario) {
        this.genero_usuario = genero_usuario;
        /*Se igualan ambos generos del usuario con el metodo set*/
        
        
    }
                                                            
    
    
}
