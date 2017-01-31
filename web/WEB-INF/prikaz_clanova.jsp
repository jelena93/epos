<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : prikaz_clanova
    Created on : Apr 21, 2016, 11:55:05 PM
    Author     : Jelena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Karate klub | Prikaz clanova</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="../resources/apple-touch-icon" href="../resources/apple-touch-icon.png">
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
        <link rel="icon" href="../resources/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="../resources/css/main.css">
        <script src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>
        <%@include file="meni.jsp" %>
        <div class="container">
            <h3>Prikaz svih clanova</h3>
            <hr/>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Broj clana</th>
                            <th>Ime</th>
                            <th>Prezime</th>
                            <th>Kontakt</th>
                            <th>Pojas</th>
                            <th>Akcija</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="clan" items="${clanovi}">
                            <tr>
                                <td>${clan.brojClana} </td>
                                <td>${clan.ime} </td>
                                <td>${clan.prezime} </td>
                                <td>${clan.kontakt} </td>
                                <td>${clan.pojasId.bojaPojasa} </td>
                                <td><a href="../action/prikaz_clana?brojClana=${clan.brojClana}">Detalji</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="../resources/js/vendor/jquery-1.11.2.js"><\/script>')
        </script>

        <script src="../resources/js/vendor/bootstrap.min.js"></script>
        <script src="../resources/js/main.js"></script>
    </body>
</html>
