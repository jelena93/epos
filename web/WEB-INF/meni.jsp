<%-- 
    Document   : meni
    Created on : Apr 20, 2016, 4:56:00 PM
    Author     : Jelena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%--<jsp:useBean id="ulogovan_korisnik" scope="session" class="domen.Korisnik" />--%>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span> 
                    </button>
                    <a class="navbar-brand" href="../action/pocetna">Karate klub</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Rad sa clanovima                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="../action/unos_clana">Unos clana</a></li>
                                <li><a href="../action/prikaz_clanova">Prikaz svih clanova</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="../odjava"><span class="glyphicon glyphicon-log-out"></span> Odjavi se</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <%--<jsp:useBean id="ulogovan_korisnik" scope="session" class="domen.Korisnik" />--%>
        <div class="pull-right">Trenutno ulogovani korisnik: 
            <%--<jsp:getProperty name="ulogovan_korisnik" property="korisnickoIme" />--%>
        </div>
    </body>
</html>
