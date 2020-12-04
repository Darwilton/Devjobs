<%-- 
    Document   : registrousuarios
    Created on : 13/11/2020, 01:54:26 PM
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

        <title>Registro desarrollador</title>
    </head>
    <body>
    <center> <h1>registro de usuario</h1>
        <form method="post"class="container"  action="Servidor">
            <span>Ingrese su numero de identificacion</span>
            <br>
            <input type="text" name="identificacion_usuario" required="">
            <br>
             <span>Nombre</span>
             <br>
            <input type="text" name="nombre_usuario" required="">
            <br>
             <span>Apellido</span>
             <br>
            <input type="text" name="apellido_usuario" required="">
            <br>
             <span>Correo electronico</span>
             <br>
             <input type="email" name="correo_usuario" required="">
             <br>
             <span>Contraseña</span>
             <br>
             <input type="password" name="contrasena_usuario" required="">
            <br>
             <span>Telefono</span>
             <br>
            <input type="text" name="telefono_usuario" required="">
            <br>
             <span>Fecha de nacimiento</span>
             <br>
            <input type="date" name="fecha_nacimiento" required="">
            <br>
             <p>G&eacute;nero</p>
                    <select id="cars" name="genero_usuario" class="formInput">
                        <option  id="M" value="Masculino">Masculino</option>
                        <option id="F" value="Femenino">Femenino</option>
                    </select> 
             <br>
             <input type="submit" id="btnRdd" value="enviar">
             <input type="hidden" name="pagina" value="registro_usuario">
             <%--Formulario con el cual el usuario llena para poder registrarse y con ello poder entrar al login
                 de la empresa usando los mismos datos ingresados,
                 excepto la fecha de nacimiento, telefono, nombre, apellido y el numero de identificacion
             
             --%>
        </form><center/>
    </body>
</html>
