<%-- 
    Document   : inicio_sesion_usuario
    Created on : 13/11/2020, 03:25:14 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="http://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

        <title>Iniciar sesion</title>
    </head>
    <body>
    <center>  <h1>Inicia sesion como desarrollador</h1>
        <form method="post" class="container"  action="Servidor">          
            <span>Correo electronico</span>
             <br>
             <input type="email" name="correo_usuario" required="">
             <br>
             <span>Contraseña</span>
             <br>
             <input type="password" name="contrasena_usuario" required="">
             <br>
             <input type="submit" id="btnSd" value="enviar">
             <input type="hidden" name="pagina" value="inicio_sesion_usuario">
             <%--Formulario el cual tiene que llenar el usuario para poder ingresar, con sus respectivos campos del correo electronico y la contraseña
             dichos datos son enviados al servidor en el paquete de servidores, en este caso es para ingresar como empresa
             
             --%>
            
        </form><center/>
    </body>
</html>
