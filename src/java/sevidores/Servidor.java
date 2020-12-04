
package sevidores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clases.*;
import javax.servlet.RequestDispatcher;


public class Servidor extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servidor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String pagina= request.getParameter("pagina");
            if(pagina.equals("registro_usuario")){
                String identificacion_usuario = new String(request.getParameter("identificacion_usuario").getBytes("ISO-8859-1"),"UTF-8");
                String nombre_usuario = new String(request.getParameter("nombre_usuario").getBytes("ISO-8859-1"),"UTF-8");
                String apellido_usuario = new String(request.getParameter("apellido_usuario").getBytes("ISO-8859-1"),"UTF-8");
                String correo_usuario = new String(request.getParameter("correo_usuario").getBytes("ISO-8859-1"),"UTF-8");
                String contrasena_usuario = new String(request.getParameter("contrasena_usuario").getBytes("ISO-8859-1"),"UTF-8");
                String telefono_usuario = new String(request.getParameter("telefono_usuario").getBytes("ISO-8859-1"),"UTF-8");
                String fecha_nacimiento = new String(request.getParameter("fecha_nacimiento").getBytes("ISO-8859-1"),"UTF-8");
                String genero_usuario = new String(request.getParameter("genero_usuario").getBytes("ISO-8859-1"),"UTF-8");
                usuarioDAO insert=new usuarioDAO(identificacion_usuario, nombre_usuario, apellido_usuario, correo_usuario, contrasena_usuario, telefono_usuario, fecha_nacimiento, genero_usuario);
                insert.registro();
                RequestDispatcher despachador = request.getRequestDispatcher("inicio_sesion_usuario.jsp");
                despachador.forward(request, response);
                
             /* Aqui se insertan los datos en la base de datos con los campos que el usuario haya digitado en el registro del usuario */
                
            }
            /**
             * 
             */
            else if(pagina.equals("registro_empresa")){
                String nit_empresa = new String(request.getParameter("nit_empresa").getBytes("ISO-8859-1"),"UTF-8");
                String nombre_empresa = new String(request.getParameter("nombre_empresa").getBytes("ISO-8859-1"),"UTF-8");
                String correo_empresa = new String(request.getParameter("correo_empresa").getBytes("ISO-8859-1"),"UTF-8");
                String contrasena_empresa = new String(request.getParameter("contrasena_empresa").getBytes("ISO-8859-1"),"UTF-8");
                String telefono_empresa = new String(request.getParameter("telefono_empresa").getBytes("ISO-8859-1"),"UTF-8");
                String ubicacion_empresa = new String(request.getParameter("ubicacion_empresa").getBytes("ISO-8859-1"),"UTF-8");
                empresaDAO insert=new empresaDAO(nit_empresa, nombre_empresa, correo_empresa, contrasena_empresa, telefono_empresa, ubicacion_empresa);
                insert.registro();
                RequestDispatcher despachador = request.getRequestDispatcher("inicio_sesion_empresa.jsp");
                despachador.forward(request, response);
          /* Aqui se insertan los datos en la base de datos con los campos que el usuario haya digitado en el registro de la empresa */
            }
            
            else if(pagina.equals("inicio_sesion_usuario")){
                int codigo_usuario  ;
                String correo_usuario = new String(request.getParameter("correo_usuario").getBytes("ISO-8859-1"),"UTF-8");
                String contrasena_usuario = new String(request.getParameter("contrasena_usuario").getBytes("ISO-8859-1"),"UTF-8");
                usuarioDAO insert=new usuarioDAO();
                codigo_usuario = insert.incio_sesion(correo_usuario,contrasena_usuario );
                    if (codigo_usuario != -1) {
                         RequestDispatcher despachador = request.getRequestDispatcher("indexDesarrollador.html");
                        despachador.forward(request, response);   
                         /* Aqui se comparan los datos ingresados del inicio de sesion del usuario con los de la base de datos, si los datos coinciden
                        /* el usuario es llevado a la pagina principal con la sesion creada
                        */
                } else {
                         RequestDispatcher despachador = request.getRequestDispatcher("inicio_sesion_usuario.jsp");
                despachador.forward(request, response);
                /* Si los datos ingresados con coinciden con los datos de la base de datos, si estos no coinciden el usuario es devuelto al inicio de sesion y los campos son vaciados
                */
                }
                
            }
            else if(pagina.equals("inicio_sesion_empresa")){
                int codigo_empresa ; 
                String nit_empresa = new String(request.getParameter("nit_empresa").getBytes("ISO-8859-1"),"UTF-8");
                String correo_empresa = new String(request.getParameter("correo_empresa").getBytes("ISO-8859-1"),"UTF-8");
                String contrasena_empresa = new String(request.getParameter("contrasena_empresa").getBytes("ISO-8859-1"),"UTF-8");               
                empresaDAO insert=new empresaDAO();
                codigo_empresa = insert.incio_sesion_empresa(nit_empresa,correo_empresa,contrasena_empresa );
                    if (codigo_empresa != -1) {
                         RequestDispatcher despachador = request.getRequestDispatcher("indexEmpresa.html");
                        despachador.forward(request, response);
                          /* Aqui se comparan los datos ingresados del inicio de sesion de la empresa con los de la base de datos, si los datos coinciden
                        /* el usuario es llevado a la pagina principal con la sesion creada
                        */
                } else {
                         RequestDispatcher despachador = request.getRequestDispatcher("inicio_sesion_empresa.jsp");
                despachador.forward(request, response);
                /* Si los datos ingresados con coinciden con los datos de la base de datos, si estos no coinciden el usuario es devuelto al inicio de sesion y los campos son vaciados
                */
                }
                
                
                
                
                
            }
                        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
