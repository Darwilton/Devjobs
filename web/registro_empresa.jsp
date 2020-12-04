<%-- 
    Document   : registro_empresa
    Created on : 13/11/2020, 01:22:52 PM
    Author     : Usuario
--%>

<html>
    <head>
        <title>Registro empresa</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="" />
<meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

    </head>
    <body>
       <center> <h1>registro de empresa</h1>
        <form method="post" action="Servidor" class="container">
            <span>Ingrese el Numero De Identificacion Tributaria(NIT)</span>
            <br>
            <input type="text" name="nit_empresa" required="">
            <br>
             <span>Nombre de la empresa</span>
             <br>
            <input type="text" name="nombre_empresa" required="">
            <br>
             <span>Correo electronico de la empresa</span>
             <br>
            <input type="email" name="correo_empresa" required="">
            <br>
             <span>Contraseña</span>
             <br>
             <input type="password" name="contrasena_empresa" required="">
             <br>
             <span>Telefono empresa</span>
             <br>
            <input type="text" name="telefono_empresa" required="">
            <br>
             <span>Ubicacion de la empresa</span>
             <br>
            <input type="text" name="ubicacion_empresa" required="">
            <br>
             <span>Fecha de nacimiento</span>
             <br>
             <input type="submit" id="btnREe" value="enviar">
             <input type="hidden" name="pagina" value="registro_empresa">
             <%--Formulario con el cual el usuario llena para poder registrarse y con ello poder entrar al login
                 de la empresa usando los mismos datos ingresados
             
             --%>
        </form><center/>
    </body>
</html>
