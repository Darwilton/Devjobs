<%-- 
    
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
       <center> <h1>inicia sesion como empresa</h1>
        <form method="post" class="container" action="Servidor">
            <span>Ingrese el Numero De Identificacion Tributaria(NIT)</span>
            <br>
            <input type="text" name="nit_empresa" required="">
            <br>
            <span>Correo electronico</span>
             <br>
             <input type="email" name="correo_empresa" required="">
             <br>
             <span>Contraseña</span>
             <br>
             <input type="password" name="contrasena_empresa" required="">
             <br>
             <input type="submit" id="btnSe" value="enviar">
             <input type="hidden" name="pagina" value="inicio_sesion_empresa">
             <%--Formulario el cual tiene que llenar el usuario para poder ingresar, con sus respectivos campos del correo electronico y la contraseña
             dichos datos son enviados al servidor en el paquete de servidores, en este caso es para ingresar como desarrollador
             
             --%>
        </form><center/>
    </body>
</html>

